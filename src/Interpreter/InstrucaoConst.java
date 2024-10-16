package Interpreter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Stack;

public class InstrucaoConst {
    public static Boolean instrucaoConst(String linhaCompilada, Stack<Object> pilha){
        Pattern pattern = Pattern.compile("^\\s*const\\s+(-?\\d+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            int number = Integer.parseInt(matcher.group(1));
            pilha.push(number);
            return true;
        }
        return false;
    }
}
