package Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeclaracaoVars {

    public static String declaracaoVars(String linhaOriginal) {
        String falha = "FALHA";
        String linhaCompilada;
        Pattern pattern = Pattern.compile("^(\\s*)vars\\s*([a-zA-Z,\\s]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "vars " + matcher.group(2) ;
            return linhaCompilada;
        }
        return falha;
    }

}
