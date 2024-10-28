package Interpreter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstrucaoSet {
    public static Boolean instrucaoSet(String linhaCompilada, List<Var> pilha){
        Pattern pattern = Pattern.compile("^\\s*set\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);


        if(matcher.find()){
            String nomeDaVariavel = matcher.group(1);
            Var variavelComObjeto = pilha.getFirst();
            pilha.removeFirst();
            if (variavelComObjeto.getValor() instanceof EstruturaObjeto) {
                Var variavelPraSet = new Var<>("", pilha.getFirst().getValor());
                pilha.removeFirst();

                EstruturaObjeto objetoHierarquia = (EstruturaObjeto) variavelComObjeto.getValor();
                int setou = 0;
                while (setou == 0) {

                    if (objetoHierarquia.getVariaveisDoObjeto().containsKey(nomeDaVariavel)) {
                        objetoHierarquia.getVariaveisDoObjeto().put(nomeDaVariavel, variavelPraSet);
                        setou = 1;
//                        System.out.println("Não setou?");

                    } else {
//                        System.out.println("Entoru else " + objetoHierarquia.getVariaveisDoObjeto());

                        if(objetoHierarquia.getVariaveisDoObjeto().containsKey("_prototype")){
//                            System.out.println("Não achou a prototype");

                            if(objetoHierarquia.getVariaveisDoObjeto().get("_prototype").getValor() instanceof EstruturaObjeto){
                                objetoHierarquia = (EstruturaObjeto) objetoHierarquia.getVariaveisDoObjeto().get("_prototype").getValor();
                                System.out.println("próximo prototype");
                            }
                        }

                    }
                }



                System.out.println(pilha);
                return true;
            }
        }
        return false;
    }

}
