package Interpreter;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Interpreter.ListasObjetos.*;

public class DefinicaoClasse {
    public static Boolean definicaoClasse(String linhaCompilada, List<Var> pilha, BufferedReader br){
        //IDENTIFICA SE É A DECLARAÇÃO DA ESTRUTURA DE UMA CLASSE
        //QUE PODERÁ SER INSTANCIADA FUTURAMENTE
        Pattern pattern = Pattern.compile("^\\s*class\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);
        Boolean achouMatch;
        String className;
        //List<Var> listaVars = new LinkedList<Var>();
        String variaveisDaClasse = "";
        List<DefinicaoMetodo> metodos = new LinkedList<DefinicaoMetodo>();

        if(matcher.find()){
            className = matcher.group(1); //GUARDA O NOME DA CLASSE

            try {
                linhaCompilada = br.readLine();
                /*VERIFICA SE HÁ VARIÁVEIS NA CLASSE E PASSA O NOME DE TODAS PARA O MÉTODO IinstrucaoVars*/
                pattern = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
                matcher = pattern.matcher(linhaCompilada);
                achouMatch = matcher.find();
                if (achouMatch) {
                    /*ARMAZENA A LINHA DE DECLARAÇÃO DE VARIÁVEIS PARA POSTERIORMENTE CRIAR OS
                    * ESCOPOS DE CADA OBJETO SEPARADAMENTE*/
                    variaveisDaClasse = linhaCompilada;
                }
                achouMatch = !achouMatch;

                /* IDENTIFICA A EXISTÊNCIA DE MÉTODOS ATÉ O FIM DA CLASSE.*/
                while (!achouMatch) {
                    pattern = Pattern.compile("end-class");
                    matcher = pattern.matcher(linhaCompilada);
                    achouMatch = matcher.find();
                    if(!achouMatch) {
                        pattern = Pattern.compile("^\\s*method\\s+(\\w+)[(][)]\\s*$");
                        matcher = pattern.matcher(linhaCompilada);
                        achouMatch = matcher.find();
                        if(achouMatch) {
                            /*PARA CADA MÉTODO GUARDA O NOME E AS INSTRUÇÕES
                             *  PARA QUANDO O MÉTODO FOR CHAMADO*/
                            LinkedList<String> instrucoes = new LinkedList<String>();
                            //CRIA O METODO PASSANDO O NOME DELE COMO PARÂMETRO
                            DefinicaoMetodo metodo = new DefinicaoMetodo(matcher.group(1));
                            achouMatch = !achouMatch;
                            while (!achouMatch) {
                                linhaCompilada = br.readLine();
                                instrucoes.addLast(linhaCompilada);
                                pattern = Pattern.compile("end-method");
                                matcher = pattern.matcher(linhaCompilada);
                                achouMatch = matcher.find();
                            }
                            metodo.setInstrucoes(instrucoes);
                            metodos.addFirst(metodo);
                            achouMatch = !achouMatch;
                        }
                        linhaCompilada = br.readLine();
                    }
                }


            }catch(Exception error){
                System.out.println("O arquivo de entrada compilado deve ser informado na execução do programa");
                System.out.println("Error: " + error.getMessage());
            }


//            for(int k = 0; k<listaVars.size(); k++){
//                System.out.println(listaVars.get(k).getNome() + " - " + listaVars.get(k).getValor());
//            }
//            for(int i = 0; i<metodos.size(); i++) {
//                System.out.println("Nome do metodo: " + metodos.get(i).getNome());
//                for (int j = 0; j < metodos.get(i).getInstrucoes().size(); j++) {
//                    System.out.println(metodos.get(i).getInstrucoes().get(j));
//                }
//            }
            addEstrutura(className, new EstruturaObjeto(className, metodos, variaveisDaClasse));

//            System.out.println("Acabou a classe");
            return true;
        }
        return false;
    }
}
