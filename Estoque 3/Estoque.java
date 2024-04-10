package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivelExcecoes;

import java.util.ArrayList;
import java.util.Date;

public class Estoque {
	ArrayList<Produto> produtos = new ArrayList<Produto>();

	// PESQUISAR-------------------------------------------------------------
	public Produto pesquisar(int cod) throws ProdutoInexistente{
		for (int i = 0; i < produtos.size(); i++)
			if (cod == produtos.get(i).getCodigo())
				return produtos.get(i);
		return null;
	}

	// INCLUIR-----------------------------------------------------------
	public void incluir(Produto p) throws DadosInvalidos, ProdutoJaCadastrado, ProdutoInexistente{
		if(p==null || pesquisar(p.getCodigo())!=null || p.getCodigo()<0 || p.getDescricao().trim().isEmpty()
				|| p.getEstoqueMinimo()<0 || p.getLucro()<0 || p.getFornecedor()==null || p.getFornecedor().getCnpj()<=0) {
			throw new DadosInvalidos();
		}else {
			produtos.add(p);
		}
	}

	// COMPRAR-----------------------------------------------------------
	public void comprar(int cod, int quant, double preco, Date val) throws DadosInvalidos,ProdutoInexistente,ProdutoNaoPerecivel,ProdutoVencido{
		if (pesquisar(cod) == null || quant < 0 || preco < 0) {
			throw new ProdutoInexistente();
		} else {
			Produto prod = pesquisar(cod);
			prod.compra(quant, preco, val);
		}
	}

	// VENDER------------------------------------------------------------
	public double vender(int cod, int quant) throws DadosInvalidos, ProdutoInexistente{
		if (quant <= 0) {
			throw new DadosInvalidos();
		} else {
			Produto prod = pesquisar(cod);
			if(prod==null) {
				throw new ProdutoInexistente();
			}else {
				double lucro = prod.venda(quant);
				return lucro;
			}
		}
	}

	// ESTOQUES ABAIXO DO MINIMO-----------------------------------------
	public ArrayList<Produto> estoqueAbaixoDoMinimo() {
		ArrayList<Produto> abaixoMin = new ArrayList<Produto>();
		for (Produto prod : produtos) {
			if (prod.getQuantidade() < prod.getEstoqueMinimo()) {
				abaixoMin.add(prod);
			}
		}
		return abaixoMin;
	}

	// FORNECEDOR--------------------------------------------------------
	public Fornecedor fornecedor(int cod) throws ProdutoInexistente{
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
	
	//
	public void quantidadeVencidos() {
		
	}
}
