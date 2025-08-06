package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.ClienteDao;
import Dao.FuncionarioDao;
import Dao.UsuarioDao;
import Dao.VendaDao;
import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.Usuario;
import Entidades.Venda;

@ViewScoped
@ManagedBean(name = "vendaBean")
public class VendaBean {	
	private List<Venda> vendas = new ArrayList<Venda>();
	double valorTotal = 0;	
	private ClienteDao clienteDao;
	private FuncionarioDao funcionarioDao;
	private UsuarioDao usuarioDao;
	
	public String getNomeCliente(Long idCliente) {
        Cliente cliente = clienteDao.buscarPorId(idCliente);
        return cliente.getNome();
    }
	
	public String getNomeFuncionario(Long idUsuario) {
		Usuario usuario = usuarioDao.buscarPorId(idUsuario);
        Funcionario funcionario = funcionarioDao.buscarPorId(usuario.getIdFuncionario());
        return funcionario.getNome();
    }
		
	public VendaBean() {
		setVenda(new Venda());;
		clienteDao = new ClienteDao();
		funcionarioDao = new FuncionarioDao();
		usuarioDao = new UsuarioDao();
	}

	public Venda venda;
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public List<Venda> getVendas(){
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public String inserirVenda() {
		java.util.Date dataVenda = venda.getData();
		java.sql.Date dataSQL = convert(dataVenda);
		venda.setData(dataSQL);
		VendaDao VendaDao = new VendaDao();
		VendaDao.atualizarVenda(getVenda());
		carregarVenda();
		limparVenda();
		return "";
	}
	
	public String removerVenda() {
		VendaDao VendaDao = new VendaDao();
		VendaDao.removerPorId(getVenda());
		carregarVenda();
		limparVenda();
		return "";
	}
	
	@PostConstruct
	public void carregarVenda() {
		VendaDao VendaDao = new VendaDao();
		setVendas(VendaDao.getListEntity());
	}
	
	public String limparVenda() {
		setVenda(new Venda());
		valorTotal = 0;
		return "";
	}
	
	public java.sql.Date convert(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	public String adicionarProduto(double valorProduto) {
        valorTotal = valorTotal + valorProduto;
        venda.setValorPedido(valorTotal);
        return "";
    }
	
	 public String removerProduto(double valorProduto) {
	        valorTotal = valorTotal - valorProduto;
	        venda.setValorPedido(valorTotal);
	        return "";
	    }

}

