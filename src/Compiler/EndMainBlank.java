package Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EndMainBlank {

    public static String endMainBlank(String linhaOriginal) {
        String falha = "FALHA";
        String linhaCompilada;

        Pattern pattern = Pattern.compile("^\\s*main\\s*\\(\\s*\\)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\nmain()";
            return linhaCompilada;
        } else {
            pattern = Pattern.compile("^\\s*end\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            if (matcher.find()) {
                linhaCompilada = "\nend";
                return linhaCompilada;
            } else {
                pattern = Pattern.compile("^\\s*$");
                matcher = pattern.matcher(linhaOriginal);
                if (matcher.find()) {
                    linhaCompilada = "\n";
                    return linhaCompilada;
                }
            }
        }
        return falha;
    }

}
