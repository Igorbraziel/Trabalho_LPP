package Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Interpreter.Intermediadora.Intermediadora;
import static Interpreter.ListasObjetos.*;

public class BoolInterpreter {
    public static void trocaCor(String cor){
        if (cor.equals("vermelho")){
            cor = "preto";
        } else { cor = "vermelho"; }
    }

    public static void coletorLixo(HashMap<String, HashMap<String, Var<?>>> map, String corAtual){
        map.forEach((nome, vars) -> {
            Iterator<Map.Entry<String, Var<?>>> iterator = vars.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, Var<?>> entry = iterator.next();
                String corMap = entry.getValue().getCor();

                if (!corMap.equals(corAtual)) {
                    iterator.remove();  // Remove o elemento atual de forma segura
                }
            }
        });
    }

    public static void main(String[] args) {
        String arquivoEntrada;
        /*Stack<Object> pilha = new Stack<>();*/
        List<Var> pilhaList = new LinkedList<>();
        int contador = 0;

        

        getFuncaoEmExecucao().addFirst("main");

        try{
            arquivoEntrada = args[0];

            try(BufferedReader br = new BufferedReader( new FileReader( arquivoEntrada ) )){
                String linhaCompilada = br.readLine();
                HashMap<String, HashMap<String, Var<?>>> escopos = getEscopos();
                String cor = "vermelho";

                while(linhaCompilada != null){
                    if (contador == 5){
                        contador = 0;
                        escopos.forEach((nome, vars) -> {
                            vars.forEach((key, var) -> {
                                var.setCor(cor);
                                //executa o gc
                                trocaCor(cor);
                            });
                        });

                    }
                    System.out.println(linhaCompilada);
                    Intermediadora(linhaCompilada, pilhaList, br);
                    linhaCompilada = br.readLine();
                    contador ++;
                }
            } catch (IOException error){
                System.out.println("Error: " + error.getMessage());
            }
        } catch(ArrayIndexOutOfBoundsException error){
            System.out.println("O arquivo de entrada compilado deve ser informado na execução do programa");
            error.printStackTrace();
        }

//        List<EstruturaObjeto> listaEst = getListaEstruturaClasses();
//
//
//
//        System.out.println("\n\nListagem das classes\n");
//        for(int i = 0; i<listaEst.size(); i++) {
//            System.out.println("Nome da classe: " + listaEst.get(i).getClassName());
//            System.out.print("Nome das Variáveis: " + listaEst.get(i).getVariaveisDaClasse());
//
//            System.out.println("");
//            for (int j = 0; j < listaEst.get(i).getMetodos().size(); j++) {
//                System.out.println("Nome do metodo: " + listaEst.get(i).getMetodos().get(j).getNome());
//                for(int k = 0; k<listaEst.get(i).getMetodos().get(j).getInstrucoes().size(); k++) {
//                    System.out.println(listaEst.get(i).getMetodos().get(j).getInstrucoes().get(k));
//                }
//            }
//        }
    }
}
