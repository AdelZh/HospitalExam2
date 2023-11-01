package org.example.dao.impl;

import org.example.config.Config;
import org.example.dao.DoctorDao;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.hibernate.Session;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao {


   /* @Override
    public double getAveragePatientAge(List<Patient> patients) {
        int totalAge = 0;
        for (Patient patient : patients) {
            totalAge += patient.getAge();
        }

        return (double) totalAge / patients.size();
    }

    */


    @Override
    public double getAveragePatientAge(Long patientID) {
        try (Session session = Config.getSession().openSession()) {
            session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, patientID);
            int totalAge = 0;
            for (Patient patient : doctor.getPatient()) {
                totalAge += patient.getAge();

            }
            return (double) totalAge / doctor.getPatient().size();
        }

    }

}