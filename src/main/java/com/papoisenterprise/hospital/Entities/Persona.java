package com.papoisenterprise.hospital.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private String genero;
    private String curp;
    private boolean estatus;
}
