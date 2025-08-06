package Entidades;

import java.util.Objects;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	private Long idFuncionario;
	private String tipoAcesso;
	private String emailAcesso;
	

	
	public Usuario(Long idUsuario, Long idFuncionario, String tipoAcesso, String emailAcesso) {
		this.idUsuario = idUsuario;
		this.idFuncionario = idFuncionario;
		this.tipoAcesso = tipoAcesso;
		this.emailAcesso = emailAcesso;
	}

	public Usuario() {
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String getEmailAcesso() {
		return emailAcesso;
	}

	public void setEmailAcesso(String emailAcesso) {
		this.emailAcesso = emailAcesso;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(idUsuario);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}
	
	
	

}
