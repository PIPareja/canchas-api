package com.pablopareja.canchas.repository;

import com.pablopareja.canchas.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanchaRepository extends JpaRepository<Cancha, Long> {
}