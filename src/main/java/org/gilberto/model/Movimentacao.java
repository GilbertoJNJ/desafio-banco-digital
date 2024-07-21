package org.gilberto.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Movimentacao {

    private Operacao operacao;
    private double valor;
    private LocalDateTime data;

    public Movimentacao(Operacao operacao, double valor) {
        this.operacao = operacao;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "Operação=" + operacao +
                ", Valor=" + valor +
                ", Data=" + data +
                '}' + "\n";
    }

    public enum Operacao {
        CREDITO, DEBITO
    }
}
