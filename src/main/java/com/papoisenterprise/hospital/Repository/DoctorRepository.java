package com.papoisenterprise.hospital.Repository;

import com.papoisenterprise.hospital.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByCurp(String curp);
    boolean existsByNumeroCedula(String numeroCedula);
}