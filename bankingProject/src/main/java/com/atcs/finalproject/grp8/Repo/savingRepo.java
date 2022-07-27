package com.atcs.finalproject.grp8.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.atcs.finalproject.grp8.Entity.SavingAcc;
@Repository

public interface savingRepo  extends JpaRepository<SavingAcc,Long>{
	@Query("SELECT CASE WHEN count(e) > 0 THEN true ELSE false END FROM SavingAcc e where e.acc_noS = acc_nos")
	boolean existsByAcc_noS(long acc_nos);
}
