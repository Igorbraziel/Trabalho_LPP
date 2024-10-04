package Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NomeVar {

    public static String variavelOuAtributo(String nomeOriginal){
        String falha = "FALHA";
        String nomeCompilado = "";

        Pattern pattern = Pattern.compile("^\\s*([a-zA-Z]+)\\.([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(nomeOriginal);
        if(matcher.find()){
            nomeCompilado = "\nload " + matcher.group(1) + "\nget " + matcher.group(2);
            return nomeCompilado;
        }
        return falha;
    }

}
