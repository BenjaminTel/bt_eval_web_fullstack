package com.ubik.formation.bt_eval_web_fullstack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est requis")
    private String name;

    @NotBlank(message = "Le poste est requis")
    private String position;

    @NotNull(message = "Le salaire est requis")
    @Min(value = 0)
    private Double salary;

    @NotNull(message = "La date de début de contrat est requise")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate contractEndDate;

    @NotBlank(message = "L'identifiant est requis")
    private String identificationNumber;

    @NotNull(message = "La date de naissance est requise")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @NotBlank(message = "L'adresse est requise")
    private String address;

    @NotBlank(message = "L'email est requis")
    @Email(message = "Email invalide")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Le numéro de téléphone doit contenir 10 chiffres")
    @NotBlank(message = "Le téléphone est requis")
    private String phone;

    @Column(length = 1000)
    private String observations;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Leave> leaves;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
