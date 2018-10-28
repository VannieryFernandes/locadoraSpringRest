package com.locadora.apirest.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=45)
	private String cpf;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cliente", nullable=false)
	private Long idCliente;

	@Column(length=45)
	private String nome;

	//bi-directional many-to-one association to Aluguel
	@OneToMany(mappedBy="cliente")
	private List<Aluguel> aluguels;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;

	public Cliente() {
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluguel> getAluguels() {
		return this.aluguels;
	}

	public void setAluguels(List<Aluguel> aluguels) {
		this.aluguels = aluguels;
	}

	public Aluguel addAluguel(Aluguel aluguel) {
		getAluguels().add(aluguel);
		aluguel.setCliente(this);

		return aluguel;
	}

	public Aluguel removeAluguel(Aluguel aluguel) {
		getAluguels().remove(aluguel);
		aluguel.setCliente(null);

		return aluguel;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCliente(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCliente(null);

		return reserva;
	}

}