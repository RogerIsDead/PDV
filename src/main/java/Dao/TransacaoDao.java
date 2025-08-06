package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Transacao;

public class TransacaoDao {
	
	public Transacao atualizarTransacao(Transacao transacao) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		Transacao TransacaoRetorno = entityManager.merge(transacao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return TransacaoRetorno;
	}
	
	public void removerTransacao(Transacao transacao) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(transacao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(Transacao transacao) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Transacao TransacaoDelecao = entityManager.find(Transacao.class, transacao.getIdTransacao());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(TransacaoDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<Transacao> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<Transacao> listaTransacao = entityManager.createQuery("FROM Transacao ORDER BY id ASC", Transacao.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaTransacao;
		
	}

}
