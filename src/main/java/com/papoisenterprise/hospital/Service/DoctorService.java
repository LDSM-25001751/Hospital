package com.papoisenterprise.hospital.Service;

import com.papoisenterprise.hospital.DTOs.DoctorRequestDTO;
import com.papoisenterprise.hospital.Entities.Doctor;
import com.papoisenterprise.hospital.Exceptions.RecursoDuplicadoException;
import com.papoisenterprise.hospital.Exceptions.RecursoNoEncontradoException;
import com.papoisenterprise.hospital.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements BaseService<Doctor, DoctorRequestDTO> {
    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Doctor> listar() {
        return repository.findAll(); }

    @Override
    public Doctor buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Doctor no encontrado: " + id));
    }

    @Override
    public Doctor crear(DoctorRequestDTO dto) {
        if (repository.existsByCurp(dto.getCurp()))
            throw new RecursoDuplicadoException("Ya existe una persona con la CURP: " + dto.getCurp());
        if (repository.existsByNumeroCedula(dto.getNumeroCedula()))
            throw new RecursoDuplicadoException("Ya existe un doctor con la cédula: " + dto.getNumeroCedula());
        return repository.save(aEntidad(new Doctor(), dto));
    }

    @Override
    public Doctor actualizar(Long id, DoctorRequestDTO dto) {
        Doctor existente = buscar(id);
        return repository.save(aEntidad(existente, dto));
    }

    @Override
    public void eliminar(Long id) { repository.delete(buscar(id)); }

    // Copia los datos del DTO a la entidad
    private Doctor aEntidad(Doctor d, DoctorRequestDTO dto) {
        d.setNombre(dto.getNombre());
        d.setApellidoP(dto.getApellidoP());
        d.setApellidoM(dto.getApellidoM());
        d.setFechaNacimiento(dto.getFechaNacimiento());
        d.setEdad(dto.getEdad());
        d.setGenero(dto.getGenero());
        d.setCurp(dto.getCurp());
        d.setEstatus(dto.isEstatus());
        d.setEspecialidad(dto.getEspecialidad());
        d.setSueldo(dto.getSueldo());
        d.setNumeroCedula(dto.getNumeroCedula());
        return d;
    }
}

