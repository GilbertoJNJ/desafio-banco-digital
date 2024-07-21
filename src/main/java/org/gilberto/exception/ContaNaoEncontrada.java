package org.gilberto.exception;

public class ContaNaoEncontrada extends RuntimeException{
    public ContaNaoEncontrada() {
        super("Conta não encontrada");
    }
}
