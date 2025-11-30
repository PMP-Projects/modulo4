package br.com.fatec.modulo4;

import br.com.fatec.modulo4.entity.Pessoa;
import br.com.fatec.modulo4.event.PessoaEventProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Modulo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Modulo4Application.class, args);
    }

}
