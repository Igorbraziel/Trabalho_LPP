package Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static Interpreter.Intermediadora.intermediadora;
import static Interpreter.ListasObjetos.*;




import java.util.Stack;

public class BoolInterpreter {
    public static void main(String[] args) {
        String arquivoEntrada;
        /*Stack<Object> pilha = new Stack<>();*/
        List<Var> pilhaList = new LinkedList<Var>();
        IoEstrutura objetoIO = new IoEstrutura();
        Var ioVariavel = new Var("cinza", objetoIO);
        getMemoriaFisica().addFirst(ioVariavel);
        HashMap<String, Var> hashIO = new HashMap<>();
        hashIO.put("io", ioVariavel);
        getEscopos().put("io", hashIO);

        //getFuncaoEmExecucao().addFirst("main");

        try{
            arquivoEntrada = args[0];

            try(BufferedReader br = new BufferedReader( new FileReader( arquivoEntrada ) )){
                String linhaCompilada = br.readLine();

                while(linhaCompilada != null){
                    System.out.println(linhaCompilada);
                    intermediadora(linhaCompilada, pilhaList, br);
                    linhaCompilada = br.readLine();
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
