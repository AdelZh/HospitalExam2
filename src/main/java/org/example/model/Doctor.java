package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="doctors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Gender gender;
    private int date_of_birth;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Patient> patient;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Hospital hospital;

    public Doctor( Gender gender, int date_of_birth) {

        this.gender = gender;
        this.date_of_birth = date_of_birth;

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", gender=" + gender +
                ", date_of_birth=" + date_of_birth +

                '}';
    }
}
