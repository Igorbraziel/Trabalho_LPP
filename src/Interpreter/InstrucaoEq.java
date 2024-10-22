package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoEq {
    public static Boolean InstrucaoEq(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*eq\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
