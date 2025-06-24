package com.ubik.formation.bt_eval_web_fullstack.service;

import com.ubik.formation.bt_eval_web_fullstack.entity.Leave;

import java.util.List;

public interface LeaveService {
    Leave save(Leave leave);
    List<Leave> getLeavesByEmployee(Long employeeId);
}
