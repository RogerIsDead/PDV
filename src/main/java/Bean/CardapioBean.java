package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.CardapioDao;
import Entidades.Cardapio;

@ViewScoped
@ManagedBean(name = "cardapioBean")
public class CardapioBean {	
	private List<Cardapio> cardapios = new ArrayList<Cardapio>();
	private List<Cardapio> carrinho = new ArrayList<Cardapio>();
	
	public List<Cardapio> getCarrinho(){
		return carrinho;
	}
	public void setCarrinho(List<Cardapio> carrinho) {
		this.carrinho = carrinho;
	}
	
	private Cardapio cardapioSelecionado;
	
	public Cardapio getProdutoSelecionado() {
        return cardapioSelecionado;
    }
	
	public void setCardapioSelecionado(Cardapio cardapioSelecionado) {
	    this.cardapioSelecionado = cardapioSelecionado;
	}
	 
	 
	public String adicionarCarrinho() {
	    if (cardapioSelecionado != null) {
	        carrinho.add(cardapioSelecionado);
	    }
	    return"";
	}
	 
	public String removerCarrinho(Cardapio cardapioSelecionado) {
	       carrinho.remove(cardapioSelecionado); 
	       return "";
	}
	 
	public void limparCarrinho() {
		carrinho.clear();
	}
		
	public CardapioBean() {
		setCardapio(new Cardapio());;
	}

	public Cardapio cardapio;
	
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	public List<Cardapio> getCardapios(){
		return cardapios;
	}
	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
	
	public String inserirCardapio() {
		CardapioDao CardapioDao = new CardapioDao();
		CardapioDao.atualizarCardapio(getCardapio());
		carregarCardapio();
		limparCardapio();
		return "";
	}
	
	public String removerCardapio() {
		CardapioDao CardapioDao = new CardapioDao();
		CardapioDao.removerPorId(getCardapio());
		carregarCardapio();
		limparCardapio();
		return "";
	}
	
	@PostConstruct
	public void carregarCardapio() {
		CardapioDao CardapioDao = new CardapioDao();
		setCardapios(CardapioDao.getListEntity());
	}
	
	public String limparCardapio() {
		setCardapio(new Cardapio());
		return "";
	}

}
