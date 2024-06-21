package com.cantinhodoparque.api_controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantinhodoparque.api_controle.responsavel.DadosAtualizacaoResponsavel;
import com.cantinhodoparque.api_controle.responsavel.DadosCadastroResponsavel;
import com.cantinhodoparque.api_controle.responsavel.DadosListagemResponsavel;
import com.cantinhodoparque.api_controle.responsavel.Responsavel;
import com.cantinhodoparque.api_controle.responsavel.ResponsavelRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("responsavel")
public class ResponsavelController {
	
	@Autowired
	public ResponsavelRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroResponsavel dados) {
		
		repository.save(new Responsavel(dados));
		
	}
	
	@GetMapping
	public Page<DadosListagemResponsavel> listar(Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemResponsavel::new);
	}
	
	@GetMapping("/{id}")
	public List<DadosListagemResponsavel> listar(@PathVariable Long id){
		return (List<DadosListagemResponsavel>) repository.getReferenceById(id);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody DadosAtualizacaoResponsavel dados) {
		var responsavel = repository.getReferenceById(dados.id());
		responsavel.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var responsavel = repository.getReferenceById(id);
		responsavel.excluir();
	}
	
}
