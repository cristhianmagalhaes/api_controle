package br.com.cantinhodoparque.resource;

import br.com.cantinhodoparque.service.ResponsavelService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/responsavel")
public class ResponsavelResource {
	
	@Inject
	ResponsavelService responsavelService;
	
	@Path("/cadastrar")
	@POST
	@Transactional
	public void cadastrar() {
		responsavelService.cadastrarResponsavel();
	}

}
