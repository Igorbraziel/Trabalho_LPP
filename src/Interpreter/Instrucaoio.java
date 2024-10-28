package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import Interpreter.ListasObjetos;

public class Instrucaoio {
    public static Boolean instrucaoio(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*io\\.print\\((\\w+)\\)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            HashMap<String, HashMap<String, Var>> escopos = ListasObjetos.getEscopos();
            // PRECISA ACHAR O ESCOPO QUE A VARIAVEL SE ENCONTRA PARA ENCONTRA-LA, DEPOIS IMPRIMI-LA
            

            return true;
        }
        return false;
    }
}
