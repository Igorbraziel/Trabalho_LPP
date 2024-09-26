package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeginEnd {

    public static String beginEnd(String linhaOriginal) {
        String linhaCompilada;
        String falha = "FALHA";

        Pattern pattern = Pattern.compile("^(\\s*)begin\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "begin";
            return linhaCompilada;
        } else {
            pattern = Pattern.compile("^(\\s*)end-([a-zA-Z]+)\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            if (matcher.find()) {
                linhaCompilada = "\n" + matcher.group(1) + "end-" + matcher.group(2);
                return linhaCompilada;
            }
        }
        return falha;
    }

}
