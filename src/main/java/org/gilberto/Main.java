package org.gilberto;

import org.gilberto.exception.ContaNaoEncontrada;
import org.gilberto.model.Banco;
import org.gilberto.model.Cliente;

public class Main {
    public static void main(String[] args) {
        var cliente = new Cliente("Cliente");

        var banco = new Banco("Banco");
        banco.criaContaCorrente(cliente);
        banco.criaContaPoupanca(cliente);

        var conta1 = banco.buscarContaPorNumero(1)
                .orElseThrow(ContaNaoEncontrada::new);
        var conta2 = banco.buscarContaPorNumero(2)
                .orElseThrow(ContaNaoEncontrada::new);

        /* Lança exceção de conta não encontrada
        var conta3 = banco.buscarContaPorNumero(3)
                .orElseThrow(ContaNaoEncontrada::new);
        */

        conta1.depositar(100);
        conta1.transferir(30, conta2);

        conta1.sacar(200);
        conta2.sacar(10);

        /* Lança exceção para saques maior que o saldo
        conta2.sacar(30);
         */

        conta1.exibeInfosDaConta();
        conta2.exibeInfosDaConta();

        conta1.imprimeExtrato();
        conta2.imprimeExtrato();

    }
}