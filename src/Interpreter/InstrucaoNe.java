package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoNe {
    public static Boolean instrucaoNe(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*ne\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Integer> var1 = pilha.getFirst();
            pilha.removeFirst();
            Var<Integer> var2 = pilha.getFirst();
            pilha.removeFirst();

            if (!var1.getValor().equals(var2.getValor())){
                Var<Boolean> resultado = new Var<>("-", true);
            }else{
                Var<Boolean> resultado = new Var<>("-", false);
            }
            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
