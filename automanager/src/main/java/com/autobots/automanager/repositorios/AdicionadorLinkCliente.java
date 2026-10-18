package com.autobots.automanager.modelo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.ClienteControle;
import com.autobots.automanager.controles.DocumentoControle;
import com.autobots.automanager.controles.EnderecoControle;
import com.autobots.automanager.controles.TelefoneControle;
import com.autobots.automanager.entidades.Cliente;

@Component
public class AdicionadorLinkCliente implements AdicionadorLink<Cliente> {
	@Autowired
	private AdicionadorLinkDocumento adicionadorDocumento;
	@Autowired
	private AdicionadorLinkTelefone adicionadorTelefone;
	@Autowired
	private AdicionadorLinkEndereco adicionadorEndereco;

	@Override
	public void adicionarLink(List<Cliente> lista) {
		for (Cliente cliente : lista) {
			adicionarLink(cliente);
		}
	}

	@Override
	public void adicionarLink(Cliente cliente) {
		long id = cliente.getId();
		cliente.add(linkTo(methodOn(ClienteControle.class).obterCliente(id)).withSelfRel());
		cliente.add(linkTo(methodOn(ClienteControle.class).obterClientes()).withRel("clientes"));
		cliente.add(linkTo(methodOn(DocumentoControle.class).obterDocumentosDoCliente(id)).withRel("documentos"));
		cliente.add(linkTo(methodOn(TelefoneControle.class).obterTelefonesDoCliente(id)).withRel("telefones"));
		if (cliente.getEndereco() != null) {
			cliente.add(linkTo(methodOn(EnderecoControle.class).obterEnderecoDoCliente(id)).withRel("endereco"));
		}

		// links dos recursos aninhados (documentos, telefones e endereco)
		adicionadorDocumento.adicionarLink(cliente.getDocumentos());
		adicionadorTelefone.adicionarLink(cliente.getTelefones());
		if (cliente.getEndereco() != null) {
			adicionadorEndereco.adicionarLink(cliente.getEndereco());
		}
	}
}
