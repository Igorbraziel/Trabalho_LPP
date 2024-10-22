package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoLt {
    public static Boolean InstrucaoLt(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*lt\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
