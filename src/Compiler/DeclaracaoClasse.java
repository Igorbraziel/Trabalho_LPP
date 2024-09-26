package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeclaracaoClasse {

    public static String declaracaoClasse(String linhaOriginal) {
        String falha = "FALHA";
        String linhaCompilada;

        Pattern pattern = Pattern.compile("^(\\s*)class\\s*([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "class " + matcher.group(2);
            return linhaCompilada;
        }
        return falha;
    }

}
