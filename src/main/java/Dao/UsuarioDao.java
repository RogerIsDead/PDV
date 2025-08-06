package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Usuario;

public class UsuarioDao {
	
	public Usuario atualizarUsuario(Usuario usuario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		Usuario UsuarioRetorno = entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return UsuarioRetorno;
	}
	
	public void removerUsuario(Usuario usuario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(Usuario usuario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Usuario UsuarioDelecao = entityManager.find(Usuario.class, usuario.getIdUsuario());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(UsuarioDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<Usuario> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<Usuario> listaUsuario = entityManager.createQuery("FROM Usuario ORDER BY idUsuario ASC", Usuario.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaUsuario;
		
	}
	
	 public Usuario buscarPorId(Long idUsuario) {
		 	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
	        entityManager.close();
	        return usuario;    
	    }

}
