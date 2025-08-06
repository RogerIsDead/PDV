package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Funcionario;

public class FuncionarioDao {
	
	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		Funcionario FuncionarioRetorno = entityManager.merge(funcionario);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return FuncionarioRetorno;
	}
	
	public void removerFuncionario(Funcionario funcionario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(funcionario);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(Funcionario funcionario) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Funcionario FuncionarioDelecao = entityManager.find(Funcionario.class, funcionario.getIdFuncionario());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(FuncionarioDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<Funcionario> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<Funcionario> listaFuncionario = entityManager.createQuery("FROM Funcionario ORDER BY id ASC", Funcionario.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaFuncionario;
		
	}
	
	 public Funcionario buscarPorId(Long idFuncionario) {
		 	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        Funcionario funcionario = entityManager.find(Funcionario.class, idFuncionario);
	        entityManager.close();
	        return funcionario;    
	    }

}
