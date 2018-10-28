package com.locadora.apirest.models;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;



/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@Table(name="veiculo")
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=45)
	private String cor;

	@Column(nullable=false)
	private long disponivel;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_veiculo", nullable=false)
	private Long idVeiculo;

	@Column(nullable=false, length=8)
	private String placa;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="veiculo")
	private List<Reserva> reservas;

	//bi-directional one-to-one association to Aluguel
	@OneToOne
	@JoinColumn(name="id_veiculo", insertable=false, updatable=false)
	Aluguel aluguel;
	public Veiculo() {
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public long getDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel(long disponivel) {
		this.disponivel = disponivel;
	}

	public Long getIdVeiculo() {
		return this.idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setVeiculo(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setVeiculo(null);

		return reserva;
	}

	public Aluguel getAluguel() {
		return this.aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

}