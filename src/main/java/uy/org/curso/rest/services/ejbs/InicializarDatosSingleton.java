package uy.org.curso.rest.services.ejbs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import uy.org.curso.rest.modelo.Factura;
import uy.org.curso.rest.modelo.LineaFactura;
import uy.org.curso.rest.modelo.Persona;

@Singleton
@Startup
public class InicializarDatosSingleton {
	
	private List<Factura> facturas = new ArrayList<Factura>();
	
	@PostConstruct
	public void init() {
		
		LineaFactura l1 = new LineaFactura(1L, "Martillo", 2, new BigDecimal("1500"));
		LineaFactura l2 = new LineaFactura(2L, "Destornillador", 1, new BigDecimal("350"));
		
		List<LineaFactura> lineas = new ArrayList<LineaFactura>();
		
		lineas.add(l1);
		lineas.add(l2);
		
		Factura f = new Factura(1L, new Persona("Pablo", "Lopez", new Date()), new Date(), lineas);
		
		LineaFactura fl1 = new LineaFactura(1L, "Zapatos", 2, new BigDecimal("3000"));
		LineaFactura fl2 = new LineaFactura(2L, "Enduido", 5, new BigDecimal("800"));
		
		List<LineaFactura> lineasf2 = new ArrayList<LineaFactura>();
		
		lineasf2.add(fl1);
		lineasf2.add(fl2);
		
		Factura f2 = new Factura(2L, new Persona("Juan", "Larrayoz", new Date()), new Date(), lineasf2);
		
		facturas.add(f);
		facturas.add(f2);
		
	}

	public List<Factura> getFacturas() {
		return facturas;
	}
	
	

}
