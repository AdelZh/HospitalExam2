package org.example.service;

import org.example.model.Doctor;
import org.example.model.Hospital;

import java.util.List;
import java.util.Map;

public interface HospitalService {


    List<Doctor> getAllDoctorByHospitalId(Long hospitalID);
    Map<Doctor, Hospital> getDoctorAndHospitalByDoctorId(Long doctorID);
    List<Hospital> getBusiestHospital();
}
