package com.atcs.finalproject.grp8.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.atcs.finalproject.grp8.Entity.BranchDetail;

@Repository
public interface branchRepo extends JpaRepository<BranchDetail,Integer>{

}
