package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Retira o valor do topo da pilha e armazena na variável ou parâmetro “name”.
public class InstrucaoStore {
    public static Boolean instrucaoStore(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*store\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            Var valor = pilha.getFirst();
            pilha.removeFirst();
            pilha.addFirst(new Var(matcher.group(1), valor.getValor()));
            System.out.println(pilha);
            return true;
        }
        return false;
    }
}
