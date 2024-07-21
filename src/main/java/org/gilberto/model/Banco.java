package org.gilberto.model;

import org.gilberto.model.conta.Conta;
import org.gilberto.model.conta.ContaCorrente;
import org.gilberto.model.conta.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void criaContaCorrente(Cliente cliente) {
        this.contas.add(new ContaCorrente(cliente));
    }

    public void criaContaPoupanca(Cliente cliente) {
        this.contas.add(new ContaPoupanca(cliente));
    }

    public Optional<Conta> buscarContaPorNumero(int numero) {
        return this.contas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst();
    }
}
