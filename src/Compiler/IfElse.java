package src.Compiler;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfElse {

    public static String ifElse(String linhaOriginal, BufferedReader bf){
        String falha = "FALHA";
        String linhaCompilada = falha;
        String linhaAux = "";
        String linhaLeitura = "";
        String linhaElse = "";
        String espacamentoIfElse = "";
        int countLinhas = 0;
        Boolean fimDoIf = false, entrouNoElse = false;

        Pattern pattern = Pattern.compile("(\\s*)if\\s*([a-zA-Z]+)\\s*([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+then\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "load " + matcher.group(4);
            linhaCompilada = linhaCompilada + "\n" + matcher.group(1) + matcher.group(3) + "\n" + matcher.group(1);
            espacamentoIfElse = matcher.group(1);

            RegexCompilador regex = new RegexCompilador();

            while(!fimDoIf){
                try {
                    linhaLeitura = bf.readLine();
                }catch(Exception c){
                    System.out.println("ERRO na leitura do arquivo dentro do if");
                }
                pattern = Pattern.compile("^(\\s*)end-if\\s*$");
                matcher = pattern.matcher(linhaLeitura);
                if(matcher.find()){
                    fimDoIf = true;
                    linhaElse = linhaElse + "\n" + matcher.group(1) + "end-if";
                } else {
                    if(!entrouNoElse) {
                        pattern = Pattern.compile("^(\\s*)else\\s*$");
                        matcher = pattern.matcher(linhaLeitura);
                        if (matcher.find()) {
                            entrouNoElse = true;

                        } else {
                            linhaAux = linhaAux + regex.mainRgex(linhaLeitura, bf);
                        }
                    } else {
                        linhaElse = linhaElse + regex.mainRgex(linhaLeitura, bf);
                    }

                }

            }

            countLinhas = linhaElse.length() - linhaElse.replace("\n", "").length() - 1;
            if(countLinhas > 0){
                linhaElse = "\n" + espacamentoIfElse + "else " + countLinhas + linhaElse;
            }

            countLinhas = linhaAux.length() - linhaAux.replace("\n", "").length();
            linhaCompilada = linhaCompilada + "if " + countLinhas;
            linhaCompilada = linhaCompilada + linhaAux + linhaElse;

            return linhaCompilada;
        }

        return falha;
    }

}
