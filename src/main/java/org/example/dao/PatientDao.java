package org.example.dao;

import org.example.model.Doctor;
import org.example.model.Patient;

import java.util.List;

public interface PatientDao {


    String savePatient(List<Patient> patient);
    List<Doctor> getDoctorWithMostPatient();

    int getAgeDifferenceWithDoctor(Long id, Long id2);


}
