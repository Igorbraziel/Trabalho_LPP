package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoAdd {
    public static Boolean InstrucaoAdd(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*add\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var var1 = pilha.removeLast();
            Var var2 = pilha.removeLast();

            Var resultado = new Var("-", var1.getValor() + var2.getValor());
            pilha.add(resultado);
            return true;
        }
        return false;
    }
}
