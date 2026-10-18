
package com.autobots.automanager.repositorios;

import java.util.List;

import com.autobots.automanager.entidades.Telefone;

public class TelefoneAtualizador {

    public void atualizar(Telefone telefone, Telefone atualizacao) {
        if (telefone == null || atualizacao == null) {
            return;
        }

        if (atualizacao.getDdd() != null
                && !atualizacao.getDdd().trim().isEmpty()) {
            telefone.setDdd(atualizacao.getDdd());
        }

        if (atualizacao.getNumero() != null
                && !atualizacao.getNumero().trim().isEmpty()) {
            telefone.setNumero(atualizacao.getNumero());
        }
    }

    public void atualizar(List<Telefone> telefones,
                          List<Telefone> atualizacoes) {
        if (telefones == null || atualizacoes == null) {
            return;
        }

        for (Telefone atualizacao : atualizacoes) {
            if (atualizacao == null || atualizacao.getId() == null) {
                continue;
            }

            for (Telefone telefone : telefones) {
                if (telefone != null
                        && atualizacao.getId().equals(telefone.getId())) {
                    atualizar(telefone, atualizacao);
                    break;
                }
            }
        }
    }
}
