package dev.fujioka.java.avancado.web.livro;

import dev.fujioka.java.avancado.web.model.Livro;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LivroConsumer {
    @JmsListener(destination = "livro_queue")
    public void receiveMessage(Livro livro) {
        System.out.println("Mensagem da fila:" + livro);
    }
}
