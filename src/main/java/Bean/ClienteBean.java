package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.ClienteDao;
import Entidades.Cliente;


@ViewScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean {	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ClienteDao clienteDao;
	
	public String getNomeCliente(Long idCliente) {
        Cliente cliente = clienteDao.buscarPorId(idCliente);
        return cliente != null ? cliente.getNome() : "N/A";
    }
	
		
	public ClienteBean() {
		setCliente(new Cliente());;
	}

	public Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes(){
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public String inserirCliente() {
		java.util.Date dataVenda = cliente.getDataNascimento();
		java.sql.Date dataSQL = convert(dataVenda);
		cliente.setDataNascimento(dataSQL);
		ClienteDao ClienteDao = new ClienteDao();
		ClienteDao.atualizarCliente(getCliente());
		carregarCliente();
		limparCliente();
		return "";
	}
	
	public String removerCliente() {
		ClienteDao ClienteDao = new ClienteDao();
		ClienteDao.removerPorId(getCliente());
		carregarCliente();
		limparCliente();
		return "";
	}
	
	@PostConstruct
	public void carregarCliente() {
		ClienteDao ClienteDao = new ClienteDao();
		setClientes(ClienteDao.getListEntity());
	}
	
	public String limparCliente() {
		setCliente(new Cliente());
		return "";
	}
	
	public java.sql.Date convert(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
}