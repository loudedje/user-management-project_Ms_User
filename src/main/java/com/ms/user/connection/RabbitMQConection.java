package com.ms.user.connection;

import com.ms.user.constante.RabbitmqCons;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQConection {
    private static final String NOME_EXCHANGE = "amq.direct";

    private final AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca){
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }
@PostConstruct
    public void adiciona(){
        Queue filaAddress = this.fila(RabbitmqCons.FILA_ADDRESS);
        DirectExchange troca = this.trocaDireta();
        Binding ligacaoAddress = this.relacionamento(filaAddress, troca);

        this.amqpAdmin.declareQueue(filaAddress);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(ligacaoAddress);
    }
}
