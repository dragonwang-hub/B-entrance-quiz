package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.Dto.Students;
import com.thoughtworks.capability.gtb.entrancequiz.Service.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}
}
