package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int date_of_birth;
    @ManyToMany( cascade={CascadeType.PERSIST})
    private List<Doctor> doctor;


    public Patient(String name, int age,Gender gender, int date_of_birth) {

        this.name = name;
        this.age=age;
        this.gender = gender;
        this.date_of_birth = date_of_birth;

    }
}
