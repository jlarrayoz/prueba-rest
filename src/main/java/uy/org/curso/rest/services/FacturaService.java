package uy.org.curso.rest.services;


import java.net.URI;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import uy.org.curso.rest.modelo.Factura;
import uy.org.curso.rest.modelo.Facturas;
import uy.org.curso.rest.services.ejbs.InicializarDatosSingleton;


@Stateless
@LocalBean
public class FacturaService implements IFacturaRest {

	
	@Inject
	private InicializarDatosSingleton datos;
	
	@Context
	UriInfo uriInfo;

	/**
	 * La respuesta de todo GET deberia ser 200 OK si se ejecuto correctamente
	 */
	@Override
	public Response getAlls(){
		return Response.ok(new Facturas(datos.getFacturas())).build();
	}
	
	/**
	 * La respuesta de todo GET deberia ser 200 OK si se ejecuto correctamente
	 */
	@Override
	public Response getFacturaById(Long id) {
		Factura aux = buscarFactura(id);
		return Response.ok(aux).build();
	}
	
	/**
	 * La respuesta del DELETE puede ser:
	 * 200 OK o 204 NO Content si el request se ejecuto correctamente
	 */
	@Override
    public Response update(Long id, Factura factura) {
		Factura aux = buscarFactura(id); 		

		datos.getFacturas().remove(aux);
		datos.getFacturas().add(factura);
		
		return Response.ok().build();
	}

	/**
	 * La respuesta del DELETE puede ser:
	 * 200 OK -> si en el response body se quiere incluir algo
	 * 204 NO Content -> si el response no incluye nada en el body 
	 */
	@Override
	public Response delete(Long id) {
		Factura aux = buscarFactura(id);
		datos.getFacturas().remove(aux);
		return Response.noContent().build();
	}

	/**
	 * La respuesta del create puede ser:
	 * 201 Created y la URI del nuevo recurso creado
	 * 204 NO Content si el recurso creado no se puede identificar con una URI 
	 */
	@Override
	public Response create(Factura factura) {
		
		//Si no se recibe factura se lanza exception con un 400 - Bad Request
		if (factura == null) {
			throw new BadRequestException();
		}
				
		datos.getFacturas().add(factura);
		URI facturaUri = uriInfo.getAbsolutePathBuilder().path(factura.getId().toString()).build();
		return Response.created(facturaUri).build();
	}
	
	
	/**
	 * Metodo auxiliar que se encarga de buscar una factura
	 * Si la encuentra la retorna, en caso contrario lanza una NotFoundException
	 * @param id Identificador de la factura
	 * @return Factura
	 */
	private Factura buscarFactura(Long id) {
		Factura aux = datos.getFacturas().stream().filter(fac -> id.equals(fac.getId())).findFirst().orElse(null);
		
		if (aux != null) {
			return aux;
		}
		else {
			throw new NotFoundException();	
		}
	}
}
