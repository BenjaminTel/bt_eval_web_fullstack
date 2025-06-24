package com.ubik.formation.bt_eval_web_fullstack.repository;

import com.ubik.formation.bt_eval_web_fullstack.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByEmployeeId(Long employeeId);
}
