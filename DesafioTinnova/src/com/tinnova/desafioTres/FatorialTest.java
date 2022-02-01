package com.tinnova.desafioTres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FatorialTest {
	
	
	@Test
	void deveRetornarOValorDoFatorialCorreto() {
		Fatorial fatorial = new Fatorial();
		assertEquals(1, fatorial.calcular(0));
		assertEquals(1, fatorial.calcular(1));
		assertEquals(2, fatorial.calcular(2));
		assertEquals(6, fatorial.calcular(3));
		assertEquals(24, fatorial.calcular(4));
		assertEquals(120, fatorial.calcular(5));
		assertEquals(720, fatorial.calcular(6));
		assertEquals(5040, fatorial.calcular(7));
		assertEquals(40320, fatorial.calcular(8));
	}

}
