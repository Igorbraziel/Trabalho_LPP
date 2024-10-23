package Interpreter;

import java.util.ArrayList;

public class DefinicaoMetodo {
    private String nome;
    private ArrayList<String> instrucoes = new ArrayList<String>();

    DefinicaoMetodo(String nome){
        this.nome = nome;
    }

    public void setInstrucoes(ArrayList<String> instrucoes){
        this.instrucoes = instrucoes;
    }

    public ArrayList<String> getInstrucoes(){
        return instrucoes;
    }

    public String getNome(){
        return nome;
    }
}
