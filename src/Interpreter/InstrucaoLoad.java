package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoLoad {
    public static Boolean instrucaoStore(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*load\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            String nomeVariavel = matcher.group(1);

            for (Var var : pilha) {
                if (var.getNome().equals(nomeVariavel)) {
                    pilha.remove(var);
                    pilha.addFirst(var);
                    return true;
                }
            }
        }
        return false;
    }
}
