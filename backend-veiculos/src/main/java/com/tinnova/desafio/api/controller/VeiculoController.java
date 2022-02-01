package com.tinnova.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.desafio.domain.model.Veiculo;
import com.tinnova.desafio.domain.model.dto.DistribuicaoVeiculo;
import com.tinnova.desafio.domain.service.DistribuicaoVeiculoQueryService;
import com.tinnova.desafio.domain.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private DistribuicaoVeiculoQueryService queryService;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> listar(){
		return ResponseEntity.ok(veiculoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(veiculoService.buscarOuFalhar(id));
	}
	
	@GetMapping("/buscarVeiculosNaoVendidos")
	public ResponseEntity<List<Veiculo>> buscarVeiculosNaoVendidos(){
		return ResponseEntity.ok(veiculoService.buscarVeiculosNaoVendidos());
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> cadastrar(@RequestBody Veiculo veiculo){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(veiculoService.salvar(veiculo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo){
		return ResponseEntity.ok(veiculoService.atualizar(id, veiculo));
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		veiculoService.deletar(id);
	}
	
	@PatchMapping
	public void atualizarParametros(@PathVariable Long id) {
		
	}
	
	
	@GetMapping("/distribuicaoVeiculo")
	public ResponseEntity<List<DistribuicaoVeiculo>> distribuicaoVeiculo(){
		return ResponseEntity.ok(queryService.consultarDistribuicaoVeiculo());
	}
}
