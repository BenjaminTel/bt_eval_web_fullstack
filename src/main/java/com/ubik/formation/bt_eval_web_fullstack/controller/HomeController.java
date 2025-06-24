package com.ubik.formation.bt_eval_web_fullstack.controller;

import com.ubik.formation.bt_eval_web_fullstack.service.CandidateService;
import com.ubik.formation.bt_eval_web_fullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CandidateService candidateService;

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("employeeCount", employeeService.count());
        model.addAttribute("candidateCount", candidateService.count());
        return "home/index";
    }
}
