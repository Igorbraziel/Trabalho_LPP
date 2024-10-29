package Compiler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtribuicaoComOperador {

    public static String atribuicaoComOperador(String linhaOriginal){
        String falha = "FALHA";
        String linhaCompilada = falha;

        Pattern pattern = Pattern.compile("^(\\s*)(\\w+)\\s+=\\s+(\\w+)\\s+([+\\-*/])\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){ // c = a + b // acha qualquer operador + - * /
            if(matcher.group(4).equals("+")) { // c = a + b
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                        + "\n" + matcher.group(1) + "add" + "\n" + matcher.group(1) + "store " + matcher.group(2);
            } else if (matcher.group(4).equals("-")){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                        + "\n" + matcher.group(1) + "sub" + "\n" + matcher.group(1) + "store " + matcher.group(2);
            } else if(matcher.group(4).equals("*")){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                        + "\n" + matcher.group(1) + "mul" + "\n" + matcher.group(1) + "store " + matcher.group(2);
            } else if(matcher.group(4).equals("/")){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "load " + matcher.group(5)
                        + "\n" + matcher.group(1) + "div" + "\n" + matcher.group(1) + "store " + matcher.group(2);
            }
        } else { // name.name = a + b //atribuição com operador a um name.name
            pattern = Pattern.compile("^(\\s*)(\\w+)\\.([_\\w]+)\\s+=\\s+(\\w+)\\s+([+\\-*/])\\s+(\\w+)\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            if(matcher.find()){
                if(matcher.group(5).equals("+")) { //NÃO SEI SE ESTÁ CERTO
                    linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n"
                            + matcher.group(1) + "load " + matcher.group(6) + "\n"
                            + matcher.group(1) + "add" + "\n"
                            + matcher.group(1) + "load " + matcher.group(2) + "\n"
                            + matcher.group(1) + "set " + matcher.group(3);
                } else if(matcher.group(5).equals("-")){ //NÃO SEI SE ESTÁ CERTO
                    linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n"
                            + matcher.group(1) + "load " + matcher.group(6) + "\n"
                            + matcher.group(1) + "sub" + "\n"
                            + matcher.group(1) + "load " + matcher.group(2) + "\n"
                            + matcher.group(1) + "set " + matcher.group(3);
                } else if(matcher.group(5).equals("*")){ //NÃO SEI SE ESTÁ CERTO
                    linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n"
                            + matcher.group(1) + "load " + matcher.group(6) + "\n"
                            + matcher.group(1) + "mul" + "\n"
                            + matcher.group(1) + "load " + matcher.group(2) + "\n"
                            + matcher.group(1) + "set " + matcher.group(3);
                } else if(matcher.group(5).equals("/")){ //NÃO SEI SE ESTÁ CERTO
                    linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(4) + "\n"
                            + matcher.group(1) + "load " + matcher.group(6) + "\n"
                            + matcher.group(1) + "div" + "\n"
                            + matcher.group(1) + "load " + matcher.group(2) + "\n"
                            + matcher.group(1) + "set " + matcher.group(3);
                }
            }
        }

        return linhaCompilada;
    }

}
