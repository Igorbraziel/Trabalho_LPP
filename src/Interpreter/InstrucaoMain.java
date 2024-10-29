package Interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;


public class InstrucaoMain {
    public static Boolean instrucaoMain(String linhaCompilada){
        Pattern pattern = Pattern.compile("^\\s*main\\s*[(][)]\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);

        if(matcher.find()){
            getFuncaoEmExecucao().addFirst("main");



            HashMap<String, EstruturaObjeto> listaEst = getListaEstruturaClasses();

            System.out.println("\n\nListagem das classes\n");
                for(Map.Entry<String, EstruturaObjeto> item : listaEst.entrySet()){
                System.out.println("Nome da classe: " + item.getValue().getClassName());
                System.out.print("Nome das Variáveis: " + item.getValue().getVariaveisDaClasse());

                System.out.println("");
                for (int j = 0; j < item.getValue().getMetodos().size(); j++) {
                    System.out.println("Nome do metodo: " + item.getValue().getMetodos().get(j).getNome());
                    for(int k = 0; k<item.getValue().getMetodos().get(j).getInstrucoes().size(); k++) {
                        System.out.println(item.getValue().getMetodos().get(j).getInstrucoes().get(k));
                    }
                }
            }



            return true;
        }
        return false;
    }
}
