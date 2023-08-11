package com.uniamerica.lembretes.repository;

import com.uniamerica.lembretes.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {
}
