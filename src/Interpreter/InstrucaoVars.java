package Interpreter;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoVars {

    public static List<Var> InstrucaoVars(String parametros){
        List<Var> listaVars = new LinkedList<Var>();
        String separatedParamether;
        Boolean achouMatch = true;
        Pattern pattern;
        Matcher matcher;

        while(achouMatch){
            /*SEPARA O NOME DE TODAS AS VARIAVEIS E A ADICIONA
             * À ESTRUTURA DA CLASSE EM listaVars*/
            pattern = Pattern.compile("([a-zA-Z]+)");
            matcher = pattern.matcher(parametros);
            matcher.find();
            separatedParamether = matcher.group(1);
            Var variavel = new Var("", 0);
            variavel.setNome(separatedParamether);
            listaVars.addFirst(variavel);

            pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
            matcher = pattern.matcher(parametros);
            achouMatch = matcher.find();
            if(achouMatch){
                parametros = matcher.group(1);
            }
        }

        return listaVars;
    }
}
