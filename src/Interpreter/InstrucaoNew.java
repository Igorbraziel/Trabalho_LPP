package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;
import static Interpreter.InstrucaoVars.instrucaoVarsObjetos;


public class InstrucaoNew {
    public static Boolean instrucaoNew(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*new\\s+([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){

            EstruturaObjeto objetoInstanciado = new EstruturaObjeto();
            objetoInstanciado.setMetodos(getListaEstruturaClasses().get(matcher.group(1)).getMetodos());
            objetoInstanciado.setClassName(getListaEstruturaClasses().get(matcher.group(1)).getClassName());
            objetoInstanciado.setVariaveisDaClasse(getListaEstruturaClasses().get(matcher.group(1)).getVariaveisDaClasse());
            objetoInstanciado.setVariaveisDoObjeto(instrucaoVarsObjetos(objetoInstanciado.getVariaveisDaClasse()));
            Var prototype = new Var<>("", 0);
            objetoInstanciado.getVariaveisDoObjeto().put("_prototype", prototype);

            Var variavel = new Var("", objetoInstanciado);
            pilha.addFirst(variavel);

            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
