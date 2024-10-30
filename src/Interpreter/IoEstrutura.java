package Interpreter;

import java.util.List;

public class IoEstrutura extends EstruturaObjeto {
    public void instrucaoPrint(List<Var> pilha){
        System.out.println(pilha.getFirst().getValor());
    }
}
