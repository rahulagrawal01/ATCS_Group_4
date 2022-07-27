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

import com.example.Final.LMS.entity.Cart;
import com.example.Final.LMS.entity.Courses;
import com.example.Final.LMS.entity.Enroll;
import com.example.Final.LMS.repositary.CartRepo;
import com.example.Final.LMS.repositary.CoursesRepo;
import com.example.Final.LMS.repositary.EnrollRepo;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartRepo crepo;

	@Autowired
	CoursesRepo courserepo;

	@Autowired
	EnrollRepo erepo;
	
	@GetMapping("/seecart/")
	public List<Cart> getData() {
		return crepo.findAll();
	}

	@GetMapping("/seecart/{id}")
	public List<Cart> findbyid(@PathVariable("id") long id) {
		List<Cart> carts = crepo.findAll();
		// List<Cart> c = carts.stream().filter(e->e.getUser().getUserId() ==
		// id).collect(Collectors.toList());
		List<Cart> newCart = new ArrayList<Cart>();
		for (Cart cartvar : carts) {
			if (cartvar.getUser().getId() == id) {
				newCart.add(cartvar);
			}
		}
		return newCart;
	}

	@PostMapping("/addtocart/")
	public ResponseEntity<String> saveData(@RequestBody Cart cart) {
		try {
			
			crepo.save(new Cart(cart.getId(), cart.getCourse(), cart.getUser()));
			return new ResponseEntity<>("Working fine || Course Addded to the Cart Successfully ||", HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/buyallfromcart/{id}")
	public ResponseEntity<String> buy(@PathVariable("id") long id) {
		List<Cart> carts = crepo.findAll();
		for (Cart cartvar : carts) {
			if (cartvar.getUser().getId() == id) {
				try {
					
					erepo.save(new Enroll(cartvar.getId(), cartvar.getCourse(), cartvar.getUser()));
					crepo.delete(cartvar);
					return new ResponseEntity<>("Working fine || Course Purchased through Cart Successfully ||", HttpStatus.OK);
				}
				catch(Exception e){
					return new ResponseEntity<>("Error Occur ::" + e, HttpStatus.BAD_REQUEST);
				}
				}
			}
		return new ResponseEntity<>("Working fine || Course Purchased through Cart Successfully ||", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletefromcart/{uid}/{cid}")
	public void deletecoursebyid(@PathVariable("uid") long userid, @PathVariable("cid") long courseid) {	
			List<Cart> cartList = crepo.findAll();
			List<Courses> courseListNew = new ArrayList<Courses>();
			for (Cart cartvar : cartList) {
				if (cartvar.getUser().getId() == userid) {
					for (Courses coursevar : cartvar.getCourse()) {
						if (coursevar.getId() == courseid) {
						} else {
							courseListNew.add(coursevar);
						}
					}
					cartvar.setCourse(courseListNew);
					crepo.save(cartvar);
				}
			}
		courserepo.deleteById(courseid);
	}
}