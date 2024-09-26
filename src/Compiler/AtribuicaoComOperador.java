package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtribuicaoComOperador {

    public static String atribuicao(String linhaOriginal){
        String falha = "FALHA";
        String linhaCompilada = falha;

        Pattern pattern = Pattern.compile("^(\\s*)(\\w+)\\s+=\\s+(\\w+)\\s+(\\+)\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){ // c = a + b
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                    + "\n" + matcher.group(1) + "add" + "\n" + matcher.group(1) + "store " + matcher.group(2);
        } else { // c = a - b
            pattern = Pattern.compile("^(\\s*)(\\w+)\\s+=\\s+(\\w+)\\s+(-)\\s+(\\w+)\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            if(matcher.find()){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                        + "\n" + matcher.group(1) + "sub" + "\n" + matcher.group(1) + "store " + matcher.group(2);
            }
        }


        return linhaCompilada;
    }

}
