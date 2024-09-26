package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturnResposta {

    public static String returnResposta(String linhaOriginal) {
        String linhaCompilada;
        String falha = "FALHA";

        Pattern pattern = Pattern.compile("^(\\s*)return\\s*([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "ret";
            return linhaCompilada;
        }
        return falha;
    }

}
