package Interpreter;

import java.util.HashMap;
import java.util.LinkedList;

public class ListasObjetos {
    //ARMAZENA O ESQUELETO DAS CLASSES QUE SÃO DESCRITAS ANTES DO PROGRAMA COMEÇAR
    private static HashMap<String, EstruturaObjeto> listaEstruturaClasses = new HashMap<>();
    /*SIMULA OS DIFERENTES ESCOPOS DE VARIAVEIS DENTRO DO PROGRAMA
    * ARMAZENANDO O NOME DO ESCOPO E OS HASHMAPS REFERENTES A CADA ESCOPO*/
    private static HashMap<String, HashMap<String, Var>> escopos = new HashMap<String, HashMap<String, Var>>();
    //SIMULA A MEMÓRIA DO COMPUTADOR. É UMA LISTA QUE ARMAZENA TODOS OS DADOS USADOS NO PROGRAMA
    private static LinkedList<Var> memoriaFisica = new LinkedList<Var>();
    //ARMAZENA UMA PILHA DE STINGS PARA REPRESENTAR QUAL ESCOPO DE VARIÁVEIS ESTÁ SENDO EXECUTADO
    private static LinkedList<String> funcaoEmExecucao = new LinkedList<>();


    public static HashMap<String, HashMap<String, Var>> getEscopos() {
        return escopos;
    }
    public static LinkedList<Var> getMemoriaFisica() {
        return memoriaFisica;
    }
    public static HashMap<String, EstruturaObjeto> getListaEstruturaClasses() {
        return listaEstruturaClasses;
    }
    public static LinkedList<String> getFuncaoEmExecucao() {
        return funcaoEmExecucao;
    }

    //PRECISA MESMO DESSES SETs?
    public static void setMemoriaFisica(LinkedList<Var> memoriaFisica) {
        ListasObjetos.memoriaFisica = memoriaFisica;
    }

    public static void setEscopos(HashMap<String, HashMap<String, Var>> escopos) {
        ListasObjetos.escopos = escopos;
    }
    public static void setFuncaoEmExecucao(LinkedList<String> funcaoEmExecucao) {
        ListasObjetos.funcaoEmExecucao = funcaoEmExecucao;
    }

    public static void addEstrutura(String nomeClasse, EstruturaObjeto estrutura){
        listaEstruturaClasses.put(nomeClasse, estrutura);
    }

}
