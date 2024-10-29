package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


//Retira o valor do topo da pilha e armazena na variável ou parâmetro “name”.
public class InstrucaoStore {
    public static Boolean instrucaoStore(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*store\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);


        if(matcher.find()){

            Var variavel = new Var("cinza", 0);
            //PEGA O VALOR DA PRIMEIRA VARIÁVEL DA PILHA E ADICIONA NA NOVA VARIÁVEL
            variavel.setValor(pilha.getFirst().getValor());
            pilha.removeFirst();
            //ADICIONA A NOVA VARIÁVEL A LISTA QUE SIMULA A MEMÓRIA FÍSICA
            getMemoriaFisica().addFirst(variavel);
            /*ADICIONA A REFERÊNCIA DA NOVA VARIÁVEL AO SEU NOME CORRESPONDENTE
            * DENTRO DO ESCOPO ADEQUADO (HASHMAP DE ESCOPOS)*/
            if(getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey(matcher.group(1))){
                getEscopos().get(getFuncaoEmExecucao().getFirst()).put(matcher.group(1), variavel);
            }
//            else {
//                EstruturaObjeto prototipo;
//                if(getEscopos().get(getFuncaoEmExecucao().getFirst()).get("_prototype").getValor() instanceof EstruturaObjeto){
//                    prototipo = ((EstruturaObjeto) getEscopos().get(getFuncaoEmExecucao().getFirst()).get("_prototype").getValor());
//                    if(prototipo.getVariaveisDoObjeto().containsKey(matcher.group(1))){
//                        prototipo.getVariaveisDoObjeto().put(matcher.group(), variavel);
//                    }
//                }
//            }
            System.out.println(pilha);
            return true;
        }
        return false;
    }

    public static Boolean instrucaoStoreMetodo(String linhaCompilada, List<Var> pilha, DefinicaoMetodo metodoChamado){
        Pattern pattern = Pattern.compile("^\\s*store\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);


        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            Var variavel = new Var("cinza", 0);
            //PEGA O VALOR DA PRIMEIRA VARIÁVEL DA PILHA E ADICIONA NA NOVA VARIÁVEL
            variavel.setValor(pilha.getFirst().getValor());
            pilha.removeFirst();
            //ADICIONA A NOVA VARIÁVEL A LISTA QUE SIMULA A MEMÓRIA FÍSICA
            getMemoriaFisica().addFirst(variavel);
            /*ADICIONA A REFERÊNCIA DA NOVA VARIÁVEL AO SEU NOME CORRESPONDENTE
             * DENTRO DO ESCOPO ADEQUADO (HASHMAP DE ESCOPOS)*/
            if(getEscopos().get(getFuncaoEmExecucao().getFirst()).containsKey(nomeVariavel)){
                getEscopos().get(getFuncaoEmExecucao().getFirst()).put(nomeVariavel, variavel);
            } else {
                if(metodoChamado.getSelf().getVariaveisDoObjeto().containsKey(nomeVariavel)){
                    metodoChamado.getSelf().getVariaveisDoObjeto().put(nomeVariavel, variavel);
                }
            }
            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
