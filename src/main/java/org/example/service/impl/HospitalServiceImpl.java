package org.example.service.impl;

import org.example.dao.HospitalDao;
import org.example.dao.impl.HospitalDaoImpl;
import org.example.model.Doctor;
import org.example.model.Hospital;
import org.example.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {


    HospitalDao hospitalDao = new HospitalDaoImpl();


    @Override
    public List<Doctor> getAllDoctorByHospitalId(Long hospitalID) {
        return hospitalDao.getAllDoctorByHospitalId(hospitalID);
    }

    @Override
    public Map<Doctor, Hospital> getDoctorAndHospitalByDoctorId(Long doctorID) {
        return hospitalDao.getDoctorAndHospitalByDoctorId(doctorID);
    }

    @Override
    public List<Hospital> getBusiestHospital() {
       return hospitalDao.getBusiestHospital();
    }
}