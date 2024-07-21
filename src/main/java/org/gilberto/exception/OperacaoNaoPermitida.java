package org.gilberto.exception;

public class OperacaoNaoPermitida extends RuntimeException{
    public OperacaoNaoPermitida() {
        super("Operação Não Permitida para conta poupança");
    }
}
