package ygorFranciscoDeCarvalhoMorais.estoqueComProdutoPerecivel;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class ProdutoPerecivel extends Produto{
	private ArrayList<Lote> lotes = new ArrayList<Lote>();
	
	public ProdutoPerecivel(int cod, String desc, int min, double lucro, Fornecedor forn) {
		super(cod, desc, min, lucro, forn);
	}
	
	public boolean isVencido() {
		Date data = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
		for(Lote lot:lotes) {
			if(lot.getValidade().before(data)) {
				return true;
			}
		}
		return false;
	}
	
	public Lote getLote(){
		Date data = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
		Lote maisPerto = lotes.get(0);
		for(Lote lot:lotes) {
			if(maisPerto.getValidade().before(lot.getValidade()) && maisPerto.getValidade().after(data)) {
				maisPerto=lot;
			}
		}
		if(maisPerto.getValidade().after(data)) {
			return maisPerto;
		}
		return null;
	}
	
	public boolean compra(int quant, double val, Date validade) {
		super.compra(quant, val, validade);
		Date atual = Date.from(Instant.now(Clock.system(ZoneId.of("America/Sao_Paulo"))));
		if(validade!=null && atual.before(validade)) {
			precoCompra = (quantidade * precoCompra + quant * val) / (quantidade + quant);
			quantidade += quant;
			precoVenda = (1 + lucro) * precoCompra;
			Lote lot = new Lote(quant,validade);
			lotes.add(lot);
			return true;
		}else {
			return false;
		}
	}
	
	public double venda(int quant) {
		super.venda(quant);
		Lote lote = this.getLote();
		if(lote!=null) {
			int q =lote.getQuantidade();
			if(q<quant) {
				quant-=q;
				q-=quant;
				lote.setQuantidade(q);
			}
			q-= quant;
			lote.setQuantidade(q);
			return quant * precoVenda;
		}
		return -1;
	}
	
	/*public double venda(int quant) {
		super.venda(quant);
		int quantidad = quant;
		Lote lote = this.getLote();
		int q = lote.getQuantidade();
		if (lote == null || q==0) {
			return -1;
		}else {
			if(quant>q) {
				int repeater=1;
				while(repeater==1) {
					q = lote.getQuantidade();
					if(quant<q) {
						q-=quant;
						quant=0;
						lote.setQuantidade(q);
					}
					if(quant>=q) {
						quant-=q;
						lote.setQuantidade(0);
					}
					if(quant==0)
						repeater=0;
				}
			}
			q -= quant;
			lote.setQuantidade(q);
			return quantidad * precoVenda;
		}
	}*/
}
