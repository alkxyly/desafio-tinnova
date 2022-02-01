package com.tinnova.desafioUm;

public class Eleicao {
	
	private int totalEleitores;
	private int votosValidos;
	private int votosBrancos;
	private int votosNulos;
	
	public Eleicao(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
		this.totalEleitores = totalEleitores;
		this.votosValidos = votosValidos;
		this.votosBrancos = votosBrancos;
		this.votosNulos = votosNulos;
	}

	
	public double getPercentualVotosValidos() {
		return (Double.valueOf(this.votosValidos)/Double.valueOf(this.totalEleitores)) * 100;
	}
	
	public double getPercentualVotosBrancos() {
		return (Double.valueOf(this.votosBrancos)/Double.valueOf(this.totalEleitores)) * 100;
	}


	public double getPercentualVotosNulos() {
		return (Double.valueOf(this.votosNulos)/Double.valueOf(this.totalEleitores)) * 100;
	}
}
