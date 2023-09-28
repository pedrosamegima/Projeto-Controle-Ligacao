package com.projetocontroleligacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocontroleligacao.entities.Ligacao;
import com.projetocontroleligacao.repository.LigacaoRepository;
@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;
	
	@Autowired
	public LigacaoService (LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}
	public List<Ligacao> buscaTodosLigacao(){
		return ligacaoRepository.findAll();
	}
	public Ligacao getLigacaoById(Long id) {
		Optional<Ligacao> Ligacao = ligacaoRepository.findById(id);
		return Ligacao.orElse(null);
	}
	public Ligacao saveLigacao(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}
	public Ligacao alteraLigacao(Long id, Ligacao alteraLigacao) {
		Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if(existeLigacao.isPresent()) {
			alteraLigacao.setId(id);
			return ligacaoRepository.save(alteraLigacao);
		}
		return null;
	}
	public boolean deleteLigacao(Long id) {
		Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if(existeLigacao.isPresent()) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
