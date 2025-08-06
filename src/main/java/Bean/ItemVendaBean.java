package Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Dao.ItemVendaDao;
import Entidades.ItemVenda;

@ViewScoped
@ManagedBean(name = "itemVendaBean")
public class ItemVendaBean {	
	private List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
		
	public ItemVendaBean() {
		setItemVenda(new ItemVenda());;
	}

	public ItemVenda itemVenda;
	
	public ItemVenda getItemVenda() {
		return itemVenda;
	}
	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}
	public List<ItemVenda> getItensVenda(){
		return itensVenda;
	}
	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
	
	public String inserirItemVenda() {
		ItemVendaDao ItemVendaDao = new ItemVendaDao();
		ItemVendaDao.atualizarItemVenda(getItemVenda());
		carregarItemVenda();
		limparItemVenda();
		return "";
	}
	
	public String removerItemVenda() {
		ItemVendaDao ItemVendaDao = new ItemVendaDao();
		ItemVendaDao.removerPorId(getItemVenda());
		carregarItemVenda();
		limparItemVenda();
		return "";
	}
	
	@PostConstruct
	public void carregarItemVenda() {
		ItemVendaDao ItemVendaDao = new ItemVendaDao();
		setItensVenda(ItemVendaDao.getListEntity());
	}
	
	public String limparItemVenda() {
		setItemVenda(new ItemVenda());
		return "";
	}

}
