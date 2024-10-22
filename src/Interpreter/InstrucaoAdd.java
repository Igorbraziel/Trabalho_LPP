package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoAdd {
    public static Boolean InstrucaoAdd(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*add\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var1 = pilha.getFirst();
            pilha.removeFirst();
            Var<Integer> var2 = pilha.getFirst();
            pilha.removeFirst();

            int soma = var1.getValor() + var2.getValor();

            Var<Integer> resultado = new Var<>("-", soma);
            pilha.add(resultado);
            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
