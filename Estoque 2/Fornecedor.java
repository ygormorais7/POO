package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivel;

public class Fornecedor {
	private String nome;
	private int cnpj;
	
	public Fornecedor(int cnpj, String nome) {
		this.nome=nome;
		this.cnpj=cnpj;
	}
	
	public int getCnpj() {
		return cnpj;
	}
}
