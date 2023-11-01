package org.example.service.impl;

import org.example.dao.PatientDao;
import org.example.dao.impl.PatientDaoImpl;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    PatientDao patientDao = new PatientDaoImpl();

    @Override
    public String savePatient(List<Patient> patients) {
        return patientDao.savePatient(patients);
    }

    @Override
    public List<Doctor> getDoctorWithMostPatient() {
        return patientDao.getDoctorWithMostPatient();
    }


    @Override
    public int getAgeDifferenceWithDoctor(Long id, Long id2) {
        return patientDao.getAgeDifferenceWithDoctor(id, id2);
    }
}