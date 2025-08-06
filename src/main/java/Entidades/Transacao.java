package Entidades;

import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transacao")
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTransacao;
	private Venda idVenda;
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;
	private double troco;
	private double valorPago;
	
	public Transacao(Long idTransacao, Venda idVenda, MetodoPagamento metodoPagamento, double troco, double valorPago) {
		this.idTransacao = idTransacao;
		this.idVenda = idVenda;
		this.metodoPagamento = metodoPagamento;
		this.troco = troco;
		this.valorPago = valorPago;
	}

	public Transacao() {
	}

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Venda getVenda() {
		return idVenda;
	}

	public void setVenda(Venda idVenda) {
		this.idVenda = idVenda;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(idTransacao);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return idTransacao == other.idTransacao;
	}
	
	
	
}