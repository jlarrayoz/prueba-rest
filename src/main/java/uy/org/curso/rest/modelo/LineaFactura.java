package uy.org.curso.rest.modelo;

import java.math.BigDecimal;

public class LineaFactura {
	private Long id;
	private String producto;
	private int cantidad;
	private BigDecimal monto;
	
	
	
	
	public LineaFactura() {
		super();
	}

	public LineaFactura(Long id, String producto, int cantidad, BigDecimal monto) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.monto = monto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	

}
