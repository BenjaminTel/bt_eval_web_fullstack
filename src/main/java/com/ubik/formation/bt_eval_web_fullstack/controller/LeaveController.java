package com.ubik.formation.bt_eval_web_fullstack.controller;

import com.ubik.formation.bt_eval_web_fullstack.entity.Leave;
import com.ubik.formation.bt_eval_web_fullstack.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/save")
    public String saveLeave(
        @ModelAttribute("leave") @Valid Leave leave
    ) {
        leaveService.save(leave);
        return "redirect:/api/employees/" + leave.getEmployee().getId();
    }
}

