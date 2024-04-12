package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivel;

import java.util.ArrayList;
import java.util.Date;

public class Estoque {
	ArrayList<Produto> produtos = new ArrayList<Produto>();

	// PESQUISAR-------------------------------------------------------------
	public Produto pesquisar(int cod) {
		for (int i = 0; i < produtos.size(); i++)
			if (cod == produtos.get(i).getCodigo())
				return produtos.get(i);
		return null;
	}

	// INCLUIR-----------------------------------------------------------
	public boolean incluir(Produto p) {
		if(p==null || pesquisar(p.getCodigo())!=null || p.getCodigo()<0 || p.getDesc().trim().isEmpty()
				|| p.getMinimo()<0 || p.getLucro()<0 || p.getFornecedor()==null || p.getFornecedor().getCnpj()<=0) {
			return false;
		}else {
			produtos.add(p);
			return true;
		}
	}

	// COMPRAR-----------------------------------------------------------
	public boolean comprar(int cod, int quant, double preco, Date val) {
		if (pesquisar(cod) == null || quant < 0 || preco < 0) {
			return false;
		} else {
			Produto prod = pesquisar(cod);
			boolean valor = prod.compra(quant, preco, val);
			if (valor == true) {
				return true;
			} else {
				return false;
			}
		}
	}

	// VENDER------------------------------------------------------------
	public double vender(int cod, int quant) {
		if (quant <= 0) {
			return -1;
		} else {
			Produto prod = pesquisar(cod);
			double lucro = prod.venda(quant);
			return lucro;
		}
	}

	// ESTOQUES ABAIXO DO MINIMO-----------------------------------------
	public ArrayList<Produto> estoqueAbaixoDoMinimo() {
		ArrayList<Produto> abaixoMin = new ArrayList<Produto>();
		for (Produto prod : produtos) {
			if (prod.getQuantidade() < prod.getMinimo()) {
				abaixoMin.add(prod);
			}
		}
		return abaixoMin;
	}

	// FORNECEDOR--------------------------------------------------------
	public Fornecedor fornecedor(int cod) {
		Produto prod = pesquisar(cod);
		return prod.getFornecedor();
	}

	//ESTOQUE VENCIDO----------------------------------------------------
	public ArrayList<Produto> estoqueVencido(){
		ArrayList<Produto> vencidos = new ArrayList<Produto>();
		for(Produto p:produtos) {
			if(p.isVencido()) {
				vencidos.add(p);
			}
		}
		return vencidos;
	}
}
