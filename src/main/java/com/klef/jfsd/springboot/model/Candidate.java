package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate_table")
public class Candidate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="candidate_name",nullable=false,length = 50)
	private String candidate_name;
	
	@Column(name="party_name",nullable=false,length = 50)
	private String party_name;
	
	@Column(name="candidate_gender",nullable=false,length = 10)
	private String gender;
	
	@Column(name="candidate_dob",nullable=false,length = 20)
	private String dateofbirth;
	
	@Column(name="candidate_location",nullable=false)
	private String location;
	
	@Column(name = "vote_count", nullable = false,columnDefinition = "INT DEFAULT 0")
	private int vote_count;
	
	private Blob party_symbol;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", candidate_name=" + candidate_name + ", party_name=" + party_name + ", gender="
				+ gender + ", dateofbirth=" + dateofbirth + ", location=" + location + ", vote_count=" + vote_count
				+ ", party_symbol=" + party_symbol + "]";
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public Blob getParty_symbol() {
		return party_symbol;
	}

	public void setParty_symbol(Blob party_symbol) {
		this.party_symbol = party_symbol;
	}

}
