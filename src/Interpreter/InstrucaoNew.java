package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoNew {
    public static Boolean instrucaoNew(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*new\\s+([A-Z][a-zA-Z]*)\\s*$\n");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
