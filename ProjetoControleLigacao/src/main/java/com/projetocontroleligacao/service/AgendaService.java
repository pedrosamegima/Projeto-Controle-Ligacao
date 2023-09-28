package com.projetocontroleligacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocontroleligacao.entities.Agenda;
import com.projetocontroleligacao.repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;
	
	@Autowired
	public AgendaService (AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}
	public List<Agenda> buscaTodosAgenda(){
		return agendaRepository.findAll();
	}
	public Agenda getAgendaById(Long id) {
		Optional<Agenda> Agenda = agendaRepository.findById(id);
		return Agenda.orElse(null);
	}
	public Agenda saveAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}
	public Agenda alteraAgenda(Long id, Agenda alteraAgenda) {
		Optional <Agenda> existeAgenda = agendaRepository.findById(id);
		if(existeAgenda.isPresent()) {
			alteraAgenda.setId(id);
			return agendaRepository.save(alteraAgenda);
		}
		return null;
	}
	public boolean deleteAgenda(Long id) {
		Optional <Agenda> existeAgenda = agendaRepository.findById(id);
		if(existeAgenda.isPresent()) {
			agendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
