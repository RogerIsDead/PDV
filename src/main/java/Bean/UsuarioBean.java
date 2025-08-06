package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.FuncionarioDao;
import Dao.UsuarioDao;
import Entidades.Funcionario;
import Entidades.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private FuncionarioDao funcionarioDao;
		
	public UsuarioBean() {
		setUsuario(new Usuario());
		funcionarioDao = new FuncionarioDao();
	}
	public String getNomeFuncionario(Long idFuncionario) {
        Funcionario funcionario = funcionarioDao.buscarPorId(idFuncionario);
        return funcionario.getNome();
    }
	
	public Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String inserirUsuario() {
		UsuarioDao UsuarioDao = new UsuarioDao();
		UsuarioDao.atualizarUsuario(getUsuario());
		carregarUsuario();
		limparUsuario();
		return "";
	}
	
	public String removerUsuario() {
		UsuarioDao UsuarioDao = new UsuarioDao();
		UsuarioDao.removerPorId(getUsuario());
		carregarUsuario();
		limparUsuario();
		return "";
	}
	
	@PostConstruct
	public void carregarUsuario() {
		UsuarioDao UsuarioDao = new UsuarioDao();
		setUsuarios(UsuarioDao.getListEntity());
	}
	
	public String limparUsuario() {
		setUsuario(new Usuario());
		return "";
	}

}
