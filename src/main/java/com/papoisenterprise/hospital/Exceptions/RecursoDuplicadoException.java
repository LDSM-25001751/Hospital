package com.papoisenterprise.hospital.Exceptions;

public class RecursoDuplicadoException extends RuntimeException {
    public RecursoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}