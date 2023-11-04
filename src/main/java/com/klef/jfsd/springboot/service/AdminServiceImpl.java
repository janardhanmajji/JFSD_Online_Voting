package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Elections;
import com.klef.jfsd.springboot.model.Voter;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CandidateRepository;
import com.klef.jfsd.springboot.repository.ElectionCandidateRepository;
import com.klef.jfsd.springboot.repository.ElectionRepository;
import com.klef.jfsd.springboot.repository.VoterRepository;
import com.klef.jfsd.springboot.model.ElectionCandidateMapping;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private VoterRepository voterRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private ElectionRepository electionRepository;
	
	@Autowired
	private ElectionCandidateRepository electionCandidateRepository;

	@Override
	public List<Voter> viewallvoters()
	{
		return voterRepository.findAll();
	}

	@Override
	public String deletevoter(int vid) 
	{
		Optional<Voter> obj = voterRepository.findById(vid);
		
		String msg = null;
		if(obj.isPresent())
		{
			Voter v = obj.get();
			voterRepository.delete(v);
			msg = "Voter deleted Successfully";
		}
		else
		{
			msg = "Voter Not Found";
		}
		
		return msg;
	}

	@Override
	public String addvoter(Voter v) 
	{
		voterRepository.save(v);
		return "Voter added successfully";
	}

	@Override
	public String addCandidate(Candidate cd)
	{
		candidateRepository.save(cd);
		return "Candidate added successfully";
	}

	@Override
	public List<Candidate> viewallcandidates() 
	{
		return candidateRepository.findAll();
	}

	@Override
	public Admin checkadminlogin(String auname, String apwd) {
		return adminRepository.checkadminlogin(auname, apwd);
	}

	@Override
	public String addElection(Elections e) 
	{
		electionRepository.save(e);
		return "Election added successfully";
	}

	@Override
	public List<Elections> viewallelections() {
		return electionRepository.findAll();
	}

	@Override
	public String deletecandidate(int cid) 
	{
		Optional<Candidate> obj = candidateRepository.findById(cid);
		
		String msg = null;
		if(obj.isPresent())
		{
			Candidate c = obj.get();
			candidateRepository.delete(c);
			msg = "Candidate deleted Successfully";
		}
		else
		{
			msg = "Candidate Not Found";
		}
		
		return msg;
	}

	

	@Override
	public List<ElectionCandidateMapping> viewElectionCandidateMappings() 
	{
		return (List<ElectionCandidateMapping>)  electionCandidateRepository.findAll();
	}

	@Override
	public long checkecandidatemapping(Elections e, Candidate c) {
		return electionCandidateRepository.checkcelectionmapping(e, c);
	}

	@Override
	public String ElectionCandidateMapping(ElectionCandidateMapping ecm) {
		electionCandidateRepository.save(ecm);
		return "Mapping Done";
	}

	@Override
	public Candidate candidatebyid(int cid) {
		return candidateRepository.findById(cid).get();
	}

	@Override
	public Elections electionsbyid(int eid) {
		return electionRepository.findById(eid).get();
	}

	@Override
	public List<Candidate> getCandidatesByElection(int electionId) {
		List<Candidate> candidates = electionCandidateRepository.findByElectionsId(electionId);
		return candidates;
	}

	@Override
	public List<Object[]> getVoteCount() {
		return adminRepository.getVoteCount();
	}

	@Override
	public Candidate viewCandidateById(int cid) {
		return candidateRepository.findById(cid).get();
	}


}
