package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.ProdutosDao;
import Entidades.Produtos;

@ViewScoped
@ManagedBean(name = "produtosBean")
public class ProdutosBean {	
	private List<Produtos> listaProdutos = new ArrayList<Produtos>();
		
	public ProdutosBean() {
		setProdutos(new Produtos());;
	}

	public Produtos produtos;
	
	public Produtos getProdutos() {
		return produtos;
	}
	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	public List<Produtos> getListaProdutos(){
		return listaProdutos;
	}
	public void setListaProdutos(List<Produtos> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public String inserirProdutos() {
		ProdutosDao ProdutosDao = new ProdutosDao();
		ProdutosDao.atualizarProdutos(getProdutos());
		carregarProdutos();
		limparProdutos();
		return "";
	}
	
	public String removerProdutos() {
		ProdutosDao ProdutosDao = new ProdutosDao();
		ProdutosDao.removerPorId(getProdutos());
		carregarProdutos();
		limparProdutos();
		return "";
	}
	
	@PostConstruct
	public void carregarProdutos() {
		ProdutosDao ProdutosDao = new ProdutosDao();
		setListaProdutos(ProdutosDao.getListEntity());
	}
	
	public String limparProdutos() {
		setProdutos(new Produtos());
		return "";
	}

}

