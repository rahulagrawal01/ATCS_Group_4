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

import com.example.Final.LMS.entity.Admin;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.entity.User;
import com.example.Final.LMS.repositary.AdminRepo;
import com.example.Final.LMS.repositary.CoursesRepo;
import com.example.Final.LMS.repositary.UserRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminRepo repo;
	
	@Autowired
	CoursesRepo crepo;
	
	@Autowired
	UserRepo urepo;

	@GetMapping("/seeadmin/")
	public List<Admin> getDataList() {
		return repo.findAll();
	}
	
	@GetMapping("/seeusers/")
	public List<User> getDataUsers() {
		return urepo.findAll();
	}
	
	@GetMapping("/seecourses/")
	public List<Courses> getData() {
		return crepo.findAll();
	}

	@PostMapping("/addcourse/")
	public ResponseEntity<String> saveData(@RequestBody Courses obj) {
		try {
			
			crepo.save(obj);
			return new ResponseEntity<>("Working fine || Course added successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addadmin/")
	public ResponseEntity<String> saveData(@RequestBody Admin obj) {
		
		try {
			
			repo.save(obj);
			return new ResponseEntity<>("Working fine || Admin added successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	  @DeleteMapping("/deleteuser/{id}")
	  public ResponseEntity<String> deleteuserbyid(@PathVariable("id") long id)
	  {
		  try {
			  
			  urepo.deleteById(id); 
			  return new ResponseEntity<>("Working fine || User Deleted Successfully ||", HttpStatus.OK);
		  }
		  catch(Exception e){
				return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
			}
	  }  
	  
	  
	@DeleteMapping("/deletecourse/{id}")
	public ResponseEntity<String> deleteData(@PathVariable long id) {
		try {
			
			crepo.deleteById(id);
			return new ResponseEntity<>("Working fine || User Deleted By Id Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/editcourse/{id}")
	public ResponseEntity<Courses> updatecourse(@PathVariable("id") long id,@RequestBody Courses obj)  {
		Courses updatecourse = crepo.findById(id)
                .orElseThrow(null);
		updatecourse.setCourseName(obj.getCourseName());
		updatecourse.setCourseDescription(obj.getCourseDescription());
		updatecourse.setCourseLink(obj.getCourseLink());
		updatecourse.setCourseDuration(obj.getCourseDuration());
		updatecourse.setCoursePrice(obj.getCoursePrice());
		crepo.save(updatecourse);

        return ResponseEntity.ok(updatecourse);
	}
	
}
