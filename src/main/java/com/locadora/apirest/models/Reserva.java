package com.locadora.apirest.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_time_reserva")
	private Date dtTimeReserva;

	@Column(name="fk_cliente")
	private Long fkCliente;

	@Column(name="fk_veiculo")
	private Long fkVeiculo;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_reserva", nullable=false)
	private Long idReserva;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="id_reserva", insertable=false, updatable=false)
	private Veiculo veiculo;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_reserva",insertable=false, updatable=false)
	private Cliente cliente;

	public Reserva() {
	}

	public Date getDtTimeReserva() {
		return this.dtTimeReserva;
	}

	public void setDtTimeReserva(Date dtTimeReserva) {
		this.dtTimeReserva = dtTimeReserva;
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

	public Long getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}