package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGe {
    public static Boolean InstrucaoGe(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*ge\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
