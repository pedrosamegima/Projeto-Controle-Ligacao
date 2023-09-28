package com.projetocontroleligacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetocontroleligacao.entities.Agenda;

public interface AgendaRepository extends JpaRepository <Agenda,Long> {

}
