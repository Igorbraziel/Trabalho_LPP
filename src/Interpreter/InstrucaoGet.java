package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGet {
    public static Boolean InstrucaoGet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*get\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
