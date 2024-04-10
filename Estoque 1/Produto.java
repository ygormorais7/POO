package ygorFranciscoDeCarvalhoMorais.estoque;

public class Produto {
	private int codigo;
	private String descricao;
	private double precoCompra;
	private double precoVenda;
	private double lucrop;
	private int quantidade;
	private int estoqueMin;
	private Fornecedor fornecedor;

	public Produto(int cod, String desc, int min, double lucro, Fornecedor forn) {
		codigo = cod;
		descricao = desc;
		estoqueMin = min;
		lucrop = lucro;
		fornecedor = forn;
		quantidade = 0;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public int getEstoqueMin() {
		return this.estoqueMin;
	}

	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void compra(int quant, double val) {
		precoCompra = (quantidade * precoCompra + quant * val) / (quantidade + quant);
		quantidade += quant;
		precoVenda = precoCompra * (1 + lucrop);
	}

	public double venda(int cod, int quant) {
		if (quantidade >= quant) {
			quantidade -= quant;
			return quant * this.precoVenda;
		}
		return -1;
	}

	public int quantidade(int cod) {
		return this.quantidade;
	}
}
