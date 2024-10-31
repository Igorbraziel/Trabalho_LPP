package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoSub {
    public static Boolean instrucaoSub(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*sub\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var2 = pilha.getFirst();
            pilha.removeFirst();
            Var<Integer> var1 = pilha.getFirst();
            pilha.removeFirst();

            int soma = var1.getValor() - var2.getValor();

            Var<Integer> resultado = new Var<>("-", soma);
            pilha.addFirst(resultado);
            return true;
        }
        return false;
    }
}
