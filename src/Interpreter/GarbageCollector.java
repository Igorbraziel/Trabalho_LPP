package Interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static Interpreter.ListasObjetos.getMemoriaFisica;

public class GarbageCollector {
    private static String corDaVez;
    private static int contadorInstrucoes;

    public static void mudaCorDaVez(){
        if(corDaVez.equals("vermelho")){
            corDaVez = "preto";
        } else {
            corDaVez = "vermelho";
        }
    }

    public static void incrementaContador(){
        contadorInstrucoes = contadorInstrucoes + 1;
    }

    public static void pintaMemoria(HashMap<String, HashMap<String, Var>> escopos){
        for(Map.Entry<String, HashMap<String, Var>> e : escopos.entrySet()) {
            HashMap<String, Var> value = e.getValue();
            for(Map.Entry<String, Var> hashEscopos : value.entrySet()) {
                Var variaveisPintar = hashEscopos.getValue();
                variaveisPintar.setCor(corDaVez);
                if(variaveisPintar.getValor() instanceof EstruturaObjeto){
                    HashMap<String, Var> variaveisObjeto = ((EstruturaObjeto) variaveisPintar.getValor()).getVariaveisDoObjeto();
                    pintaObjetos(variaveisObjeto);
                }
            }
        }
    }

    public static void pintaObjetos(HashMap<String, Var> variaveisObjeto){
        for(Map.Entry<String, Var> intermediario : variaveisObjeto.entrySet()) {
            intermediario.getValue().setCor(corDaVez);
            if(intermediario.getKey().equals("_prototype")){
                if(intermediario.getValue().getValor() instanceof EstruturaObjeto){
                    HashMap<String, Var> objetoPai = ((EstruturaObjeto) intermediario.getValue().getValor()).getVariaveisDoObjeto();
                }
            }
        }
    }

    public static void coletorDeLixo(){

        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = getMemoriaFisica().size() - 1; i >= 0; i--){
            if(!getMemoriaFisica().get(i).getCor().equals(corDaVez)){
                getMemoriaFisica().remove(i);

            }
        }

    }


    public static void setCorDaVez(String corDaVez) {GarbageCollector.corDaVez = corDaVez;}
    public static int getContadorInstrucoes() {return contadorInstrucoes;}

    public static String getCorDaVez() {return corDaVez;}
    public static void setContadorInstrucoes(int contadorInstrucoes) {GarbageCollector.contadorInstrucoes = contadorInstrucoes;}
}
