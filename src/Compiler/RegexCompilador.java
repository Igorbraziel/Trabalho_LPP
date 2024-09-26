package src.Compiler;

//import static java.util.Objects.equals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;


public class RegexCompilador {

    private final String falha = "FALHA";
    String linhaCompilada = falha;

    public RegexCompilador(){

    }


    public String mainRgex(String linhaOriginal){
        linhaCompilada = newInstrucao(linhaOriginal);
        if(linhaCompilada.equals(falha)){
            //System.out.println("entrou atribuicao");
            linhaCompilada = atribuicaoInstrucao(linhaOriginal);
            if(linhaCompilada.equals(falha)){
                //System.out.println("entrou call");
                linhaCompilada = callInstrucao(linhaOriginal);
                if(linhaCompilada.equals(falha)){

                    linhaCompilada = beginEnd(linhaOriginal);
                    if(linhaCompilada.equals(falha)){

                        linhaCompilada = returnResposta(linhaOriginal);
                        if(linhaCompilada.equals(falha)){

                            linhaCompilada = declaracaoClasse(linhaOriginal);
                            if(linhaCompilada.equals(falha)){

                                linhaCompilada = declaracaoMetodo(linhaOriginal);
                                if(linhaCompilada.equals(falha)){

                                    linhaCompilada = declaracaoVariavel(linhaOriginal);
                                    if(linhaCompilada.equals(falha)){

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }


        return linhaCompilada;
    }

    public String newInstrucao(String linhaOriginal){
        Pattern pattern = Pattern.compile("(\\s*)([a-zA-Z]+)\\s*=\\s*new\\s*([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = "\n" + matcher.group(1) + "new " + matcher.group(3) + "\n" + matcher.group(1) + "store " + matcher.group(2);
            return linhaCompilada;
        }
        return falha;
    }

    public String atribuicaoInstrucao(String linhaOriginal){ //a = b.bola
        Pattern pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([a-z-A-Z]+)\\.([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "get " + matcher.group(4) + "\n" + matcher.group(1) + "store " + matcher.group(2);

        } else { //a = b
            pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)");
            matcher = pattern.matcher(linhaOriginal);
            if(matcher.find()){
                linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(3) + "\n" + matcher.group(1) + "store " + matcher.group(2);
            } else { //a = 10
                pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\s*=\\s*([0-9]+)");
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
                        pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\s*=\\s*([0-9]+)");
                        matcher = pattern.matcher(linhaOriginal);
                        if (matcher.find()) {
                            linhaCompilada = "\n" + matcher.group(1) + "const " + matcher.group(4) + "\n" + matcher.group(1) + "load " + matcher.group(2);
                            linhaCompilada = linhaCompilada + "\n" + matcher.group(1) + "set " + matcher.group(3);
                        } else { //a.arauto = b.bola
                            pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\s*=\\s*([a-zA-Z]+)\\.([a-zA-Z]+)");
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


    public String callInstrucao(String linhaOriginal){
        String linhaAuxiliar, parametros, separatedParamether, espacamento;
        int i;
        ArrayList<String> allPar = new ArrayList<String>();
        Boolean resultadoMatcher;
        Pattern pattern = Pattern.compile("^(\\s*)([a-zA-Z]+)\\.([a-zA-Z]+)\\(([\\s,a-zA-Z]+)\\)\\s*");
        Matcher matcher = pattern.matcher(linhaOriginal);
        resultadoMatcher = matcher.find();



        if(resultadoMatcher){
            espacamento = matcher.group(1);
            linhaAuxiliar = "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "call " + matcher.group(3);
            parametros = matcher.group(4);

            while(resultadoMatcher){

                pattern = Pattern.compile("([a-zA-Z]+)");
                matcher = pattern.matcher(parametros);
                matcher.find();

                separatedParamether = matcher.group(1);

                allPar.add(separatedParamether);

                pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                matcher = pattern.matcher(parametros);
                resultadoMatcher = matcher.find();
                if(resultadoMatcher){
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


    public String comparacoesInstrucoes(String linhaOriginal, String espacamento){
        String linhaAux;
        Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s*>=\\s*([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "ge";
            return linhaAux;
        } else {
            pattern = Pattern.compile("([a-zA-Z]+)\\s*>\\s*([a-zA-Z]+)");
            matcher = pattern.matcher(linhaOriginal);
            if(matcher.find()){
                linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "gt";
                return linhaAux;
            } else {
                pattern = Pattern.compile("([a-zA-Z]+)\\s*<=\\s*([a-zA-Z]+)");
                matcher = pattern.matcher(linhaOriginal);
                if(matcher.find()){
                    linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "le";
                    return linhaAux;
                } else {
                    pattern = Pattern.compile("([a-zA-Z]+)\\s*<\\s*([a-zA-Z]+)");
                    matcher = pattern.matcher(linhaOriginal);
                    if(matcher.find()){
                        linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "lt";
                        return linhaAux;
                    } else {
                        pattern = Pattern.compile("([a-zA-Z]+)\\s*==\\s*([a-zA-Z]+)");
                        matcher = pattern.matcher(linhaOriginal);
                        if(matcher.find()){
                            linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "eq";
                            return linhaAux;
                        } else {
                            pattern = Pattern.compile("([a-zA-Z]+)\\s*!=\\s*([a-zA-Z]+)");
                            matcher = pattern.matcher(linhaOriginal);
                            if(matcher.find()){
                                linhaAux = "\n" + espacamento + matcher.group(1) + "\n" + espacamento + matcher.group(2) + "\n" + espacamento + "ne";
                                return linhaAux;
                            }
                        }
                    }
                }
            }
        }
        return falha;
    }

    public String ifInstrucao(String linhaOriginal){
        int countLinhas;

        Pattern pattern = Pattern.compile("(\\s*)if\\s*([a-zA-Z\\.]+\\s*[a-zA-Z\\.]+)\\s+then");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if(matcher.find()){
            linhaCompilada = comparacoesInstrucoes(matcher.group(2), matcher.group(1));


        }

        return linhaCompilada;
    }

    public String variavelOuAtributo(String nomeOriginal){
        String nomeCompilado = "";
        Pattern pattern = Pattern.compile("^\\s*([a-zA-Z]+)\\.([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(nomeOriginal);
        if(matcher.find()){
            nomeCompilado = "\nload " + matcher.group(1) + "\nget " + matcher.group(2);
            return nomeCompilado;
        }
        return falha;
    }

    public String declaracaoMetodo(String linhaOriginal) {
        Pattern pattern = Pattern.compile("^(\\s*)method\\s*([a-zA-Z]+)[(]\\s*[)]\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "method " + matcher.group(2) + "()";
            return linhaCompilada;
        }
        return falha;
    }

    public String declaracaoVariavel(String linhaOriginal) {
        Pattern pattern = Pattern.compile("^(\\s*)vars\\s*([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "vars " + matcher.group(2) ;
            return linhaCompilada;
        }
        return falha;
    }

    public String declaracaoClasse(String linhaOriginal) {
        Pattern pattern = Pattern.compile("^(\\s*)class\\s*([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "class " + matcher.group(2);
            return linhaCompilada;
        }
        return falha;
    }

    public String beginEnd(String linhaOriginal) {
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

    public String returnResposta(String linhaOriginal) {
        Pattern pattern = Pattern.compile("^(\\s*)return\\s*([a-zA-Z]+)\\s*$");
        Matcher matcher = pattern.matcher(linhaOriginal);
        if (matcher.find()) {
            linhaCompilada = "\n" + matcher.group(1) + "load " + matcher.group(2) + "\n" + matcher.group(1) + "ret";
            return linhaCompilada;
        }
        return falha;
    }
}
