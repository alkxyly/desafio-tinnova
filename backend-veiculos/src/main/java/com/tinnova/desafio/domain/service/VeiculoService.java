package com.tinnova.desafio.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnova.desafio.domain.exception.VeiculoNaoEncontradoException;
import com.tinnova.desafio.domain.model.Veiculo;
import com.tinnova.desafio.domain.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<Veiculo> buscarTodos(){
		return veiculoRepository.findAll();
	}
	
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public Veiculo buscarOuFalhar(Long id) {
		return this.veiculoRepository.findById(id)
				.orElseThrow(() -> new VeiculoNaoEncontradoException(String.format(
						"Não foi possível encontrar o veículo %d", id)));
	}
	
	public Veiculo atualizar(Long id, Veiculo veiculo) {
		Veiculo veiculoAtual = buscarOuFalhar(id);
		BeanUtils.copyProperties(veiculo, veiculoAtual, "id");
		veiculoAtual = veiculoRepository.save(veiculoAtual);
		return veiculoAtual;
	}
	
	
	public void deletar(Long id) {
		Veiculo veiculo = buscarOuFalhar(id);
		veiculoRepository.deleteById(id);
	}

	public List<Veiculo> buscarVeiculosNaoVendidos() {
		return veiculoRepository.findByVendido(false);
	}
}
