package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivelExcecoes;

import java.util.Date;

public class Produto {
	protected int codigo;
	protected String descricao;
	protected double precoCompra;
	protected double precoVenda;
	protected double lucro;
	protected int quantidade;
	protected int estoqueMin;
	protected Fornecedor fornecedor;
	
	public Produto(int cod, String desc, int min, double lucro, Fornecedor forn) {
		this.codigo = cod;
		this.descricao = desc;
		this.estoqueMin = min;
		this.lucro = lucro;
		this.fornecedor = forn;
		this.quantidade = 0;
		this.precoVenda = 0;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}

	public int getEstoqueMinimo() {
		return this.estoqueMin;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public double getLucro() {
		return lucro;
	}
	public double getPrecoDeVenda() {
		return precoVenda;
	}
	public double getPrecoDeCompra() {
		return precoCompra;
	}
	public void compra(int quant, double val, Date validade) throws ProdutoNaoPerecivel, ProdutoVencido {
		if (validade != null) {
			throw new ProdutoNaoPerecivel();
		}
		precoCompra = (quantidade * precoCompra + quant * val) / (quantidade + quant);
		quantidade += quant;
		precoVenda = (1 + lucro) * precoCompra;
	}

	public double venda(int quant) {
		if (quant >= 0 && quantidade >= quant && quantidade >= estoqueMin) {
			quantidade -= quant;
			return quant * precoVenda;
		} else {
			return -1;
		}
	}
	
	
	
	public boolean isVencido() {
		return false;
	}
}
