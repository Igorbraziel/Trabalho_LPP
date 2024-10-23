package Interpreter;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Interpreter.Intermediadora.Intermediadora;

public class DefinicaoClasse {
    public static Boolean DefinicaoClasse(String linhaCompilada, List<Var> pilha, BufferedReader br){
        Pattern pattern = Pattern.compile("^\\s*class\\s+(\\w+)\\s*$");
        Matcher matcher = pattern.matcher(linhaCompilada);
        Boolean achouMatch;
        List<Var> listaVars = new ArrayList<Var>();
        List<DefinicaoMetodo> metodos = new ArrayList<DefinicaoMetodo>();

        if(matcher.find()){
            String className = matcher.group(1);

            try {
                linhaCompilada = br.readLine();
                pattern = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
                matcher = pattern.matcher(linhaCompilada);
                achouMatch = matcher.find();
                if (achouMatch) {
                    String parametros = matcher.group(1);
                    String separatedParamether;

                    while(achouMatch){

                        pattern = Pattern.compile("([a-zA-Z]+)");
                        matcher = pattern.matcher(parametros);
                        matcher.find();
                        separatedParamether = matcher.group(1);
                        Var variavel = new Var("", 0);
                        variavel.setNome(separatedParamether);
                        listaVars.addFirst(variavel);

                        pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                        matcher = pattern.matcher(parametros);
                        achouMatch = matcher.find();
                        if(achouMatch){
                            parametros = matcher.group(1);
                        }
                    }


                }
                while (!achouMatch) {
                    pattern = Pattern.compile("end-class");
                    matcher = pattern.matcher(linhaCompilada);
                    achouMatch = matcher.find();
                    if(!achouMatch) {
                        pattern = Pattern.compile("^\\s*method\\s+(\\w+)[(][)]\\s*$");
                        matcher = pattern.matcher(linhaCompilada);
                        achouMatch = matcher.find();
                        if(achouMatch) {

                            ArrayList<String> instrucoes = new ArrayList<String>();
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

            for(int k = 0; k<listaVars.size(); k++){
                System.out.println(listaVars.get(k).getNome() + " - " + listaVars.get(k).getValor());
            }
            for(int i = 0; i<metodos.size(); i++) {
                System.out.println("Nome do metodo: " + metodos.get(i).getNome());
                for (int j = 0; j < metodos.get(i).getInstrucoes().size(); j++) {
                    System.out.println(metodos.get(i).getInstrucoes().get(j));
                }
            }
            System.out.println("Acabou a classe");
            return true;
        }
        return false;
    }
}
