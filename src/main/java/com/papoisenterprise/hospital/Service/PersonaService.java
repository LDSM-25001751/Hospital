package com.papoisenterprise.hospital.Service;

import com.papoisenterprise.hospital.DTOs.PersonaRequestDTO;
import com.papoisenterprise.hospital.Entities.Persona;
import com.papoisenterprise.hospital.Exceptions.RecursoDuplicadoException;
import com.papoisenterprise.hospital.Exceptions.RecursoNoEncontradoException;
import com.papoisenterprise.hospital.Repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements BaseService<Persona, PersonaRequestDTO>{
    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Persona> listar() { return repository.findAll(); }

    @Override
    public Persona buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Persona no encontrada: " + id));
    }

    @Override
    public Persona crear(PersonaRequestDTO dto) {
        if (repository.existsByCurp(dto.getCurp()))
            throw new RecursoDuplicadoException("Ya existe una persona con la CURP: " + dto.getCurp());
        return repository.save(aEntidad(new Persona(), dto));
    }
    @Override
    public Persona actualizar(Long id, PersonaRequestDTO dto) {
        return repository.save(aEntidad(buscar(id), dto));
    }
    @Override
    public void eliminar(Long id) { repository.delete(buscar(id)); }

    private Persona aEntidad(Persona p, PersonaRequestDTO dto) {
        p.setNombre(dto.getNombre());
        p.setApellidoP(dto.getApellidoP());
        p.setApellidoM(dto.getApellidoM());
        p.setFechaNacimiento(dto.getFechaNacimiento());
        p.setEdad(dto.getEdad());
        p.setGenero(dto.getGenero());
        p.setCurp(dto.getCurp());
        p.setEstatus(dto.isEstatus());
        return p;
    }
}
