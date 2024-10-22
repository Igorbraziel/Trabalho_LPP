package Interpreter;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InstrucaoConst {
    public static Boolean instrucaoConst(String linhaCompilada, List<Var> pilha) {
        Pattern pattern = Pattern.compile("^\\s*const\\s+(-?\\d+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            pilha.push(new Pilha("-", number));
            return true;
        }
        return false;
    }
}
