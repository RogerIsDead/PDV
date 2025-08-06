package Entidades;

import java.util.Date;
import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="venda")
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVenda;
	private Long idCliente;
	private Long idUsuario;
	@Temporal(TemporalType.DATE)
	private Date data;
	private double valorPedido;
	
	public Venda(Long idVenda, Long idCliente, Long idUsuario, Date data, double valorPedido) {
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.data = data;
		this.valorPedido = valorPedido;
	}

	public Venda() {
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(double valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(idVenda);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return idVenda == other.idVenda;
	}
	
	

	
}
