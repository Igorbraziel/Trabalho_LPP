package Interpreter;

import java.util.LinkedList;

/*Estrutura geral dos métodos.
* Quando uma classe possui métodos, é instanciado um objeto deste para guardar o método.*/

public class DefinicaoMetodo {
    private String nome;
    private LinkedList<String> instrucoes = new LinkedList<String>();

    DefinicaoMetodo(String nome){
        this.nome = nome;
    }

    public void setInstrucoes(LinkedList<String> instrucoes){
        this.instrucoes = instrucoes;
    }

    public LinkedList<String> getInstrucoes(){
        return instrucoes;
    }

    public String getNome(){
        return nome;
    }
}
