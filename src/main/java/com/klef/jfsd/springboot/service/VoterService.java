package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.Voter;

public interface VoterService
{
	public Voter viewVoterById(int vid);
	public String updatevoter(Voter v);
	public List<Candidate> viewselected(String ename);
	public Voter checkVoterLogin(String email, String pwd);
}
