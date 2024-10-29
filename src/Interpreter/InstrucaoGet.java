package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoGet {
    public static Boolean instrucaoGet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*get\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            String nomeDaVariavel = matcher.group(1);
            Var variavelComObjeto = pilha.getFirst();
            pilha.removeFirst();
            if (variavelComObjeto.getValor() instanceof EstruturaObjeto) {
                EstruturaObjeto objetoHierarquia = (EstruturaObjeto) variavelComObjeto.getValor();
                int deuGet = 0;
                while(deuGet == 0) {
                    if (objetoHierarquia.getVariaveisDoObjeto().containsKey(nomeDaVariavel)) {
                        Var variavelGet = new Var("-", objetoHierarquia.getVariaveisDoObjeto().get(nomeDaVariavel).getValor());
                        pilha.addFirst(variavelGet);
                        deuGet = 1;
                    } else {
                        if(objetoHierarquia.getVariaveisDoObjeto().containsKey("_prototype")){
                            if(objetoHierarquia.getVariaveisDoObjeto().get("_prototype").getValor() instanceof EstruturaObjeto){
                                objetoHierarquia = (EstruturaObjeto) objetoHierarquia.getVariaveisDoObjeto().get("_prototype").getValor();
                            }
                        }
                    }
                }


//                Var variavelPilha = new Var<>("", ((EstruturaObjeto) variavelComObjeto.getValor()).getVariaveisDoObjeto().get(matcher.group(1)).getValor());
//                pilha.addFirst(variavelPilha);

                System.out.println(pilha);

                return true;
            }
        }
        return false;
    }
}
