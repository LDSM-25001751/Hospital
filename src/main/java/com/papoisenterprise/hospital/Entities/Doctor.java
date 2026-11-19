package com.papoisenterprise.hospital.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Persona{

    private String especialidad;
    private Float sueldo;
    private String numeroCedula;
}
