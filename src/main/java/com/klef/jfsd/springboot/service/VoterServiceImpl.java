package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Voter;
import com.klef.jfsd.springboot.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService
{
	@Autowired
	private VoterRepository voterRepository;


	@Override
	public Voter viewVoterById(int vid) 
	{
		Optional<Voter> obj = voterRepository.findById(vid);    
	    
	    if(obj.isPresent())
	    {
	      Voter v = obj.get();
	      return v;
	    }
	    else
	    {
	      return null;
	    }
	}

	@Override
	public List<Candidate> viewselected(String ename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voter checkVoterLogin(String email, String pwd) 
	{
		return voterRepository.checkVoterLogin(email, pwd);
	}

	@Override
	public String updatevoter(Voter v)
	{
		Voter voter = voterRepository.findById(v.getId()).get();
		
		voter.setName(v.getName());
		voter.setDateofbirth(v.getDateofbirth());
		voter.setEmail(v.getEmail());
		voter.setPassword(v.getPassword());
		voter.setLocation(v.getLocation());
		voter.setContact(v.getContact());
		
		voterRepository.save(voter);
		
		return "Voter Updated Successfully";
	}


}
