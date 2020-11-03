package com.thoughtworks.capability.gtb.entrancequiz;

// TODO GTB-工程实践: - 未使用的import语句
import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO GTB-工程实践: * 包名不符合规范
// TODO GTB-工程实践: * 注意单一职责，group和student应该有单独的Controller和Service
// TODO GTB-知识点: * 需要了解下三层架构
// TODO GTB-知识点: * 需要了解Restful实践
// TODO GTB-知识点: * 了解下lombok的使用
// TODO GTB-完成度: * 没有实现专门查询分组的接口
// TODO GTB-测试: * 有Controller层测试，且覆盖了已完成的功能
// TODO GTB-工程实践: * 需要加强面向对象的意识
@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}
}
