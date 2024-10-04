package Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeclaracaoMetodo {
    public static String declaracaoMetodo(String linhaOriginal) {
        String falha = "FALHA";
        String linhaCompilada;

        Pattern pattern = Pattern.compile("^(\\s*)method\\s*([a-zA-Z]+)[(]\\s*[)]\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "method " + matcher.group(2) + "()";
            return linhaCompilada;
        }
        return falha;
    }
}
