package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Elections;
import com.klef.jfsd.springboot.model.Voter;
import com.klef.jfsd.springboot.model.ElectionCandidateMapping;

public interface AdminService
{
	public List<Voter> viewallvoters();
	public String deletevoter(int vid);
	public String deletecandidate(int cid);
	public String addvoter(Voter v);
	public String addCandidate(Candidate cd);
	public List<Candidate> viewallcandidates();
	public Admin checkadminlogin(String auname, String apwd);
	public String addElection(Elections e);
	public List<Elections> viewallelections();
	
	public String ElectionCandidateMapping(ElectionCandidateMapping e);
	public List<ElectionCandidateMapping> viewElectionCandidateMappings();
	public long checkecandidatemapping(Elections e, Candidate c);
	
	public Candidate candidatebyid(int cid);
	public Elections electionsbyid(int eid);
	
	List<Candidate> getCandidatesByElection(int electionId);
	List<Object[]> getVoteCount();
	
	public Candidate viewCandidateById(int cid);

}
