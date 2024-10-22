package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoPop {
    public static Boolean InstrucaoPop(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*pop\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            pilha.removeFirst();
        }
        return false;
    }
}
