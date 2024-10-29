package Interpreter;

import java.io.BufferedReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;
import static Interpreter.Intermediadora.intermediadora;



public class InstrucaoCall {
    public static Boolean instrucaoCall(String linhaCompilada, List<Var> pilha, BufferedReader br){
        Pattern pattern = Pattern.compile("^\\s*call\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);
        if(matcher.find()){
            if(matcher.group(1).equals("print")){
                if (pilha.getFirst().getValor() instanceof IoEstrutura){
                    IoEstrutura ioGenerico = ((IoEstrutura) pilha.getFirst().getValor());
                    pilha.removeFirst();
                    ioGenerico.instrucaoPrint(pilha);
                    pilha.removeFirst();
                    Var retornoIo = new Var<>("-", 0);
                    pilha.addFirst(retornoIo);
                    return true;
                }
            }
            DefinicaoMetodo metodoChamado = new DefinicaoMetodo(matcher.group(1));
            if (pilha.getFirst().getValor() instanceof EstruturaObjeto) {
                EstruturaObjeto objetoChamado = ((EstruturaObjeto) pilha.getFirst().getValor());
                pilha.removeFirst();
                metodoChamado.setSelf(objetoChamado);
                metodoChamado.getSelf().identificaMetodo(metodoChamado, objetoChamado);
                System.out.println("Identificou a call " + metodoChamado.getNome() + " " + metodoChamado.getInstrucoes() + " " + metodoChamado.getParametros());

                //metodoChamado.setParametros(metodoChamado.getSelf().identificaMetodo());
                getFuncaoEmExecucao().addFirst(  getFuncaoEmExecucao().getFirst() + "-" + metodoChamado.getSelf() + "->" + metodoChamado.getNome());
                metodoChamado.getSelf().executaMetodo(linhaCompilada, pilha, br, metodoChamado);





            }
        }
        return false;
    }
}
