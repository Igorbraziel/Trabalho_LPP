package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoMul {
    public static Boolean InstrucaoMul(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*mul\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var1 = pilha.getFirst();
            pilha.removeFirst();
            Var<Integer> var2 = pilha.getFirst();
            pilha.removeFirst();

            int mul = var1.getValor() * var2.getValor();

            Var<Integer> resultado = new Var<>("-", mul);
            pilha.add(resultado);
            return true;
        }
        return false;
    }
}
