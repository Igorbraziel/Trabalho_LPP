package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoLoad {
    public static Boolean instrucaoLoad(String linhaCompilada, List<Var> pilha, String funcaoAtual){
        Pattern pattern = Pattern.compile("^\\s*load\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            //Precisa remover algo?

            /*PEGA O VALOR DA VARIÁVEL CUJA O NOME FOI RECEBIDO, SENDO QUE, PARA ISSO
            * É NECESSÁRIO IDENTIFICAR O ESCOPO DE VARIÁVEIS EM EXECUÇÃO*/
            Var variavel = new Var("", getEscopos().get(funcaoAtual).get(nomeVariavel).getValor());
            pilha.addFirst(variavel);

            System.out.println(pilha);

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

