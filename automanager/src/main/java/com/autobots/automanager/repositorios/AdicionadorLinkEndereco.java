package com.autobots.automanager.modelo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.EnderecoControle;
import com.autobots.automanager.entidades.Endereco;

@Component
public class AdicionadorLinkEndereco implements AdicionadorLink<Endereco> {

	@Override
	public void adicionarLink(List<Endereco> lista) {
		for (Endereco endereco : lista) {
			adicionarLink(endereco);
		}
	}

	@Override
	public void adicionarLink(Endereco endereco) {
		long id = endereco.getId();
		endereco.add(linkTo(methodOn(EnderecoControle.class).obterEndereco(id)).withSelfRel());
		endereco.add(linkTo(methodOn(EnderecoControle.class).obterEnderecos()).withRel("enderecos"));
	}
}
