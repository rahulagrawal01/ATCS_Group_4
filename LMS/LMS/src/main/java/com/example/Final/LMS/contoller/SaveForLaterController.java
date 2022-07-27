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

import com.example.Final.LMS.entity.SaveForLater;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.repositary.CoursesRepo;
import com.example.Final.LMS.repositary.SaveForLaterRepo;

@RestController
@RequestMapping("/saveforlater")
public class SaveForLaterController {

	@Autowired
	SaveForLaterRepo srepo;

	@Autowired
	CoursesRepo courserepo;


	
	@GetMapping("/seesaveforlater/")
	public List<SaveForLater> getData() {
		return srepo.findAll();
	}

	@GetMapping("/seesaveforlater/{id}")
	public List<SaveForLater> findbyid(@PathVariable("id") long id) {
		List<SaveForLater> saved = srepo.findAll();
		// List<Cart> c = carts.stream().filter(e->e.getUser().getUserId() ==
		// id).collect(Collectors.toList());
		List<SaveForLater> newSaved = new ArrayList<SaveForLater>();
		for (SaveForLater svar : saved) {
			if (svar.getUser().getId() == id) {
				newSaved.add(svar);
			}
		}
		return newSaved;
	}

	@PostMapping("/addtosaveforlater/")
	public ResponseEntity<String> saveData(@RequestBody SaveForLater saved) {
		try {
			
			srepo.save(new SaveForLater(saved.getId(), saved.getCourse(), saved.getUser()));
			return new ResponseEntity<>("Working fine || Course Saved for latter   Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletefromsaveforlater/{uid}/{cid}")
	public void deletecoursebyid(@PathVariable("uid") long userid, @PathVariable("cid") long courseid) {	
			List<SaveForLater> savedList = srepo.findAll();
			List<Courses> courseListNew = new ArrayList<Courses>();
			for (SaveForLater svar : savedList) {
				if (svar.getUser().getId() == userid) {
					for (Courses coursevar : svar.getCourse()) {
						if (coursevar.getId() == courseid) {
						} else {
							courseListNew.add(coursevar);
						}
					}
					svar.setCourse(courseListNew);
					srepo.save(svar);
				}
			}
		courserepo.deleteById(courseid);
	}
}