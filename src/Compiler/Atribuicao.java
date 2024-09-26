package src.Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atribuicao {

    public static String atribuicao(String linhaOriginal){ //a = b.bola
        String falha = "FALHA";
        String linhaCompilada = falha;

        Pattern pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([a-z-A-Z]+)\\.([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "get " + matcher.group(4) + "\n" + matcher.group(1) + "store " + matcher.group(2);

        } else { //a = b
            pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            if(matcher.find()){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "store " + matcher.group(2);
            } else { //a = 10
                pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([0-9]+)\\s*$");
                matcher = pattern.matcher(linhaOriginal);
                if(matcher.find()){
                    linhaCompilada = "\n" + matcher.group(1) + "const " + matcher.group(3) + "\n" + matcher.group(1) + "store " + matcher.group(2);
                } else { //a.arauto = b
                    pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)\\s*$");
                    matcher = pattern.matcher(linhaOriginal);
                    if(matcher.find()){
                        linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n" + matcher.group(1) + "load " + matcher.group(2);
                        linhaCompilada = linhaCompilada + "\n" + matcher.group(1) + "set " + matcher.group(3);
                    } else { // a.arauto = 10
                        pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\s*=\\s*([0-9]+)\\s*$");
                        matcher = pattern.matcher(linhaOriginal);
                        if (matcher.find()) {
                            linhaCompilada = "\n" + matcher.group(1) + "const " + matcher.group(4) + "\n" + matcher.group(1) + "load " + matcher.group(2);
                            linhaCompilada = linhaCompilada + "\n" + matcher.group(1) + "set " + matcher.group(3);
                        } else { //a.arauto = b.bola
                            pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)\\.([a-zA-Z]+)\\s*$");
                            matcher = pattern.matcher(linhaOriginal);
                            if (matcher.find()) {
                                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n" + matcher.group(1) + "get " + matcher.group(5);
                                linhaCompilada = linhaCompilada + "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "set " + matcher.group(3);
                            }
// FALTAM AS OPERAÇÕES ARITIMÉTICAS
                            //
                            //
                            //
                        }
                    }
                }
            }

        }
        return linhaCompilada;
    }

}
