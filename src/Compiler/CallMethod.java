package src.Compiler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallMethod {

    public static String callMethod(String linhaOriginal){
        String linhaCompilada;
        String falha = "FALHA";

        String linhaAuxiliar = "", parametros = "", separatedParamether, espacamento = "";
        int i;
        ArrayList<String> allPar = new ArrayList<String>();
        Boolean resultadoPop = false;
        Pattern pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\(([\\s,a-zA-Z]*)\\)\\s*");
        Matcher matcher = pattern.matcher(linhaOriginal);
        resultadoPop = matcher.find();



        if(resultadoPop){
            espacamento = matcher.group(1);
            linhaAuxiliar = "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "call " + matcher.group(3) + "\n" + matcher.group(1) + "pop";
            parametros = matcher.group(4);


        } else {
            pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)\\.([a-zA-Z]+)\\(([\\s,a-zA-Z]+)\\)\\s*$");
            matcher = pattern.matcher(linhaOriginal);
            resultadoPop = matcher.find();

            if(resultadoPop){
                espacamento = matcher.group(1);
                linhaAuxiliar = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "call " + matcher.group(4) + "\n" + matcher.group(1) + "store " + matcher.group(2);
                parametros = matcher.group(5);
            }
        }

        if(resultadoPop){
            while(resultadoPop){

                pattern = Pattern.compile("([a-zA-Z]+)");
                matcher = pattern.matcher(parametros);
                matcher.find();

                separatedParamether = matcher.group(1);

                allPar.add(separatedParamether);

                pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                matcher = pattern.matcher(parametros);
                resultadoPop = matcher.find();
                if(resultadoPop){
                    parametros = matcher.group(1);
                }
            }
            linhaCompilada = "";
            for(i = 0; i < allPar.size(); i++){
                linhaCompilada = linhaCompilada + "\n" + espacamento + "load " + allPar.get(i);
            }

            linhaCompilada = linhaCompilada + linhaAuxiliar;
            return linhaCompilada;
        }



        return falha;
    }

}
