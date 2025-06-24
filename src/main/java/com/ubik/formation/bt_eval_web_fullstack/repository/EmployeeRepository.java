package com.ubik.formation.bt_eval_web_fullstack.repository;

import com.ubik.formation.bt_eval_web_fullstack.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
