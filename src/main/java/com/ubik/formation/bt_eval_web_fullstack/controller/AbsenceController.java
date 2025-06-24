package com.ubik.formation.bt_eval_web_fullstack.controller;

import com.ubik.formation.bt_eval_web_fullstack.entity.Absence;
import com.ubik.formation.bt_eval_web_fullstack.service.AbsenceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping("/save")
    public String saveAbsence(
        @ModelAttribute("absence") @Valid Absence absence
    ) {
        absenceService.save(absence);
        return "redirect:/api/employees/" + absence.getEmployee().getId();
    }
}
