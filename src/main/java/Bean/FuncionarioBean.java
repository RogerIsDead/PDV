package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.FuncionarioDao;
import Entidades.Funcionario;

@ViewScoped
@ManagedBean(name = "funcionarioBean")
public class FuncionarioBean {	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
	public FuncionarioBean() {
		setFuncionario(new Funcionario());;
	}

	public Funcionario funcionario;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public String inserirFuncionario() {
		FuncionarioDao FuncionarioDao = new FuncionarioDao();
		FuncionarioDao.atualizarFuncionario(getFuncionario());
		carregarFuncionario();
		limparFuncionario();
		return "";
	}
	
	public String removerFuncionario() {
		FuncionarioDao FuncionarioDao = new FuncionarioDao();
		FuncionarioDao.removerPorId(getFuncionario());
		carregarFuncionario();
		limparFuncionario();
		return "";
	}
	
	@PostConstruct
	public void carregarFuncionario() {
		FuncionarioDao FuncionarioDao = new FuncionarioDao();
		setFuncionarios(FuncionarioDao.getListEntity());
	}
	
	public String limparFuncionario() {
		setFuncionario(new Funcionario());
		return "";
	}

}
