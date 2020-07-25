package com.bot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.exception.ResourceNotFoundException;
import com.bot.model.Candidate;
import com.bot.repository.CandidateRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")
public class CandidateController {

	@Autowired
	private CandidateRepository candidateRepository;
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates()
	{
		
		return candidateRepository.findAll();
		
	}
	
	@PostMapping("/candidates")
	public Candidate createCandidate(@Validated @RequestBody Candidate candidate) 
	{
		return candidateRepository.save(candidate);
		
	}
	
	@GetMapping("/candidates/{id}")
	public ResponseEntity<Candidate> getEmployeeById(@PathVariable(value = "id") Long candidateId)
			throws ResourceNotFoundException {
		Candidate candidate = candidateRepository.findById(candidateId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + candidateId));
		return ResponseEntity.ok().body(candidate);
	}
}


