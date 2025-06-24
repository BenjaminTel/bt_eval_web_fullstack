package com.ubik.formation.bt_eval_web_fullstack.service;

import com.ubik.formation.bt_eval_web_fullstack.entity.Absence;
import com.ubik.formation.bt_eval_web_fullstack.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    @Override
    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public List<Absence> getAbsencesByEmployee(Long employeeId) {
        return absenceRepository.findByEmployeeId(employeeId);
    }
}
