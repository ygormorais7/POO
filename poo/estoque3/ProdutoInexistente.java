package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivelExcecoes;

public class ProdutoInexistente extends Exception{
	ProdutoInexistente(){
		System.out.println("Produto nao existe");
	}
}
