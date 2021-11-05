package uy.org.curso.rest.modelo;

import java.util.ArrayList;
import java.util.List;

public class Facturas {
	private List<Factura> facturas = new ArrayList<Factura>();

	public Facturas() {
		
	}
	
	public Facturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	

}
