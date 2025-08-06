package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Cliente;

public class ClienteDao {
	
	public Cliente atualizarCliente(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		Cliente ClienteRetorno = entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return ClienteRetorno;
	}
	
	public void removerCliente(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(Cliente cliente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cliente ClienteDelecao = entityManager.find(Cliente.class, cliente.getIdCliente());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(ClienteDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<Cliente> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<Cliente> listaCliente = entityManager.createQuery("FROM Cliente ORDER BY idCliente ASC", Cliente.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaCliente;
		
	}
	
	 public Cliente buscarPorId(Long idCliente) {
		 	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        Cliente cliente = entityManager.find(Cliente.class, idCliente);
	        entityManager.close();
	        return cliente;    
	    }

}
