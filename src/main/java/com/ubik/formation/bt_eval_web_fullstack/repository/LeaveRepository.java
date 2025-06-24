package com.ubik.formation.bt_eval_web_fullstack.repository;

import com.ubik.formation.bt_eval_web_fullstack.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByEmployeeId(Long employeeId);
}
