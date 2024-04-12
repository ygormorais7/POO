package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivelExcecoes;

public class ProdutoJaCadastrado extends Exception{
	ProdutoJaCadastrado(){
		System.out.println("Produto ja cadastrado");
	}
}
