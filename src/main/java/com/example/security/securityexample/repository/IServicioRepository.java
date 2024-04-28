package com.example.security.securityexample.repository;

import com.example.security.securityexample.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio,Long> {
}
