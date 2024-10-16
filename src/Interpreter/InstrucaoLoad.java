package Interpreter;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoLoad {
    public static Boolean instrucaoStore(String linhaCompilada, Stack<Object> pilha){
        Pattern pattern = Pattern.compile("^\\s*load\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){

            return true;
        }
        return false;
    }
}
