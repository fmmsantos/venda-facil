package com.vendaFacil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vendaFacil.entidades.Cliente;
import com.vendaFacil.entidades.Produto;
import com.vendaFacil.entidades.Venda;
import com.vendaFacil.entidades.VendaItem;
import com.vendaFacil.enuns.FormaPagamento;
import com.vendaFacil.enuns.TipoCliente;
import com.vendaFacil.service.VendaService;

public class Teste {
	public static void main(String[] args) {
		VendaService vendaService = new VendaService();
		Cliente cliente = new Cliente(1,"Fabiana",TipoCliente.ESPECIAL,"027699553-81");
		
		Produto produto = new Produto(1,"ventilador",new BigDecimal("75.00"));
		Produto produto1 = new Produto(1,"mesa",new BigDecimal("100.00"));
		Produto produto2 = new Produto(1,"cadeira",new BigDecimal("95.00"));
		
		VendaItem item = new VendaItem(1,new BigDecimal("75.00"),produto,1,new BigDecimal("3.00"));
		VendaItem item1 = new VendaItem(2,new BigDecimal("100.00"),produto1,1,new BigDecimal("3.00"));
		VendaItem item2 = new VendaItem(3,new BigDecimal("50.00"),produto2,1,new BigDecimal("5.00"));
		
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		
		venda.setDesconto(new BigDecimal("5.00"));
		venda.setForma(FormaPagamento.A_VISTA);
		venda.setItens(Arrays.asList(item,item1,item2));
		
		
		vendaService.calcularValorTotalItens(venda);
		vendaService.aplicarDescontoTipoCliente(venda);
		vendaService.calcularValorTotalVenda(venda);
		vendaService.imprimir(venda);
		
			
	}
}
