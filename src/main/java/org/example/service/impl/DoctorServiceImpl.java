package org.example.service.impl;

import org.example.dao.DoctorDao;
import org.example.dao.impl.DoctorDaoImpl;
import org.example.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {


    DoctorDao dao = new DoctorDaoImpl();

    @Override
    public double getAveragePatientAge(Long patientID) {
        return dao.getAveragePatientAge(patientID);
    }
}