package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Elections;
import com.klef.jfsd.springboot.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer>
{
	@Query("select c from Candidate c where location=?1")
	public List<Candidate> viewSelected(Elections e);
	
	@Query("select v from Voter v where email=?1 and password=?2")
	public Voter checkVoterLogin(String email, String password);
	
}
