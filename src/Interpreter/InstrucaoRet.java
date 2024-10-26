package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Interpreter.ListasObjetos.*;

public class InstrucaoRet {
    public static Boolean instrucaoRet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*ret\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            getEscopos().remove(getFuncaoEmExecucao().getFirst());
            getFuncaoEmExecucao().removeFirst();
        }
        return false;
    }
}
