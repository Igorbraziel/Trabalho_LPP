package Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.Intermediadora.Intermediadora;

// DEVEMOS PASSAR O BUFFERED READER DO PROGRAMA PRINCIPAL PARA IGNORAR AS PROXIMAS LINHAS CASO NÃO ENTRE NO IF
// OLHAR SE A LÓGICA ESTÁ FUNCIONANDO


public class InstrucaoIfElse {
    public static Boolean instrucaoIfElse(String linhaCompilada, List<Var> pilha, BufferedReader br) throws IOException {
        Pattern pattern = Pattern.compile("^(\\s*)if\\s*(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var<Boolean> retornoDoIf = pilha.getFirst();
            pilha.removeFirst();

            int numeroInstrucoes = Integer.parseInt(matcher.group(2));

            if (!retornoDoIf.getValor()){ // NAO VAI ENTRAR NO IF, TEMOS QUE IGNORAS AS LINHAS
                for(int i = 0; i < numeroInstrucoes; i++){
                    br.readLine(); // IGNORA AS LINHAS DO IF
                }
                String novaLinha = br.readLine(); // LE A PROXIMA LINHA APOS IF
                pattern = Pattern.compile("^(\\s*)else\\s*(\\w+)\\s*$");
                matcher = pattern.matcher(novaLinha);
                if(matcher.find()){ // O IF TEM ELSE
                    numeroInstrucoes = Integer.parseInt(matcher.group(2)); // NUMERO DE INTRUÇOES DO ELSE
                    for(int i = 0; i < numeroInstrucoes; i++){
                        Intermediadora(br.readLine(), pilha, br); // EXECUTA AS INSTRUÇOES DO ELSE
                    }
                } else { // O IF NAO TEM ELSE
                    Intermediadora(novaLinha, pilha, br); // CHAMA A INTERMEDIADORA COM A LINHA LIDA (NÃO ERA UM ELSE)
                }
            } else { // VAI ENTRAR NO IF
                for(int i = 0; i < numeroInstrucoes; i++){
                    Intermediadora(br.readLine(), pilha, br); // EXECUTA AS INTRUÇÕES DO IF
                }
                String novaLinha = br.readLine(); // LE A PROXIMA LINHA APOS IF
                pattern = Pattern.compile("^(\\s*)else\\s*(\\w+)\\s*$");
                matcher = pattern.matcher(novaLinha);
                if(matcher.find()){ // O IF TEM ELSE
                    numeroInstrucoes = Integer.parseInt(matcher.group(2)); // NUMERO DE INTRUÇOES DO ELSE
                    for(int i = 0; i < numeroInstrucoes; i++){
                        br.readLine(); // IGNORA AS INTRUCOES DO ELSE
                    }
                } else { // O IF NAO TEM ELSE
                    Intermediadora(novaLinha, pilha, br); // CHAMA A INTERMEDIADORA COM A LINHA LIDA (NÃO ERA UM ELSE)
                }
            }

            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
