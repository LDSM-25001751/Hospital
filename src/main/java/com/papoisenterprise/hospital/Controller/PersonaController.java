package com.papoisenterprise.hospital.Controller;

import com.papoisenterprise.hospital.DTOs.PersonaRequestDTO;
import com.papoisenterprise.hospital.Entities.Persona;
import com.papoisenterprise.hospital.Service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Persona> crear(@Valid @RequestBody PersonaRequestDTO dto) {
        Persona nuevaPersona = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @Valid @RequestBody PersonaRequestDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}