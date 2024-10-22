package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoSet {
    public static Boolean InstrucaoSet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*set\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }

}
