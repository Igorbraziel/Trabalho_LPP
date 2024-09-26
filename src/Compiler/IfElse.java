package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfElse {

    public static String ifElse(String linhaOriginal){
        String falha = "FALHA";
        String linhaCompilada = falha;
        int countLinhas;

        Pattern pattern = Pattern.compile("(\\s*)if\\s*([a-zA-Z\\.]+\\s*[a-zA-Z\\.]+)\\s+then");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){


        }

        return linhaCompilada;
    }

}
