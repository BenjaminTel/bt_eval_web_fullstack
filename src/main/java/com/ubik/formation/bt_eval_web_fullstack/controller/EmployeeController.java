package com.ubik.formation.bt_eval_web_fullstack.controller;

import com.ubik.formation.bt_eval_web_fullstack.entity.Absence;
import com.ubik.formation.bt_eval_web_fullstack.entity.Employee;
import com.ubik.formation.bt_eval_web_fullstack.entity.Leave;
import com.ubik.formation.bt_eval_web_fullstack.service.AbsenceService;
import com.ubik.formation.bt_eval_web_fullstack.service.EmployeeService;
import com.ubik.formation.bt_eval_web_fullstack.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private AbsenceService absenceService;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/list";
    }

    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        List<Leave> leaves = leaveService.getLeavesByEmployee(id);
        List<Absence> absences = absenceService.getAbsencesByEmployee(id);
        model.addAttribute("employee", employee);
        model.addAttribute("leaves", leaves);
        model.addAttribute("absences", absences);

        Leave newLeave = new Leave();
        newLeave.setEmployee(employee);
        model.addAttribute("newLeave", newLeave);

        Absence newAbsence = new Absence();
        newAbsence.setEmployee(employee);
        model.addAttribute("newAbsence", newAbsence);
        return "employee/view";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/form";
    }

    @PostMapping("/save")
    public String saveEmployee(
        @ModelAttribute("employee") @Valid Employee employee,
        BindingResult result,
        Model model
    ) {
        if (result.hasErrors()) {
            return "employee/form";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/api/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/api/employees";
    }
}
