package com.tinnova.desafioUm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EleicaoTest {

	private static final double VALOR_ESPERADO_VOTOS_NULOS   = 5.0;
	private static final double VALOR_ESPERADO_VOTOS_BRANCOS = 15.0;
	private static final double VALOR_ESPERADO_VOTOS_VALIDOS = 80.0;
	
	private Eleicao eleicao;
	
	@BeforeEach
	public void configuracao() {
		this.eleicao = new Eleicao(1000, 800, 150, 50);
	}
	
	@Test
	void deveRetornarPercentualDeVotosValidos() {
		assertEquals(VALOR_ESPERADO_VOTOS_VALIDOS, this.eleicao.getPercentualVotosValidos());
	}
	
	@Test
	void deveRetornarPercentualDeVotosBrancos() {
		assertEquals(VALOR_ESPERADO_VOTOS_BRANCOS, this.eleicao.getPercentualVotosBrancos());
	}

	@Test
	void deveRetornarPercentualDeVotosNulos() {
		assertEquals(VALOR_ESPERADO_VOTOS_NULOS, this.eleicao.getPercentualVotosNulos());
	}
}
