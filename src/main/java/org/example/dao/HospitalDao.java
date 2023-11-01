package org.example.dao;

import org.example.model.Doctor;
import org.example.model.Hospital;
import org.example.service.HospitalService;

import java.util.List;
import java.util.Map;

public interface HospitalDao {




    List<Doctor> getAllDoctorByHospitalId(Long hospitalID);
    Map<Doctor, Hospital> getDoctorAndHospitalByDoctorId(Long doctorID);
    List<Hospital> getBusiestHospital();
}
