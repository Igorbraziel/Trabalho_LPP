package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGt {
    public static Boolean InstrucaoGt(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*gt\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
