package org.example.service;

import org.example.model.Doctor;
import org.example.model.Patient;

import java.util.List;

public interface PatientService {

    String savePatient(List<Patient> patients);
    List<Doctor> getDoctorWithMostPatient();

    int getAgeDifferenceWithDoctor(Long id, Long id2);

}
