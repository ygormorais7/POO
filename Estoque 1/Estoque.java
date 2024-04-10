package ygorFranciscoDeCarvalhoMorais.estoque;

import java.util.ArrayList;

public class Estoque {
	ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Produto pesquisar(int cod) {
		for (Produto prod : produtos) {
			if (prod.getCodigo() == cod) {
				return prod;
			}
		}
		return null;
	}

	public void incluir(Produto prod1) {
		if (pesquisar(prod1.getCodigo()) != null) {
			System.out.println("PRODUTO JA CADASTRADO");
		} else {
			produtos.add(prod1);
		}
	}

	public void comprar(int cod, int quant, double preco) {
		if (preco > 0) {
			Produto prod = pesquisar(cod);
			prod.compra(quant, preco);
		}
	}

	public double vender(int cod, int quant) {
		Produto prod = pesquisar(cod);
		if (quant <= prod.quantidade(cod)) {
			double rtn = prod.venda(cod, quant);
			return rtn;
		} else {
			return -1;
		}
	}

	public int quantidade(int cod) {
		Produto prod = pesquisar(cod);
		if (prod != null) {
			return prod.quantidade(cod);
		} else {
			return -1;
		}
	}

	public Fornecedor fornecedor(int cod) {
		Produto prod = pesquisar(cod);
		return prod.getFornecedor();

	}

	public Produto[] estoqueAbaixoDoMinimo() {
		Produto[] array = new Produto[1];
		int i = 0;
		for (Produto prod : produtos) {
			if (prod.getEstoqueMin() < prod.getQuantidade()) {
				array[i++] = prod;
			}
		}
		return array;
	}
}
