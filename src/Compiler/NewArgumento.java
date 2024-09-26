package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewArgumento {

    public static String newArg(String linhaOriginal){
        String linhaCompilada;
        String falha = "FALHA";

        Pattern pattern = Pattern.compile("(\\s*)([a-zA-Z]+)\\s*=\\s*new\\s*([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = "\n" + matcher.group(1) + "new " + matcher.group(3) + "\n" + matcher.group(1) + "store " + matcher.group(2);
            return linhaCompilada;
        }
        return falha;
    }
}

