package com.klef.jfsd.springboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "electioncandidatemapping_table")
public class ElectionCandidateMapping 
{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "election_id")
	  private Elections elections;
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "candidate_id")
	  private Candidate candidate;

		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public Elections getElections() {
			return elections;
		}
	
		public void setElections(Elections elections) {
			this.elections = elections;
		}
	
		public Candidate getCandidate() {
			return candidate;
		}
	
		public void setCandidate(Candidate candidate) {
			this.candidate = candidate;
		}
	
		@Override
		public String toString() {
			return "ElectionCandidateMapping [id=" + id + ", elections=" + elections + ", candidate=" + candidate + "]";
		}
}
