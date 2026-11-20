package com.papoisenterprise.hospital.DTOs;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Implementamos Data Transfer Object (DTO) para añadir validaciones por seguridad, para este DTO heredamos de PersonaRequestDTO las validaciones genéricas
public class DoctorRequestDTO extends PersonaRequestDTO {

    @NotBlank(message = "ERROR: La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "ERROR: El sueldo no puede estar vacío")
    @DecimalMin(value = "0.01", inclusive = true, message = "ERROR: El sueldo debe ser mayor a cero")
    @Digits(integer = 7, fraction = 2, message = "Máximo 7 enteros y 2 decimales")
    private Float sueldo;

    @NotBlank(message = "ERROR: El número de cédula no debe estar vacío")
    @Size(min = 8, max = 8, message = "ERROR: El número de cédula debe tener exactamente 8 caracteres")
    private String numeroCedula;
}
