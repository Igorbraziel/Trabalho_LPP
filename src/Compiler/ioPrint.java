package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ioPrint {

    public static String ioPrintLinha(String linhaOriginal){
        String falha = "FALHA";
        String linhaCompilada = falha;

        Pattern pattern = Pattern.compile("^(\\s*io\\.print\\(\\s*\\w+(\\s*,\\s*\\w+\\s*)*\\))$");
        Matcher matcher = pattern.matcher(linhaOriginal);

        if(matcher.find()){
            linhaCompilada = matcher.group(1);
        }
        return linhaCompilada;
    }
}

