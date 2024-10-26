package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoMain {
    public static Boolean instrucaoMain(String linhaCompilada){
        Pattern pattern = Pattern.compile("^\\s*main\\s*[(][)]\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            getFuncaoEmExecucao().addFirst("main");
            return true;
        }
        return false;
    }
}
