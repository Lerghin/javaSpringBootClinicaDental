package com.example.security.securityexample.repository;

import com.example.security.securityexample.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Long> {
}
