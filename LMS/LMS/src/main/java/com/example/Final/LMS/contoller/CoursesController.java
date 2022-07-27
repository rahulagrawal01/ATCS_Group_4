package com.example.Final.LMS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.repositary.CoursesRepo;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	CoursesRepo repo;

	@GetMapping("/seecourses/")
	public List<Courses> getData() {
		return repo.findAll();
	}

}