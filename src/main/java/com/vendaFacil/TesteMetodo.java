package com.vendaFacil;

import com.vendaFacil.entidades.Venda;
import com.vendaFacil.entidades.VendaItem;
import com.vendaFacil.service.VendaService;

public class TesteMetodo {
	public static void main(String[] args) {
	Venda venda = null;
	metodo(venda);	
	
	}
	public static void metodo(Venda venda) {
	VendaService service = new VendaService();
	

	System.out.println("----------------------------------------");
	System.out.println("        SISTEMA VENDA FÁCIL  vesão 1.0.0");
	System.out.println("----------------------------------------");
	System.out.println("Numero da venda: " + venda.getId());
	System.out.println("Data: " + venda.getDataHora());
	System.out.println("Cliente: " + venda.getCliente().getNome() + "   CPF: "+venda.getCliente().getCpf());
	System.out.println("-----------------------------------------");
	System.out.println("PRODUTO    " +"  QTD "+ "  PC UNIT. ");
		for(VendaItem v: venda.getItens()) {		
	System.out.println(v.getProduto().getNome()+"    " + v.getQuantidade()+" "+v.getPrecoUnitario());
	}
	
	
	System.out.println("-------------------------------------------");
	System.out.println("TOTAL ITENS");	
	service.calcularValorTotalItens(venda);
	System.out.println("-------------------------------------------");
	System.out.println("QUANT. ITENS\n " + venda.getItens().size());
	System.out.println("-------------------------------------------");
	
	System.out.println("-------------------------------------------");
	

	System.out.println("TOTAL\n" + service.calcularValorTotalVenda(venda) );

	System.out.println("DESCONTO\n"+service.aplicarDescontoTipoCliente(venda));
}
	     

}
