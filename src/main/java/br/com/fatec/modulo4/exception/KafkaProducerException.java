package br.com.fatec.modulo4.exception;

public class KafkaProducerException extends RuntimeException {

    public KafkaProducerException(String message, Throwable cause) {
        super(message, cause);
    }
}

