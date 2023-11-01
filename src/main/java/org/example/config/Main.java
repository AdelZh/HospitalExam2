package org.example.config;

import org.example.model.Doctor;
import org.example.model.Gender;
import org.example.model.Hospital;
import org.example.model.Patient;
import org.example.service.DoctorService;
import org.example.service.HospitalService;
import org.example.service.PatientService;
import org.example.service.impl.DoctorServiceImpl;
import org.example.service.impl.HospitalServiceImpl;
import org.example.service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HospitalService hospitalService = new HospitalServiceImpl();
        PatientService patientService = new PatientServiceImpl();
        DoctorService doctorService = new DoctorServiceImpl();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Patient patient = new Patient("Adel", 22, Gender.FEMALE, 22);
                    Patient patient1 = new Patient("Alina", 20, Gender.FEMALE, 24);
                    List<Patient> patients = new ArrayList<>();
                    patients.add(patient);
                    patients.add(patient1);

                    Doctor doctor = new Doctor(Gender.MALE, 23);
                    Doctor doctor1 = new Doctor(Gender.FEMALE, 50);

                    patient.setDoctor(List.of(doctor, doctor1));
                    doctor.setPatient(List.of(patient, patient1));

                    patient1.setDoctor(List.of(doctor, doctor1));
                    doctor1.setPatient(List.of(patient, patient1));


                    Hospital hospital = new Hospital("Hospital 1", "Dubai");

                    hospital.setDoctor(List.of(doctor, doctor1));

                    doctor.setHospital(hospital);
                    doctor1.setHospital(hospital);

                    System.out.println(patientService.savePatient(patients));
                    break;
                case 2:

                    System.out.println(patientService.getAgeDifferenceWithDoctor(1L, 1L));
                    break;
                case 3:
                    System.out.println(patientService.getDoctorWithMostPatient());
                    break;
                case 4:

                    System.out.println(doctorService.getAveragePatientAge(1L));
                    break;
                case 5:
                    System.out.println(hospitalService.getAllDoctorByHospitalId(1L));
                    break;
                case 6:
                    System.out.println(hospitalService.getDoctorAndHospitalByDoctorId(1L));
                    break;
                case 7:
                    System.out.println(hospitalService.getBusiestHospital());
                    break;
                case 8:
                    System.exit(0);


            }
        }
    }
}