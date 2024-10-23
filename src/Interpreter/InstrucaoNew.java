package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoNew {
    public static Boolean instrucaoNew(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*new\\s+([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            System.out.println("Instrucao NEW");

            addObjeto(getClasseEspecifica(matcher.group(1)));
            return true;
        }
        return false;
    }
}
