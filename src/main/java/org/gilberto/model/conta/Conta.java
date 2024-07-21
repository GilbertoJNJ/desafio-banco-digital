package org.gilberto.model.conta;

import lombok.Getter;
import org.gilberto.model.Cliente;
import org.gilberto.model.Movimentacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.gilberto.model.Movimentacao.Operacao.DEBITO;
import static org.gilberto.model.Movimentacao.Operacao.CREDITO;


public abstract class Conta implements IConta {

    private final int AGENCIA = 1;
    private static int SEQUENCIAL = 1;

    @Getter
    protected int agencia;

    @Getter
    protected int numero;

    @Getter
    protected double saldo;

    protected List<Movimentacao> extrato;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA;
        this.numero = SEQUENCIAL++;
        this.extrato = new ArrayList<>();
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
        this.extrato.add(new Movimentacao(DEBITO, valor));
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.extrato.add(new Movimentacao(CREDITO, valor));
    }

    @Override
    public void transferir(double valor, Conta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    @Override
    public void imprimeExtrato() {
        var extrato = this.extrato.stream()
                .sorted(Comparator.comparing(Movimentacao::getData))
                .map(Movimentacao::toString)
                .collect(Collectors.toList());

        System.out.printf("Extrato da conta: %s%n ", this.numero);
        System.out.println(extrato);
    }

    @Override
    public void exibeInfosDaConta() {
        System.out.printf("Informações da conta: %s%n", this.numero);
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.print("\n");
    }
}
