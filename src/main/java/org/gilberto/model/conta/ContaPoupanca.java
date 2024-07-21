package org.gilberto.model.conta;

import org.gilberto.exception.OperacaoNaoPermitida;
import org.gilberto.model.Cliente;
import org.gilberto.model.Movimentacao;

import static org.gilberto.model.Movimentacao.Operacao.DEBITO;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo)
            throw new OperacaoNaoPermitida();

        this.saldo -= valor;
        this.extrato.add(new Movimentacao(DEBITO, valor));
    }
}
