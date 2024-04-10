package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivelExcecoes;

import java.util.Date;

public class Lote {
	private int quantidade;
	private Date validade;

	public Lote(int quant, Date validade) {
		this.quantidade = quant;
		this.validade = validade;
	}

	public Date getValidade() {
		return validade;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int q) {
		quantidade-=q;
	}
}
