package com.thoughtworks.capability.gtb.entrancequiz.Service;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class StudentsGroupService {

    // TODO GTB-知识点: - 应该使用Repository层保存数据
    static List<Students> studentsList;
    static Map<String, List<Students>> studentsGroup;

    @PostConstruct
    public void initData() {
        studentsList = new ArrayList<>();
        String[] names = {"成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰",
                "雅典娜", "芈月", "白起", "刘禅", "庄周",
                "马超", "刘备", "哪吒", "大乔", "蔡文姬"};
        // TODO GTB-知识点: - 以下代码可以使用Java8 Stream简化
        for (int i = 0; i < names.length; i++) {
            Students student = new Students(i + 1, names[i]);
            studentsList.add(student);
        }
    }

    public List<Students> getAll() {
        return studentsList;
    }

    public void addStudent(String name) {
        int size = studentsList.size();
        // TODO GTB-工程实践: - 计算id的方式不够健壮，可以使用字段保存最大id
        Students student = new Students(size + 1, name);
        studentsList.add(student);
    }

    // TODO GTB-工程实践: - 长方法，建议抽子方法来提高可读性
    public Map<String, List<Students>> groupStudents() {
        studentsGroup = new HashMap<>();
        List<Students> tempAll = new ArrayList<>();
        tempAll.addAll(studentsList);
        // TODO GTB-工程实践: - Magic Number
        int groupsSize = 6;

        // TODO GTB-知识点: - 打乱顺序可以了解下Collections.shuffle()
        Random random = new Random();
        while (tempAll.size() != 0) {
            for (int i = 1; i <= groupsSize; i++) {
                String groupsName = i + " 组";
                List<Students> iGroupList;
                if (!studentsGroup.containsKey(groupsName)) {
                    iGroupList = new ArrayList<>();
                } else {
                    iGroupList = studentsGroup.get(groupsName);
                }
                if (tempAll.size() == 0) {
                    break;
                }
                int n = random.nextInt(tempAll.size());
                iGroupList.add(tempAll.get(n));
                tempAll.remove(tempAll.get(n));
                studentsGroup.put(groupsName, iGroupList);
            }
        }
        return studentsGroup;
    }
}
