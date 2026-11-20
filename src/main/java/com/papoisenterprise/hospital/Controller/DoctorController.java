package com.papoisenterprise.hospital.Controller;

import com.papoisenterprise.hospital.DTOs.DoctorRequestDTO;
import com.papoisenterprise.hospital.Entities.Doctor;
import com.papoisenterprise.hospital.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> crear(@Valid @RequestBody DoctorRequestDTO dto) {
        Doctor nuevoDoctor = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> actualizar(@PathVariable Long id, @Valid @RequestBody DoctorRequestDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}