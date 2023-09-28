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

import com.projetocontroleligacao.entities.Ligacao;
import com.projetocontroleligacao.service.LigacaoService;

@RestController
@RequestMapping("/ligacao")
public class LigacaoController {
private final LigacaoService ligacaoService;
	
	@Autowired
	public LigacaoController(LigacaoService ligacaoService) {
		this.ligacaoService = ligacaoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Ligacao> getLigacaoControlId(@PathVariable Long id){
		Ligacao ligacao = ligacaoService.getLigacaoById(id);
		if(ligacao != null) {
			return ResponseEntity.ok(ligacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Ligacao>> buscaTodosLigacaoControl(){
		List<Ligacao> ligacao = ligacaoService.buscaTodosLigacao();
		return ResponseEntity.ok(ligacao);
	}
	@PostMapping("/")
	public ResponseEntity<Ligacao> saveLigacaoControl(@RequestBody Ligacao ligacao){
		Ligacao saveligacao = ligacaoService.saveLigacao(ligacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveligacao);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Ligacao> alteraLigacaoControl(@PathVariable Long id,@RequestBody Ligacao ligacao ){
		Ligacao alteraLigacao = ligacaoService.alteraLigacao(id, ligacao);
		if(alteraLigacao !=null) {
			return ResponseEntity.ok(ligacao);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLigacaoControl(@PathVariable Long id){
		boolean delete = ligacaoService.deleteLigacao(id);
		if(delete) {
			return ResponseEntity.ok().body("O ligacao foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}

