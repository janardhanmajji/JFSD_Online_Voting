package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.ElectionCandidateMapping;
import com.klef.jfsd.springboot.model.Elections;

public interface ElectionCandidateRepository extends CrudRepository<ElectionCandidateMapping, Integer>
{
	@Query("SELECT COUNT(ecm) FROM ElectionCandidateMapping ecm where ecm.elections = ?1 and ecm.candidate = ?2")
	public long checkcelectionmapping(Elections e, Candidate c);
	
	@Query("SELECT ecm.candidate FROM ElectionCandidateMapping ecm WHERE ecm.elections.id = :electionId")
	List<Candidate> findByElectionsId(@Param("electionId") int electionId);

}
