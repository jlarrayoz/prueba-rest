package uy.org.curso.rest.test;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.junit.Test;

import uy.org.curso.rest.services.PruebaRestService;

public class URITest {

	@Test
	public void testURIBuilders() {

		//PathParam
		URI uri = UriBuilder.fromUri("http://www.bse.com").path("persona").path("6754").build();
		assertEquals("http://www.bse.com/persona/6754", uri.toString());

		//QueryParam
		uri = UriBuilder.fromUri("http://localhost:8080/prueba-rest").path("rest").path("persona")
				.queryParam("nombre", "Juan Larrayoz").build();
		assertEquals("http://localhost:8080/prueba-rest/rest/persona?nombre=Juan+Larrayoz", uri.toString());

		//MatrixParam
		uri = UriBuilder.fromUri("http://localhost:8080/prueba-rest").path("persona").matrixParam("nombre", "Larrayoz")
				.build();
		assertEquals("http://localhost:8080/prueba-rest/persona;nombre=Larrayoz", uri.toString());
		
		//QueryParam con substitucion de valores
		uri = UriBuilder.fromUri("http://www.google.com").path("{path}").queryParam("nombre", "{valor}").build("persona", "Larrayoz");
		assertEquals("http://www.google.com/persona?nombre=Larrayoz", uri.toString());
		
		//Construir path desde el class de un servicio rest
		uri = UriBuilder.fromResource(PruebaRestService.class).path("string").build();
		assertEquals("/prueba/string", uri.toString());
		
		
	}

}
