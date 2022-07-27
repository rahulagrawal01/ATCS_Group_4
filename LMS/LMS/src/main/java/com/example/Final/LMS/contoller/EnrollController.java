package com.example.Final.LMS.contoller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Final.LMS.entity.Enroll;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.repositary.CoursesRepo;
import com.example.Final.LMS.repositary.EnrollRepo;

@RestController
@RequestMapping("/enroll")
public class EnrollController {

	@Autowired
	EnrollRepo erepo;

	@Autowired
	CoursesRepo courserepo;


	
	@GetMapping("/seeenroll/")
	public List<Enroll> getData() {
		return erepo.findAll();
	}

	@GetMapping("/seeenroll/{id}")
	public List<Enroll> findbyid(@PathVariable("id") long id) {
		List<Enroll> enrolled = erepo.findAll();
		// List<Cart> c = carts.stream().filter(e->e.getUser().getUserId() ==
		// id).collect(Collectors.toList());
		List<Enroll> newEnroll = new ArrayList<Enroll>();
		for (Enroll envar : enrolled) {
			if (envar.getUser().getId() == id) {
				newEnroll.add(envar);
			}
		}
		return newEnroll;
	}

	@PostMapping("/addtoenroll/")
	public ResponseEntity<String> saveData(@RequestBody Enroll enroll) {
		try {
			
			erepo.save(new Enroll(enroll.getId(), enroll.getCourse(), enroll.getUser()));
			return new ResponseEntity<>("Working fine || Course Enrolled  Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletefromenroll/{uid}/{cid}")
	public void deletecoursebyid(@PathVariable("uid") long userid, @PathVariable("cid") long courseid) {	
			List<Enroll> enrollList = erepo.findAll();
			List<Courses> courseListNew = new ArrayList<Courses>();
			for (Enroll envar : enrollList) {
				if (envar.getUser().getId() == userid) {
					for (Courses coursevar : envar.getCourse()) {
						if (coursevar.getId() == courseid) {
						} else {
							courseListNew.add(coursevar);
						}
					}
					envar.setCourse(courseListNew);
					erepo.save(envar);
				}
			}
		courserepo.deleteById(courseid);
	}
}