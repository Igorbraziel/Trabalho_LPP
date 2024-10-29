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
        EstruturaObjeto prototipo;


        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            if(nomeVariavel.equals("io")){
                pilha.addFirst(getEscopos().get("io").get("io"));
                return true;
            }
            //Precisa remover algo?

            /*PEGA O VALOR DA VARIÁVEL CUJA O NOME FOI RECEBIDO, SENDO QUE, PARA ISSO
             * É NECESSÁRIO IDENTIFICAR O ESCOPO DE VARIÁVEIS EM EXECUÇÃO*/
            if (getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey(nomeVariavel)) {
                Var variavel = new Var("", getEscopos().get(getFuncaoEmExecucao().getFirst()).get(nomeVariavel).getValor());
                pilha.addFirst(variavel);
            }
//            else {
//                if(getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey("_prototype")){
//                    if(getEscopos().get(getFuncaoEmExecucao().getFirst()).get("_prototype").getValor() instanceof EstruturaObjeto){
//                        prototipo = ((EstruturaObjeto) getEscopos().get(getFuncaoEmExecucao().getFirst()).get("_prototype").getValor());
//                        if(prototipo.getVariaveisDoObjeto().containsKey(nomeVariavel)){
//                            Var variavel = new Var("", prototipo.getVariaveisDoObjeto().get(nomeVariavel).getValor());
//                            pilha.addFirst(variavel);
//                        }
//                    }
//                }
//            }


            System.out.println(pilha);
//            System.out.println(getFuncaoEmExecucao().getFirst() + " ----> " + getEscopos().get(getFuncaoEmExecucao().getFirst()));
//            System.out.println(getEscopos());

            return true;


        }
        return false;
    }

    public static Boolean instrucaoLoadMetodo(String linhaCompilada, List<Var> pilha, DefinicaoMetodo metodoChamado){
        Pattern pattern = Pattern.compile("^\\s*load\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            //Precisa remover algo?

            /*PEGA O VALOR DA VARIÁVEL CUJA O NOME FOI RECEBIDO, SENDO QUE, PARA ISSO
             * É NECESSÁRIO IDENTIFICAR O ESCOPO DE VARIÁVEIS EM EXECUÇÃO*/
            if (getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey(nomeVariavel)) {
                Var variavel = new Var("", getEscopos().get(getFuncaoEmExecucao().getFirst()).get(nomeVariavel).getValor());
                pilha.addFirst(variavel);
            } else {

                if(metodoChamado.getSelf().getVariaveisDoObjeto().containsKey(nomeVariavel)){
                    Var variavel = new Var("", metodoChamado.getSelf().getVariaveisDoObjeto().get(nomeVariavel).getValor());
                    pilha.addFirst(variavel);
                }
            }

            System.out.println(pilha);
//            System.out.println(getFuncaoEmExecucao().getFirst() + " ----> " + getEscopos().get(getFuncaoEmExecucao().getFirst()));
//            System.out.println(getEscopos());

            return true;
        }
        return false;
    }
}

