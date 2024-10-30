package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGt {
    public static Boolean instrucaoGt(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*gt\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var1 = pilha.getFirst();
            pilha.removeFirst();
            Var<Integer> var2 = pilha.getFirst();
            pilha.removeFirst();

            if (var1.getValor() < var2.getValor()){
                Var<Boolean> resultado = new Var<>("-", true);
                pilha.addFirst(resultado);
            }else{
                Var<Boolean> resultado = new Var<>("-", false);
                pilha.addFirst(resultado);
            }

            return true;
        }
        return false;
    }
}
