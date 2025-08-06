package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.TransacaoDao;
import Entidades.Transacao;

@ViewScoped
@ManagedBean(name = "transacaoBean")
public class TransacaoBean {	
	private List<Transacao> transacoes = new ArrayList<Transacao>();
		
	public TransacaoBean() {
		setTransacao(new Transacao());;
	}

	public Transacao transacao;
	
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	public List<Transacao> getTransacoes(){
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
	public String inserirTransacao() {
		TransacaoDao TransacaoDao = new TransacaoDao();
		TransacaoDao.atualizarTransacao(getTransacao());
		carregarTransacao();
		limparTransacao();
		return "";
	}
	
	public String removerTransacao() {
		TransacaoDao TransacaoDao = new TransacaoDao();
		TransacaoDao.removerPorId(getTransacao());
		carregarTransacao();
		limparTransacao();
		return "";
	}
	
	@PostConstruct
	public void carregarTransacao() {
		TransacaoDao TransacaoDao = new TransacaoDao();
		setTransacoes(TransacaoDao.getListEntity());
	}
	
	public String limparTransacao() {
		setTransacao(new Transacao());
		return "";
	}

}
