package com.tinnova.desafio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_veiculo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private boolean vendido;
	
	@CreationTimestamp
	private LocalDateTime created;
	
	@UpdateTimestamp
	private LocalDateTime updated;
}
