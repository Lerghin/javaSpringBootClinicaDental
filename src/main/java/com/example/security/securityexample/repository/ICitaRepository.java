package com.example.security.securityexample.repository;

import com.example.security.securityexample.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita,Long> {
}
