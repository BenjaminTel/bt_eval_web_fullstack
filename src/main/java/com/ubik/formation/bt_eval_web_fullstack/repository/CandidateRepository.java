package com.ubik.formation.bt_eval_web_fullstack.repository;

import com.ubik.formation.bt_eval_web_fullstack.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
