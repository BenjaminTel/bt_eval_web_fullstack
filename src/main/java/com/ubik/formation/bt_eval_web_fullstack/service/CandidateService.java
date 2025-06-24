package com.ubik.formation.bt_eval_web_fullstack.service;

import com.ubik.formation.bt_eval_web_fullstack.entity.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(Long id);
    Candidate saveCandidate(Candidate candidate);
    void deleteCandidateById(Long id);
    Long count();
}
