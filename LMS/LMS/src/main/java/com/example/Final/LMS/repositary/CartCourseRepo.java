package com.example.Final.LMS.repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Final.LMS.entity.Cart;

@Repository
public interface CartCourseRepo extends JpaRepository<Cart, Long> {

}
