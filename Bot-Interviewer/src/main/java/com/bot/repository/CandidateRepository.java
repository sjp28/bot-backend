package com.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bot.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>   {

}
