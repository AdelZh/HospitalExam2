package org.example.dao.impl;

import jakarta.persistence.Query;
import org.example.config.Config;
import org.example.dao.PatientDao;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class PatientDaoImpl implements PatientDao {



    @SuppressWarnings("unchecked")
    @Override
    public List<Doctor> getDoctorWithMostPatient() {
        try (Session session = Config.getSession().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT d FROM Doctor d " +
                    "INNER JOIN Patient p ON d.id = p.id " +
                    "GROUP BY d.id " +
                    "ORDER BY COUNT(p.id) DESC " +
                    "LIMIT 1", Doctor.class);
            return (List<Doctor>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @SuppressWarnings("deprecation")
    @Override
    public int getAgeDifferenceWithDoctor(Long id, Long id2) {
            try (Session session = Config.getSession().openSession()) {
                session.beginTransaction();

                Query patientQuery = session.createQuery(
                        "SELECT d.date_of_birth - p.age " +
                                "FROM Doctor d inner join d.patient p " +
                                "WHERE p.id = :patientId AND d.id = :doctorId"
                );
                patientQuery.setParameter("patientId", id);
                patientQuery.setParameter("doctorId", id2);

                Integer ageDifference = (Integer) patientQuery.getSingleResult();

                if (ageDifference == null) {
                    ageDifference = 0;
                }

                return ageDifference;
            }
        }

        @Override
    public String savePatient(List<Patient> patient) {
        try(Session session= Config.getSession().openSession()){
            session.beginTransaction();
            for(Patient p:patient){
                session.persist(p);
            }
            session.getTransaction().commit();
            return "saved";
        }
    }
}
