package uy.org.curso.rest.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.org.curso.rest.modelo.Factura;
import uy.org.curso.rest.modelo.Facturas;
import uy.org.curso.rest.services.ejbs.InicializarDatosSingleton;

@Path("factura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FacturaRestService {

	
	@Inject
	private InicializarDatosSingleton datos;
	
	@GET
	public Response getAlls(){
		return Response.ok(new Facturas(datos.getFacturas())).build();
	}
	
	@GET
	@Path("{id}")
	public Response getFacturaById(@PathParam("id") Long idFactura) {
		Factura aux = datos.getFacturas().stream().filter(factura -> idFactura.equals(factura.getId())).findFirst().orElse(null);
		return Response.ok(aux).build();
	}
	
	@PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Factura factura) {
		Factura aux = datos.getFacturas().stream().filter(fac -> id.equals(fac.getId())).findFirst().orElse(null); 
		
		if (aux != null) {
			datos.getFacturas().remove(aux);
			datos.getFacturas().add(factura);
		}
		
		return Response.ok().build();
	}
}
