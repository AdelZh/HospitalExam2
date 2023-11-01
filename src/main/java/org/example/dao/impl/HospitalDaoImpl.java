package org.example.dao.impl;

import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.dao.HospitalDao;
import org.example.model.Doctor;
import org.example.model.Hospital;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class HospitalDaoImpl implements HospitalDao {


    @Override
    public List<Doctor> getAllDoctorByHospitalId(Long hospitalID) {
        try (Session session = Config.getSession().openSession()) {
            session.beginTransaction();
            Hospital hospital = session.get(Hospital.class, hospitalID);
            List<Doctor> doctors = hospital.getDoctor();
            session.getTransaction().commit();
            return doctors;


        }
    }

    @Override
    public Map<Doctor, Hospital> getDoctorAndHospitalByDoctorId(Long doctorID) {
        try (Session session = Config.getSession().openSession()) {
            session.beginTransaction();
            Map<Doctor, Hospital> map = new HashMap<>();
            Doctor doctor = session.get(Doctor.class, doctorID);
            Hospital hospital = doctor.getHospital();
            map.put(doctor, hospital);
            session.getTransaction().commit();
            return map;
        }

    }

    public List<Hospital> getBusiestHospital() {
        try (Session session = Config.getSession().openSession()) {
            session.beginTransaction();

            String hql = "SELECT h " +
                    "FROM Doctor d " +
                    "INNER JOIN d.hospital h " +
                    "GROUP BY h " +
                    "ORDER BY COUNT(d) DESC limit 1";

            Query query = session.createQuery(hql);
            query.setMaxResults(10);
            List busiestHospitals = query.getResultList();
            session.getTransaction().commit();

            return busiestHospitals;
        }
    }


}