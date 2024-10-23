package Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// DEVEMOS PASSAR O BUFFERED READER DO PROGRAMA PRINCIPAL PARA IGNORAR AS PROXIMAS LINHAS CASO NÃO ENTRE NO IF
// OLHAR SE A LÓGICA ESTÁ FUNCIONANDO

public class InstrucaoIf {
    public static Boolean InstrucaoIf(String linhaCompilada, List<Var> pilha, BufferedReader br) throws IOException {
        Pattern pattern = Pattern.compile("^(\\s*)if\\s*(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Boolean> retornoDoIf = pilha.getFirst();
            pilha.removeFirst();

            int numeroInstrucoes = Integer.parseInt(matcher.group(2));

            if (!retornoDoIf.getValor()){
                for(int i = 0; i < numeroInstrucoes; i++){
                    br.readLine();
                }
            }
            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
