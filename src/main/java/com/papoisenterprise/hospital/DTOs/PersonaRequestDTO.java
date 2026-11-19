package com.papoisenterprise.hospital.DTOs;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//Implementamos Data Transfer Object (DTO) para añadir validaciones por seguridad
public class PersonaRequestDTO {

        @NotBlank(message = "ERROR: El nombre debe ser obligatorio")
        @Size(min = 2, max = 100, message = "ERROR: El nombre debe contener entre 2 a 100 caracteres")
        @Pattern(regexp = "^[\\p{L} ]+$", message = "ERROR: El nombre no debe contener caracteres especiales")
        private String nombre;

        @NotBlank(message = "ERROR: El apellido paterno debe ser obligatorio")
        @Size(min = 2, max = 50, message = "ERROR: El apellido paterno debe contener entre 2 a 50 caracteres")
        @Pattern(regexp = "^[\\p{L} ]+$", message = "ERROR: El apellido paterno no debe contener caracteres especiales")
        private String apellidoP;

        @NotBlank(message = "ERROR: El apellido materno debe ser obligatorio")
        @Size(min = 2, max = 50, message = "ERROR: El apellido materno debe contener entre 2 a 50 caracteres")
        @Pattern(regexp = "^[\\p{L} ]+$", message = "ERROR: El apellido materno no debe contener caracteres especiales")
        private String apellidoM;

        @NotNull(message = "ERROR: La fecha de nacimiento es obligatoria")
        @PastOrPresent(message = "ERROR: La fecha de nacimiento no puede ser futura")
        private LocalDate fechaNacimiento;

        @NotBlank(message = "ERROR: La edad no puede estar vacia")
        @Min(value = 1, message = "ERROR: Ingresa una edad válida")
        @Max(value = 120, message = "ERROR: Ingresa una edad válida")
        private Integer edad;

        @NotBlank(message = "ERROR: El género es obligatorio")
        private String genero;

        @NotBlank(message = "ERROR: El curp no puede estar vacío")
        @Size(min = 18, max = 18, message = "ERROR: El curp debe tener exactamente 18 caracteres")
        private String curp;

        @NotNull(message = "ERROR: El status es obligatorio")
        private boolean estatus;
 }
