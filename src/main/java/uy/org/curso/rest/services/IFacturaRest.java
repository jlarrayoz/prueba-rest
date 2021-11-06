package uy.org.curso.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uy.org.curso.rest.modelo.Factura;


@Path("factura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IFacturaRest {

	@GET
	Response getAlls();

	@GET
	@Path("{id}")
	Response getFacturaById(@PathParam("id") Long id);

	@PUT
    @Path("{id}")
	Response update(@PathParam("id") Long id, Factura factura);
	
	@DELETE
	@Path("{id}")
	Response delete(@PathParam("id") Long id);
	
	@POST
	Response create(Factura factura);

}