package Entidades;

import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemVenda")
public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idItemVenda;
	private Venda idVenda;
	private Cardapio idProduto;
	private int quantidadeProdutos;

	public ItemVenda(Long idItemVenda, Venda idVenda, Cardapio idProduto, int quantidadeProdutos) {
		this.idItemVenda = idItemVenda;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public ItemVenda() {
	}

	public Venda getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Venda idVenda) {
		this.idVenda = idVenda;
	}

	public Cardapio getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Cardapio idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(int quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public Long getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(Long idItemVenda) {
		this.idItemVenda = idItemVenda;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(idItemVenda);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		return idItemVenda == other.idItemVenda;
	}
	
	
}