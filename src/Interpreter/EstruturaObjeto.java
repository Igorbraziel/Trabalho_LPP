package Interpreter;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Interpreter.Intermediadora.intermediadoraMetodo;
import static Interpreter.ListasObjetos.*;
import static Interpreter.ListasObjetos.getMemoriaFisica;

//POSSUI A ESTRUTURA GENERICA PARA CLASSES DA LINGUAGEM BOOL
//A ESTRUTURA GENÉRICA DAS CLASSES E OS OBJETOS SÃO INSTANCIADOS COMO OBJETOS DESSA CLASSE

public class EstruturaObjeto {
    private String className;
    private List<DefinicaoMetodo> metodos = new LinkedList<DefinicaoMetodo>();
    private String variaveisDaClasse;
    private HashMap<String, Var> variaveisDoObjeto = new HashMap<>();

    EstruturaObjeto(String className, List<DefinicaoMetodo> metodos, String variaveisDaClasse){
        this.metodos = metodos;
        this.className = className;
        this.variaveisDaClasse = variaveisDaClasse;
    }
    EstruturaObjeto(){
        //
    }

    public String getClassName() {
        return className;
    }
    public List<DefinicaoMetodo> getMetodos() {
        return metodos;
    }
    public String getVariaveisDaClasse() {
        return variaveisDaClasse;
    }
    public HashMap<String, Var> getVariaveisDoObjeto() {
        return variaveisDoObjeto;
    }


    public void setVariaveisDoObjeto(HashMap<String, Var> variaveisDoObjeto) {
        this.variaveisDoObjeto = variaveisDoObjeto;
    }
    public void setVariaveisDaClasse(String variaveisDaClasse){this.variaveisDaClasse = variaveisDaClasse;}
    public void setClassName(String className) {
        this.className = className;
    }
    public void setMetodos(List<DefinicaoMetodo> metodos) {
        this.metodos = metodos;
    }

    public void identificaMetodo(String nome, DefinicaoMetodo metodoParametro){
        for(DefinicaoMetodo item : metodos){
            if (item.getNome().equals(nome)){
                metodoParametro.setInstrucoes(item.getInstrucoes());
                metodoParametro.setParametros(item.getParametros());
            }
        }
    }

    public Boolean executaMetodo(String linhaCompilada, List<Var> pilha, BufferedReader br, DefinicaoMetodo metodoExecutado){
        Boolean achouMatch;
        Pattern pattern;
        Matcher matcher;
        String parametros;
        LinkedList<String> parametrosSeparados = new LinkedList<String>();



        for (int i = 0; i < metodoExecutado.getInstrucoes().size(); i++){
            //System.out.println(getEscopos());
            try {
                System.out.println(metodoExecutado.getInstrucoes().get(i));
                intermediadoraMetodo(metodoExecutado.getInstrucoes().get(i), pilha, br, metodoExecutado);
            } catch (Exception e){
                System.out.println("ERROR: " + e);
            }

            pattern = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
            matcher = pattern.matcher(metodoExecutado.getInstrucoes().get(i));
            achouMatch = matcher.find();
            if (achouMatch){
                pattern = Pattern.compile("^\\s*[(]([a-zA-Z,\\s]*)[)]\\s*$");
                matcher = pattern.matcher(metodoExecutado.getParametros());
                achouMatch = matcher.find();
                if(achouMatch){
                    parametros = matcher.group(1);
                    while(achouMatch){
                        /*SEPARA O NOME DE TODAS AS VARIAVEIS E A ADICIONA
                         * À ESTRUTURA DA CLASSE EM listaVars*/
                        pattern = Pattern.compile("([a-zA-Z]+)");
                        matcher = pattern.matcher(parametros);
                        matcher.find();
                        parametrosSeparados.addFirst(matcher.group(1));

                        pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                        matcher = pattern.matcher(parametros);
                        achouMatch = matcher.find();
                        if(achouMatch){
                            parametros = matcher.group(1);
                        }
                    }

                    for (int j = 0; j < parametrosSeparados.size(); j++){
                        Var variavel = new Var("", pilha.getFirst().getValor());
                        pilha.removeFirst();
                        getEscopos().get(getFuncaoEmExecucao().getFirst()).put(parametrosSeparados.get(j), variavel);
                    }

                }
            }

        }


        return false;
    }
}
