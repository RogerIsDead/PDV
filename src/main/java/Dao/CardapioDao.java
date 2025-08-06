package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Cardapio;

public class CardapioDao {
	
	public Cardapio atualizarCardapio(Cardapio cardapio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		Cardapio CardapioRetorno = entityManager.merge(cardapio);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return CardapioRetorno;
	}
	
	public void removerCardapio(Cardapio cardapio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(cardapio);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(Cardapio cardapio) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cardapio CardapioDelecao = entityManager.find(Cardapio.class, cardapio.getIdProduto());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(CardapioDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<Cardapio> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<Cardapio> listaCardapio = entityManager.createQuery("FROM Cardapio ORDER BY id ASC", Cardapio.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaCardapio;
		
	}

}
