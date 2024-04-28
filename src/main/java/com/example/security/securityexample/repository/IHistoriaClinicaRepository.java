package com.example.security.securityexample.repository;

import com.example.security.securityexample.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoriaClinicaRepository extends JpaRepository<HistoriaClinica,Long> {
}
