package com.atcs.finalproject.grp8.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atcs.finalproject.grp8.Entity.CurrentAcc;
@Repository
//@Query("select count(e) from MyEntity e where ...") public boolean existsIfBlaBla(@Param("id") String id);

public interface currentRepo   extends JpaRepository<CurrentAcc,Long>{

	
	@Query("SELECT CASE WHEN count(e) > 0 THEN true ELSE false END FROM CurrentAcc e where e.Acc_noC = acc_noc")
	boolean existsByAcc_noC(long acc_noc);

}
