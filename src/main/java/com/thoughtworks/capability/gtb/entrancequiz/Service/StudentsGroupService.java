package com.thoughtworks.capability.gtb.entrancequiz.Service;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentsGroupService {

    static List<Students> StudentsList;

    @PostConstruct
    public void initData() {
        StudentsList = new ArrayList<>();
        String[] names = {"成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰",
                "雅典娜", "芈月", "白起", "刘禅", "庄周",
                "马超", "刘备", "哪吒", "大乔", "蔡文姬"};
        for (int i = 0; i < names.length; i++) {
            Students student = new Students(i + 1, names[i]);
            StudentsList.add(student);
        }
    }

    public List<Students> getAll() {
        return StudentsList;
    }
}
