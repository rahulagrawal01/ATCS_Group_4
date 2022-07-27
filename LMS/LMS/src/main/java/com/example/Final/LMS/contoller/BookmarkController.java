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

import com.example.Final.LMS.entity.Bookmark;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.repositary.BookmarkRepo;
import com.example.Final.LMS.repositary.CoursesRepo;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {

	@Autowired
	BookmarkRepo brepo;

	@Autowired
	CoursesRepo courserepo;

	
	@GetMapping("/seebookmark/")
	public List<Bookmark> getData() {
		return brepo.findAll();
	}

	@GetMapping("/seebookmark/{id}")
	public List<Bookmark> findbyid(@PathVariable("id") long id) {
		List<Bookmark> carts = brepo.findAll();
		// List<Cart> c = carts.stream().filter(e->e.getUser().getUserId() ==
		// id).collect(Collectors.toList());
		List<Bookmark> newBookmark = new ArrayList<Bookmark>();
		for (Bookmark bmvar : carts) {
			if (bmvar.getUser().getId() == id) {
				newBookmark.add(bmvar);
			}
		}
		return newBookmark;
	}

	@PostMapping("/addtobookmark/")
	public ResponseEntity<String> saveData(@RequestBody Bookmark bookmark) {
		
		try {
			
			brepo.save(new Bookmark(bookmark.getId(), bookmark.getCourse(), bookmark.getUser()));
			return new ResponseEntity<>("Working fine || Course BookMarked Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deletefrombookmark/{uid}/{cid}")
	public void deletecoursebyid(@PathVariable("uid") long userid, @PathVariable("cid") long courseid) {	
			List<Bookmark> bookmarkList = brepo.findAll();
			List<Courses> courseListNew = new ArrayList<Courses>();
			for (Bookmark bmvar : bookmarkList) {
				if (bmvar.getUser().getId() == userid) {
					for (Courses coursevar : bmvar.getCourse()) {
						if (coursevar.getId() == courseid) {
						} else {
							courseListNew.add(coursevar);
						}
					}
					bmvar.setCourse(courseListNew);
					brepo.save(bmvar);
				}
			}
		courserepo.deleteById(courseid);
	}
}