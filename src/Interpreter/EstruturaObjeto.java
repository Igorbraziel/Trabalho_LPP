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

    public void identificaMetodo(DefinicaoMetodo metodoParametro, EstruturaObjeto objetoChamado){
        Boolean achouMetodo = false;
            for (DefinicaoMetodo item : objetoChamado.getMetodos()) {
                if (item.getNome().equals(metodoParametro.getNome())) {
                    metodoParametro.setInstrucoes(item.getInstrucoes());
                    metodoParametro.setParametros(item.getParametros());
                    achouMetodo = true;
                }
            }
            if(!achouMetodo){
                if(objetoChamado.getVariaveisDoObjeto().containsKey("_prototype")){
                    if(objetoChamado.getVariaveisDoObjeto().get("_prototype").getValor() instanceof EstruturaObjeto){
                        EstruturaObjeto objetoIntermediario = (EstruturaObjeto) objetoChamado.getVariaveisDoObjeto().get("_prototype").getValor();
                        identificaMetodo(metodoParametro, objetoIntermediario);
                    }
                }
            }
    }

    public Boolean executaMetodo(String linhaCompilada, List<Var> pilha, BufferedReader br, DefinicaoMetodo metodoExecutado){
        Boolean achouMatch, achouMatch2;
        Boolean entraUmaVez = true;
        Pattern pattern, pattern2;
        Matcher matcher, matcher2;
        String parametros;
        LinkedList<String> parametrosSeparados = new LinkedList<String>();



        for (int i = 0; i < metodoExecutado.getInstrucoes().size(); i++){
            try {
                intermediadoraMetodo(metodoExecutado.getInstrucoes().get(i), pilha, br, metodoExecutado);
            } catch (Exception e){
                System.out.println("ERROR: " + e);
            }

            pattern = Pattern.compile("^\\s*begin\\s*$");
            matcher = pattern.matcher(metodoExecutado.getInstrucoes().get(i));
            achouMatch = matcher.find();
            pattern2 = Pattern.compile("^\\s*vars\\s+([a-zA-Z,\\s]+)\\s*$");
            matcher2 = pattern2.matcher(metodoExecutado.getInstrucoes().get(i));
            achouMatch2 = matcher2.find();
            if ((achouMatch || achouMatch2) && entraUmaVez){
                entraUmaVez = false;

                Pattern pattern3 = Pattern.compile("^\\s*[(](\\s*)[)]\\s*$");
                Matcher matcher3 = pattern3.matcher(metodoExecutado.getParametros());
                Boolean achouMatch3 = matcher3.find();
                if(!achouMatch3) {
                    pattern = Pattern.compile("^\\s*[(]([a-zA-Z,\\s]*)[)]\\s*$");
                    matcher = pattern.matcher(metodoExecutado.getParametros());
                    achouMatch = matcher.find();
                    if (achouMatch) {
                        parametros = matcher.group(1);
                        while (achouMatch) {
                            /*SEPARA O NOME DE TODAS AS VARIAVEIS E A ADICIONA
                             * À ESTRUTURA DA CLASSE EM listaVars*/
                            pattern = Pattern.compile("([a-zA-Z]+)");
                            matcher = pattern.matcher(parametros);
                            matcher.find();
                            parametrosSeparados.addFirst(matcher.group(1));

                            pattern = Pattern.compile("^[\\s]*[a-zA-Z]+[\\s,]+([a-zA-Z\\s,]+)$");
                            matcher = pattern.matcher(parametros);
                            achouMatch = matcher.find();
                            if (achouMatch) {
                                parametros = matcher.group(1);
                            }
                        }
                        if (achouMatch2) {
                            for (int j = 0; j < parametrosSeparados.size(); j++) {
                                Var variavel = new Var("cinza", pilha.getFirst().getValor());
                                pilha.removeFirst();
                                getMemoriaFisica().addFirst(variavel);
                                getEscopos().get(getFuncaoEmExecucao().getFirst()).put(parametrosSeparados.get(j), variavel);
                            }
                        } else {
                            HashMap<String, Var> referenciaVariaveis = new HashMap<>();
                            for (int j = 0; j < parametrosSeparados.size(); j++) {
                                Var variavel = new Var("cinza", pilha.getFirst().getValor());
                                pilha.removeFirst();
                                getMemoriaFisica().addFirst(variavel);
                                referenciaVariaveis.put(parametrosSeparados.get(j), variavel);
                            }
                            getEscopos().put(getFuncaoEmExecucao().getFirst(), referenciaVariaveis);

                        }

                    }
                }

                if(achouMatch2 || achouMatch3){
                    Var variavel = new Var("cinza", metodoExecutado.getSelf());
                    getEscopos().get(getFuncaoEmExecucao().getFirst()).put("self", variavel);
                }else{
                    Var variavel = new Var("cinza", metodoExecutado.getSelf());
                    HashMap<String, Var> mapaIntermediario = new HashMap<>();
                    mapaIntermediario.put("self", variavel);
                    getEscopos().put(getFuncaoEmExecucao().getFirst(), mapaIntermediario);
                }

            }

        }


        return false;
    }
}
