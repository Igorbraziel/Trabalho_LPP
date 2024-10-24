package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoSet {
    public static Boolean instrucaoSet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*set\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var variavelComObjeto = pilha.getFirst();
            pilha.removeFirst();
            if (variavelComObjeto.getValor() instanceof EstruturaObjeto) {
                Var variavelPilha = new Var<>("", pilha.getFirst().getValor());
                pilha.removeFirst();
                ((EstruturaObjeto) variavelComObjeto.getValor()).getVariaveisDoObjeto().put(matcher.group(1), variavelPilha);

                System.out.println(pilha);
                return true;
            }
        }
        return false;
    }

}
