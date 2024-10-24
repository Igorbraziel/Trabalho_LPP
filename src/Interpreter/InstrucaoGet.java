package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGet {
    public static Boolean instrucaoGet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*get\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var variavelComObjeto = pilha.getFirst();
            pilha.removeFirst();
            if (variavelComObjeto.getValor() instanceof EstruturaObjeto) {
                Var variavelPilha = new Var<>("", ((EstruturaObjeto) variavelComObjeto.getValor()).getVariaveisDoObjeto().get(matcher.group(1)).getValor());
                pilha.addFirst(variavelPilha);

                System.out.println(pilha);

                return true;
            }
        }
        return false;
    }
}
