package com.autobots.automanager.modelo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.TelefoneControle;
import com.autobots.automanager.entidades.Telefone;

@Component
public class AdicionadorLinkTelefone implements AdicionadorLink<Telefone> {

	@Override
	public void adicionarLink(List<Telefone> lista) {
		for (Telefone telefone : lista) {
			adicionarLink(telefone);
		}
	}

	@Override
	public void adicionarLink(Telefone telefone) {
		long id = telefone.getId();
		telefone.add(linkTo(methodOn(TelefoneControle.class).obterTelefone(id)).withSelfRel());
		telefone.add(linkTo(methodOn(TelefoneControle.class).obterTelefones()).withRel("telefones"));
	}
}
