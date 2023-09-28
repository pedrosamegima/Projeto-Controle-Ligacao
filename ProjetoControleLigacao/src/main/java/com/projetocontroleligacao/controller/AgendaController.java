package com.projetocontroleligacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetocontroleligacao.entities.Agenda;
import com.projetocontroleligacao.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	private final AgendaService agendaService;
	
	@Autowired
	public AgendaController(AgendaService agendaService) {
		this.agendaService = agendaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> getAgendaControlId(@PathVariable Long id){
		Agenda agenda = agendaService.getAgendaById(id);
		if(agenda != null) {
			return ResponseEntity.ok(agenda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Agenda>> buscaTodosAgendaControl(){
		List<Agenda> agenda = agendaService.buscaTodosAgenda();
		return ResponseEntity.ok(agenda);
	}
	@PostMapping("/")
	public ResponseEntity<Agenda> saveAgendaControl(@RequestBody Agenda agenda){
		Agenda saveagenda = agendaService.saveAgenda(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveagenda);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Agenda> alteraAgendaControl(@PathVariable Long id,@RequestBody Agenda agenda ){
		Agenda alteraAgenda = agendaService.alteraAgenda(id, agenda);
		if(alteraAgenda !=null) {
			return ResponseEntity.ok(agenda);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAgendaControl(@PathVariable Long id){
		boolean delete = agendaService.deleteAgenda(id);
		if(delete) {
			return ResponseEntity.ok().body("O Item foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
