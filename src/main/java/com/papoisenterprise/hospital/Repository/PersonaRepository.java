package com.papoisenterprise.hospital.Repository;

import com.papoisenterprise.hospital.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByCurp(String curp);
}