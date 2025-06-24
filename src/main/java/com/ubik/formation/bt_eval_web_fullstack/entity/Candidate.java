package com.ubik.formation.bt_eval_web_fullstack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est requis")
    private String name;

    @NotBlank(message = "Le numéro d'identification est requis")
    private String identificationNumber;

    @NotBlank(message = "L'adresse est requise")
    private String address;

    @NotNull(message = "La date de naissance est obligatoire.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Email(message = "Email invalide")
    @NotBlank(message = "Email requis")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Le numéro de téléphone doit contenir 10 chiffres")
    @NotBlank(message = "Le téléphone est requis")
    private String phone;

    @NotBlank(message = "Domaine technique requis")
    private String technicalField;

    @Min(value = 1, message = "Le score doit être au minimum 1")
    @Max(value = 10, message = "Le score doit être au maximum 10")
    private Integer evaluationScore;

    @NotNull(message = "La date est obligatoire.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate interviewDate;

    @Column(length = 1000)
    private String observations;
}
