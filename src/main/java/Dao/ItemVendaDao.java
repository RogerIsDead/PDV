package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.ItemVenda;

public class ItemVendaDao {
	
	public ItemVenda atualizarItemVenda(ItemVenda itemVenda) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		ItemVenda ItemVendaRetorno = entityManager.merge(itemVenda);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Atualizados com Sucesso :)"));
        return ItemVendaRetorno;
	}
	
	public void removerItemVenda(ItemVenda itemVenda) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(itemVenda);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public void removerPorId(ItemVenda itemVenda) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		ItemVenda ItemVendaDelecao = entityManager.find(ItemVenda.class, itemVenda.getIdItemVenda());
		 
		entityManager.getTransaction().begin();		
		entityManager.remove(ItemVendaDelecao);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dados Excluídos com Sucesso :)"));		
	}
	
	public List<ItemVenda> getListEntity() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PizzaHot");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	
		List<ItemVenda> listaItemVenda = entityManager.createQuery("FROM ItemVenda ORDER BY id ASC", ItemVenda.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return listaItemVenda;
		
	}

}
