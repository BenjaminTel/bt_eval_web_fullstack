package com.ubik.formation.bt_eval_web_fullstack.service;

import com.ubik.formation.bt_eval_web_fullstack.entity.Candidate;
import com.ubik.formation.bt_eval_web_fullstack.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidateById(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return candidateRepository.count();
    }


}
