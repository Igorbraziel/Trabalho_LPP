package Interpreter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoVars {

    public static Boolean instrucaoVars(String linhaCompilada){
        List<Var> listaVars = new LinkedList<Var>();
        HashMap<String, Var> referenciaVariaveis = new HashMap<>();
        String separatedParamether, parametros;
        Boolean achouMatch = true;
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
        matcher = pattern.matcher(linhaCompilada);
        achouMatch = matcher.find();
        if (achouMatch) {
            parametros = matcher.group(1);
            while(achouMatch){
                /*SEPARA O NOME DE TODAS AS VARIAVEIS E A ADICIONA
                 * À ESTRUTURA DA CLASSE EM listaVars*/
                pattern = Pattern.compile("([a-zA-Z]+)");
                matcher = pattern.matcher(parametros);
                matcher.find();
                separatedParamether = matcher.group(1);
                Var variavel = new Var("", 0);
                variavel.setCor(getCorDaVez());
                //listaVars.addFirst(variavel);
                getMemoriaFisica().addFirst(variavel);
                referenciaVariaveis.put(separatedParamether, variavel);

                pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                matcher = pattern.matcher(parametros);
                achouMatch = matcher.find();
                if(achouMatch){
                    parametros = matcher.group(1);
                }
            }

            //CRIA UM NOVO ESCOPO DE VARIAVEIS COM AS VARIAVEIS DECLARADAS
            getEscopos().put(getFuncaoEmExecucao().getFirst(), referenciaVariaveis);
            return true;
        }
        return false;
    }


    public static HashMap<String, Var> instrucaoVarsObjetos(String linhaCompilada){
        List<Var> listaVars = new LinkedList<Var>();
        HashMap<String, Var> referenciaVariaveis = new HashMap<>();
        String separatedParamether, parametros;
        Boolean achouMatch = true;
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
        matcher = pattern.matcher(linhaCompilada);
        achouMatch = matcher.find();
        if (achouMatch) {
            parametros = matcher.group(1);
            while(achouMatch){
                /*SEPARA O NOME DE TODAS AS VARIAVEIS E A ADICIONA
                 * À ESTRUTURA DA CLASSE EM listaVars*/
                pattern = Pattern.compile("([a-zA-Z]+)");
                matcher = pattern.matcher(parametros);
                matcher.find();
                separatedParamether = matcher.group(1);
                Var variavel = new Var("", 0);
                //variavel.setCor(getCorDaVez());
                //listaVars.addFirst(variavel);
                getMemoriaFisica().addFirst(variavel);
                referenciaVariaveis.put(separatedParamether, variavel);

                pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                matcher = pattern.matcher(parametros);
                achouMatch = matcher.find();
                if(achouMatch){
                    parametros = matcher.group(1);
                }
            }

            //CRIA UM NOVO ESCOPO DE VARIAVEIS COM AS VARIAVEIS DECLARADAS
            //getEscopos().put("", referenciaVariaveis);
            //return true;
        }
        return referenciaVariaveis;
    }
}
