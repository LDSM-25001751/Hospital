package com.papoisenterprise.hospital.Service;

import java.util.List;

public interface BaseService<T, D> {
    List<T> listar();
    T buscar(Long id);
    T crear(D dto);
    T actualizar(Long id, D dto);
    void eliminar(Long id);
}
