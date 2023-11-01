package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hospitals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Doctor> doctor;

    public Hospital( String name, String address) {

        this.name = name;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
