package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	@Query("select a from Admin a where username=?1 and password=?2")
	public Admin checkadminlogin(String auname, String apwd);
	
	@Query("SELECT v.voted_to, COUNT(v) FROM Voter v WHERE v.voted_to IS NOT NULL GROUP BY v.voted_to")
    List<Object[]> getVoteCount();

}
