package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoCall {
    public static Boolean instrucaoCall(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*call\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
