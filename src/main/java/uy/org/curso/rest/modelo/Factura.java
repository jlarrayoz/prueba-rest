package uy.org.curso.rest.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
	private Long id;
	private Persona cliente;
	private Date fecha;
	private List<LineaFactura> lineas = new ArrayList<LineaFactura>();
	
	
	public Factura() {
		super();
	}
	
	public Factura(Long id, Persona cliente, Date fecha, List<LineaFactura> lineas) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.lineas = lineas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<LineaFactura> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaFactura> lineas) {
		this.lineas = lineas;
	}
}
