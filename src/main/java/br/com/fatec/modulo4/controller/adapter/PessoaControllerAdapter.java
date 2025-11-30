package br.com.fatec.modulo4.controller.adapter;

import br.com.fatec.modulo4.controller.dto.request.PessoaCreateRequest;
import br.com.fatec.modulo4.entity.Pessoa;

public final class PessoaControllerAdapter {

    private PessoaControllerAdapter() {
        throw new UnsupportedOperationException("Classe utilitária não pode ser instanciada");
    }

    public static Pessoa cast(PessoaCreateRequest request) {
        return new Pessoa(
                request.nome(),
                request.dataNascimento()
        );
    }
}
