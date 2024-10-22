package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoLe    {
    public static Boolean InstrucaoLe(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*le\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
        }
        return false;
    }
}
