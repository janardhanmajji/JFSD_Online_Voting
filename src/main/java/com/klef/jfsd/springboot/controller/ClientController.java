package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Candidate;
import com.klef.jfsd.springboot.model.ElectionCandidateMapping;
import com.klef.jfsd.springboot.model.Elections;
import com.klef.jfsd.springboot.model.Voter;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.ElectionRepository;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.VoterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private VoterService voterService;
	
	@Autowired
	private ElectionRepository electionRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@GetMapping("dlogin")
	public ModelAndView dlogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dlogin");
		return mv;
	}
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@GetMapping("voterlogin")
	public ModelAndView voterlogin()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voterlogin");
		return mv;
	}
	
	@GetMapping("addvoter")
	public ModelAndView addvoter()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addvoter");
		return mv; 
	}
	
	@GetMapping("adminnavbar")
	public ModelAndView adminnavbar()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminnavbar");
		return mv; 
	}
	
	@GetMapping("voternavbar")
	public ModelAndView voter()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voternavbar");
		return mv; 
	}
	
	@GetMapping("adminhome")
	public ModelAndView adminhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv; 
	}
	
	@GetMapping("addvoters")
	public ModelAndView addvotesr()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addvoters");
		return mv; 
	}
	
	@GetMapping("addcandidate")
	public ModelAndView addcandidate(Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addcandidate");
		model.addAttribute("options", electionRepository.findAll());
		return mv; 
	}
	
	@PostMapping("insertvoter")
	public ModelAndView insertvoter(HttpServletRequest request)
	{
		String msg = null;
		ModelAndView mv = new ModelAndView();
		
		try
		{
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String email = request.getParameter("email");
			String pwd = request.getParameter("pwd");
			String location = request.getParameter("location");
			String contact = request.getParameter("contact");
			String status = request.getParameter("status");
			boolean st = Boolean.parseBoolean(status);
			
			Voter v = new Voter();
			v.setName(name);
			v.setGender(gender);
			v.setDateofbirth(dob);
			v.setEmail(email);
			v.setPassword(pwd);
			v.setLocation(location);
			v.setContact(contact);
			v.setActive(st);
			
			msg = adminService.addvoter(v);
		} 
		catch (Exception e) 
		{
			msg = e.getMessage();
		}
		
		mv.setViewName("displaymsg");
		mv.addObject("message", msg);
		return mv;
	}
	
	@GetMapping("viewallvoters")
	public ModelAndView viewallvoters()
	{
		List<Voter> list = adminService.viewallvoters();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallvoters");
		mv.addObject("voterdata", list);
		return mv; 
	}
	
	@PostMapping("insertcandidate")
	public ModelAndView insertcandidate(HttpServletRequest request,@RequestParam("productimage") MultipartFile file) throws IOException, SerialException, SQLException
	{
		String msg = null;
		ModelAndView mv = new ModelAndView();
		
		try
		{
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String dob = request.getParameter("dob");
			String partyname = request.getParameter("partyname");
			String location = request.getParameter("location");
			
			 byte[] bytes = file.getBytes();
			 Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			
			Candidate cd = new Candidate();
			cd.setCandidate_name(name);
			cd.setGender(gender);
			cd.setDateofbirth(dob);
			cd.setParty_name(partyname);
			cd.setLocation(location);
			cd.setParty_symbol(blob);
			
			msg = adminService.addCandidate(cd);
		} 
		catch (Exception e) 
		{
			msg = e.getMessage();
		}
		
		mv.setViewName("displaymsgcd");
		mv.addObject("message", msg);
		return mv;
	}
	
	@GetMapping("viewallcandidates")
	public ModelAndView viewallcandidates()
	{
		List<Candidate> candidatelist = adminService.viewallcandidates();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallcandidates");
		mv.addObject("candidatedata", candidatelist);
		return mv; 
	}
	
	@GetMapping("viewallelections")
	public ModelAndView viewallelections()
	{
		List<Elections> eleList = adminService.viewallelections();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewallelections");
		mv.addObject("electiondata", eleList);
		return mv; 
	}
	
	@GetMapping("adminlogout")
	public ModelAndView adminlogout()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dlogin");
		return mv;
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin admin = adminService.checkadminlogin(username, password);
		
		if(admin!=null)
		{
			mv.setViewName("adminhome");
		}
		else
		{
			mv.setViewName("adminlogin");
			mv.addObject("message", "Login Failed");
		}
		return mv;
	}
	
	@PostMapping("checkvoterlogin")
	public ModelAndView checkvoterlogin(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Voter voter = voterService.checkVoterLogin(username, password);
		
		if(voter!=null)
		{
			// session
			
			HttpSession session = request.getSession();
			session.setAttribute("vid", voter.getId());
			session.setAttribute("vname", voter.getName());
			session.setAttribute("voter", voter);
			// session
			
			mv.setViewName("voterhome");
			mv.addObject("voter", voter);
		}
		else
		{
			mv.setViewName("voterlogin");
			mv.addObject("message", "Login Failed");
		}
		return mv;
	}
	
	@GetMapping("addelections")
	public ModelAndView addelections()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addelections");
		return mv;
	}
	
	@GetMapping("voterhome")
	public ModelAndView voterhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("voterhome");
		return mv;
	}
	
	@PostMapping("insertelection")
	public ModelAndView insertelection(HttpServletRequest request)
	{
		String msg = null;
		ModelAndView mv = new ModelAndView();
		
		try
		{
			String electionname = request.getParameter("electionname");
			
			Elections e = new Elections();
			e.setName(electionname);
			
			msg = adminService.addElection(e);
		} 
		catch (Exception e) 
		{
			msg = e.getMessage();
		}
		
		mv.setViewName("displaymsgele");
		mv.addObject("message", msg);
		return mv;
	}
	
	@GetMapping("vote")
	public ModelAndView vote(Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vote");
		model.addAttribute("options", electionRepository.findAll());
		return mv; 
	}
	
	@GetMapping("voterlogout")
	public ModelAndView voterlogout()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dlogin");
		return mv;
	}

	
	@GetMapping("deletevoter")
	public ModelAndView deletevoter()
	{
		List<Voter> list = adminService.viewallvoters();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletevoter");
		mv.addObject("voterdata", list);
		return mv;
	}
	
	  @GetMapping("deletevoter/{id}")
	  public String deleteaction(@PathVariable("id") int vid)
	  {
	    adminService.deletevoter(vid);
	    return "redirect:/deletevoter";
	  }
	  
		@GetMapping("deletecandidate")
		public ModelAndView deletecandidate()
		{
			List<Candidate> list = adminService.viewallcandidates();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("deletecandidate");
			mv.addObject("candidatedata", list);
			return mv;
		}
		
		 @GetMapping("deletecandidate/{id}")
		  public String deletecandidate(@PathVariable("id") int cid)
		  {
		    adminService.deletecandidate(cid);
		    return "redirect:/deletecandidate";
		  }
		 
		 
		@GetMapping("updatevoter")
		public ModelAndView updatevoter(HttpServletRequest request)
		{
			ModelAndView mv = new ModelAndView();
			HttpSession session = request.getSession();
			mv.setViewName("updatevoter");
			
			mv.addObject("vid", session.getAttribute("vid"));
			mv.addObject("vname", session.getAttribute("vname"));
			
			int id = (int) session.getAttribute("vid");
			
			Voter v  = voterService.viewVoterById(id);
			
			mv.addObject("v", v);
			return mv;
		}
		
		@PostMapping("voterupdate")
		public ModelAndView voterupdate(HttpServletRequest request)
		{
			String msg = null;
			
			ModelAndView mv = new ModelAndView();
			HttpSession session = request.getSession();
			
			mv.addObject("vid", session.getAttribute("vid"));
			mv.addObject("vname", session.getAttribute("vname"));
			
			int id = (int) session.getAttribute("vid");
			
			try
			{
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				String dob = request.getParameter("dob");
				String email = request.getParameter("email");
				String pwd = request.getParameter("pwd");
				String location = request.getParameter("location");
				String contact = request.getParameter("contact");
				String status = request.getParameter("status");
				boolean st = Boolean.parseBoolean(status);
				
				Voter v = new Voter();
				v.setId(id);
				v.setName(name);
				v.setGender(gender);
				v.setDateofbirth(dob);
				v.setEmail(email);
				v.setPassword(pwd);
				v.setLocation(location);
				v.setContact(contact);
				v.setActive(st);
				
				msg = voterService.updatevoter(v);
				
				mv.setViewName("voterlogin");
				mv.addObject("message", msg); 
			}
			catch(Exception e)
			{
				msg = e.getMessage();
				
			}
			
			return mv;
		}
		
		
		@PostMapping("finalvote")
		public ModelAndView finalvote(HttpServletRequest request) {
		    ModelAndView mv = new ModelAndView();

		    HttpSession session = request.getSession();
		    Voter loggedInVoter = (Voter) session.getAttribute("voter");

		    if (loggedInVoter != null) {
		        // Check if the voter has already voted
		        if (loggedInVoter.getVoted_to() == null) {
		            // Retrieve the selected election from the request
		            String selectedElectionId = request.getParameter("selectedElection");

		            if (selectedElectionId != null && !selectedElectionId.isEmpty()) {
		                int electionId = Integer.parseInt(selectedElectionId);

		                // Get candidates for the selected election
		                List<Candidate> candidatelist = adminService.getCandidatesByElection(electionId);

		                mv.setViewName("finalvote");
		                mv.addObject("candidatedata", candidatelist);
		            } else {
		                // Handle the case where no election is selected
		                mv.setViewName("errorpage"); // Change this to the appropriate JSP page
		                mv.addObject("errorMessage", "Please select an election");
		            }
		        } else {
		            // Voter has already voted, redirect to another JSP page
		            mv.setViewName("alreadyvoted"); // Change this to the appropriate JSP page
		        }
		    } else {
		        // Handle the case where the voter is not logged in
		        mv.setViewName("errorpage"); // Change this to the appropriate JSP page
		        mv.addObject("errorMessage", "User not logged in");
		    }

		    return mv;
		}

		
		@PostMapping("saveParty")
		public ModelAndView saveParty(HttpServletRequest request) {
		    String msg = null;
		    ModelAndView mv = new ModelAndView();

		    try {
		        String vote_to = request.getParameter("selectedparty");
		        
		        HttpSession session = request.getSession();
		        Voter voter = (Voter) session.getAttribute("voter");


		        if (voter != null) {
		            voter.setVoted_to(vote_to);
		            adminService.addvoter(voter);
		            msg = "Vote submitted successfully!";
		        } else {
		            msg = "Voter information not found. Please log in again.";
		        }
		    }
		    catch (Exception e) {
		        msg = e.getMessage();
		    }


		    mv.setViewName("displaymsg");
		    mv.addObject("message", msg);
		    return mv;
		}
		
		@GetMapping("candidateelectionmapping") 
		  public ModelAndView candidateelectionmapping() 
		  { 
			 ModelAndView mv = new ModelAndView("candidateelectionmapping"); 
		      
		      List<Elections> eList = adminService.viewallelections();
		      mv.addObject("electiondata", eList); 
		    
			   List<Candidate> cList = adminService.viewallcandidates();
			   mv.addObject("candidatedata", cList); 
		    
		   return mv; 
		  } 
		   
		  @PostMapping("candidateelectionmappinginsert") 
		  public ModelAndView fcoursemappinginsert(HttpServletRequest request) 
		  { 
		   String msg=null; 
		    
		   ModelAndView mv = new ModelAndView("candidateelectionmapping"); 
		    
		   int eid = Integer.parseInt(request.getParameter("eid")); 
		   int cid = Integer.parseInt(request.getParameter("cid")); 
		   
		   long n = adminService.checkecandidatemapping(adminService.electionsbyid(eid), adminService.candidatebyid(cid));
		    
		   if(n>0) 
		   { 
		    msg = "mapping already done"; 
		   } 
		   else 
		   { 
		    ElectionCandidateMapping ecm = new ElectionCandidateMapping(); 
		     
		    ecm.setCandidate(adminService.candidatebyid(cid));
		    ecm.setElections(adminService.electionsbyid(eid));
		     
		    msg = adminService.ElectionCandidateMapping(ecm);
		     
		     
		   } 
		    
		   mv.addObject("message", msg); 
		    
		    
		    
		   return mv; 
		  } 
		   
		  @GetMapping("viewecandidatemapping") 
		  public ModelAndView viewecandidatemapping() 
		  { 
		   ModelAndView mv = new ModelAndView("viewecandidatemapping"); 
		    
		   List<ElectionCandidateMapping> ecmlist = adminService.viewElectionCandidateMappings();
		   mv.addObject("ecmdata", ecmlist); 
		     
		   return mv; 
		  }
		  
		  @GetMapping("/votecount")
		  public ModelAndView voteCount() {
		      List<Object[]> voteCountList = adminRepository.getVoteCount();

		      ModelAndView mv = new ModelAndView("votecount");
		      mv.addObject("voteCountList", voteCountList);

		      return mv;
		  }
		  
		  @GetMapping("displayprodimage")
		  public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
		  {
		    Candidate candidate =  adminService.viewCandidateById(id);
		    byte [] imageBytes = null;
		    imageBytes = candidate.getParty_symbol().getBytes(1,  (int) candidate.getParty_symbol().length());

		    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
		  }


	
}
