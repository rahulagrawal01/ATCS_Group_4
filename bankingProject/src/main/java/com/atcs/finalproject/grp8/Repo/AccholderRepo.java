package com.atcs.finalproject.grp8.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atcs.finalproject.grp8.Entity.AccHolder;



@Repository

public interface AccholderRepo extends JpaRepository<AccHolder,Integer>{

}
