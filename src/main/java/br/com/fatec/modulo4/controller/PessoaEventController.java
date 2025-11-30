package br.com.fatec.modulo4.controller;

import br.com.fatec.modulo4.controller.adapter.PessoaControllerAdapter;
import br.com.fatec.modulo4.controller.dto.request.PessoaCreateRequest;
import br.com.fatec.modulo4.entity.Pessoa;
import br.com.fatec.modulo4.event.PessoaEventProducer;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulo-producer/v1/pessoa")
public class PessoaEventController {

    private final PessoaEventProducer producer;

    private static final Logger log = LoggerFactory.getLogger(PessoaEventController.class);

    public PessoaEventController(PessoaEventProducer producer) {
        this.producer = producer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void register(@Valid @RequestBody PessoaCreateRequest request) {
        Pessoa pessoa = PessoaControllerAdapter.cast(request);
        log.info("Pessoa registrada!\nNome: {}\nData de Nascimento: {}", pessoa.nome(), pessoa.dataNascimento());
        producer.send(pessoa);
    }
}
