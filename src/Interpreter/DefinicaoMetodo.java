package Interpreter;

import java.util.LinkedList;

/*Estrutura geral dos métodos.
* Quando uma classe possui métodos, é instanciado um objeto deste para guardar o método.*/

public class DefinicaoMetodo {
    private String nome;
    private LinkedList<String> instrucoes = new LinkedList<String>();
    private EstruturaObjeto self;
    private String parametros;

    DefinicaoMetodo(String nome){
        this.nome = nome;
    }

    public void setInstrucoes(LinkedList<String> instrucoes){
        this.instrucoes = instrucoes;
    }
    public void setSelf(EstruturaObjeto self) { this.self = self; }

    public void setParametros(String parametros) {this.parametros = parametros;}

    public LinkedList<String> getInstrucoes(){
        return instrucoes;
    }
    public String getNome(){
        return nome;
    }
    public EstruturaObjeto getSelf() { return self; }
    public String getParametros() {return parametros;}
}
