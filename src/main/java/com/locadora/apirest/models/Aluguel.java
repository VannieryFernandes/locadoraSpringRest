package com.locadora.apirest.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



/**
 * The persistent class for the aluguel database table.
 * 
 */
@Entity
@Table(name="aluguel")
@NamedQuery(name="Aluguel.findAll", query="SELECT a FROM Aluguel a")
public class Aluguel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_time_devolucao")
	private Date dtTimeDevolucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_time_locacao")
	private Date dtTimeLocacao;

	@Column(name="fk_cliente")
	private Long fkCliente;

	@Column(name="fk_veiculo")
	private Long fkVeiculo;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluguel", nullable=false)
	private Long idAluguel;

	private double valor;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_aluguel", insertable=false, updatable=false)
	private Cliente cliente;

	//bi-directional one-to-one association to Veiculo
	@OneToOne
	@JoinColumn(name="fk_veiculo", insertable=false, updatable=false)
	private Veiculo veiculo;

	public Aluguel() {
	}

	public Date getDtTimeDevolucao() {
		return this.dtTimeDevolucao;
	}

	public void setDtTimeDevolucao(Date dtTimeDevolucao) {
		this.dtTimeDevolucao = dtTimeDevolucao;
	}

	public Date getDtTimeLocacao() {
		return this.dtTimeLocacao;
	}

	public void setDtTimeLocacao(Date dtTimeLocacao) {
		this.dtTimeLocacao = dtTimeLocacao;
	}

	public Long getFkCliente() {
		return this.fkCliente;
	}

	public void setFkCliente(Long fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Long getFkVeiculo() {
		return this.fkVeiculo;
	}

	public void setFkVeiculo(Long fkVeiculo) {
		this.fkVeiculo = fkVeiculo;
	}

	public Long getIdAluguel() {
		return this.idAluguel;
	}

	public void setIdAluguel(Long idAluguel) {
		this.idAluguel = idAluguel;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}