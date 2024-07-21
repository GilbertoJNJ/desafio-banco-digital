package org.gilberto.model.conta;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta conta);

    void imprimeExtrato();

    void exibeInfosDaConta();
}
