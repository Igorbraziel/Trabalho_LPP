package Interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoLoad {
    public static Boolean instrucaoLoad(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*load\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);
        Boolean achouMatch;
        String paraString;

        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            //Precisa remover algo?

            /*PEGA O VALOR DA VARIÁVEL CUJA O NOME FOI RECEBIDO, SENDO QUE, PARA ISSO
            * É NECESSÁRIO IDENTIFICAR O ESCOPO DE VARIÁVEIS EM EXECUÇÃO*/
            if (getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey(nomeVariavel)) {
                Var variavel = new Var("", getEscopos().get(getFuncaoEmExecucao().getFirst()).get(nomeVariavel).getValor());
                pilha.addFirst(variavel);
            } else {
                System.out.println("Não achou no escopo atual");
                pattern = Pattern.compile("^\\s*(.+)-(Interpreter\\.EstruturaObjeto@[a-zA-Z0-9]+)->[\\w]+\\s*$");
                matcher = pattern.matcher(getFuncaoEmExecucao().getFirst());
                achouMatch = matcher.find();
                System.out.println("Funcao em execução: " + getFuncaoEmExecucao().getFirst());
                if(achouMatch){
                    System.out.println("Achou o match do escopo passado");
                    System.out.println(matcher.group(2));
//                    if (getEscopos().get(matcher.group(1)).containsValue(matcher.group(2))){
//                        System.out.println("Achou o objeto " + matcher.group(2));
//                    }
                    for (String item : getEscopos().get(matcher.group(1)).keySet()){

                        System.out.println(item);
                    }
                }
            }

            System.out.println(pilha);
//            System.out.println(getFuncaoEmExecucao().getFirst() + " ----> " + getEscopos().get(getFuncaoEmExecucao().getFirst()));
//            System.out.println(getEscopos());

            return true;

//            for (Var var : pilha) {
//                if (var.getNome().equals(nomeVariavel)) {
//                    pilha.remove(var);
//                    pilha.addFirst(var);
//                    return true;
//                }
//            }
//            System.out.println(pilha);
//            return true;
        }
        return false;
    }
}

