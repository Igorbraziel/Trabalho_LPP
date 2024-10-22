package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoSub {
    public static Boolean InstrucaoSub(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*sub\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var1 = pilha.getFirst();
            Var<Integer> var2 = pilha.get(1);

            int sub = var1.getValor() - var2.getValor();

            Var<Integer> resultado = new Var<>("-", sub);
            pilha.add(resultado);
            return true;
        }
        return false;
    }
}
