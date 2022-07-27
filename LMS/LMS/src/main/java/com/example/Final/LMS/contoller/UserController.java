package com.example.Final.LMS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Final.LMS.entity.Cart;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.entity.User;
import com.example.Final.LMS.repositary.CartRepo;
import com.example.Final.LMS.repositary.CoursesRepo;
import com.example.Final.LMS.repositary.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo repo;

	@Autowired
	CoursesRepo crepo;

	@Autowired
	CartRepo cartrepo;

	@GetMapping("/seecourses/")
	public List<Courses> getDataList() {
		return crepo.findAll();
	}

	@GetMapping("/seecart/")
	public List<Cart> getDataCourses() {
		return cartrepo.findAll();
	}

	@PostMapping("/adduser/")
	public ResponseEntity<String> saveData(@RequestBody User obj) {
		try {
			
			repo.save(obj);
			return new ResponseEntity<>("Working fine || User Added Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletecourse/{id}")
	public void deleteuserbyid(@PathVariable("id") long id) {
		repo.deleteById(id);
	}

	@PutMapping("/")
	public ResponseEntity<String> updateData(@RequestBody User obj) {
		try {
			
			repo.save(obj);
			return new ResponseEntity<>("Working fine || User Details Updated Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

}
