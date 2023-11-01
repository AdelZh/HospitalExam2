package org.example.dao;

import org.example.model.Doctor;
import org.example.model.Patient;

import java.util.List;

public interface DoctorDao {



    double getAveragePatientAge(Long patientID);
}
