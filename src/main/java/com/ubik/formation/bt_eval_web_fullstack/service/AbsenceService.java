package com.ubik.formation.bt_eval_web_fullstack.service;

import com.ubik.formation.bt_eval_web_fullstack.entity.Absence;

import java.util.List;

public interface AbsenceService {

    Absence save(Absence absence);
    List<Absence> getAbsencesByEmployee(Long employeeId);
}
