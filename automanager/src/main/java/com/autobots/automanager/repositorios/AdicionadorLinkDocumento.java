package com.autobots.automanager.modelo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.DocumentoControle;
import com.autobots.automanager.entidades.Documento;

@Component
public class AdicionadorLinkDocumento implements AdicionadorLink<Documento> {

	@Override
	public void adicionarLink(List<Documento> lista) {
		for (Documento documento : lista) {
			adicionarLink(documento);
		}
	}

	@Override
	public void adicionarLink(Documento documento) {
		long id = documento.getId();
		documento.add(linkTo(methodOn(DocumentoControle.class).obterDocumento(id)).withSelfRel());
		documento.add(linkTo(methodOn(DocumentoControle.class).obterDocumentos()).withRel("documentos"));
	}
}
