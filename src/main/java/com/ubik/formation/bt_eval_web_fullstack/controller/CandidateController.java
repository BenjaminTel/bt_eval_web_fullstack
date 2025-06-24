package com.ubik.formation.bt_eval_web_fullstack.controller;

import com.ubik.formation.bt_eval_web_fullstack.entity.Candidate;
import com.ubik.formation.bt_eval_web_fullstack.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public String listCandidates(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        return "candidate/list";
    }

    @GetMapping("/{id}")
    public String viewCandidate(@PathVariable Long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);
        model.addAttribute("candidate", candidate);
        return "candidate/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidate/form";
    }

    @PostMapping("/save")
    public String saveCandidate(
            @ModelAttribute("candidate") @Valid Candidate candidate,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "candidate/form";
        }
        candidateService.saveCandidate(candidate);
        return "redirect:/api/candidates";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Candidate candidate = candidateService.getCandidateById(id);
        model.addAttribute("candidate", candidate);
        return "candidate/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidateById(id);
        return "redirect:/api/candidates";
    }
}

