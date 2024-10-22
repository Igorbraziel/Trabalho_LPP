package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoNe {
    public static Boolean InstrucaoNe(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*ne\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
