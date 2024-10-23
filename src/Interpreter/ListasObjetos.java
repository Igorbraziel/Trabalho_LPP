package Interpreter;

import java.util.LinkedList;
import java.util.List;

//CRIA TRÊS LISTAS, UMA DE ESTRUTURAS DAS CLASSES DECLARADAS.
// A OUTRA DE OBJETOS INSTANCIADOS COM BASE NESSAS ESTRUTURAS DECLARADAS,
//E A OUTRA DE VARIAVEIS DECLARADAS
public class ListasObjetos {
    private static List<EstruturaObjeto> listaEstruturaClasses = new LinkedList<EstruturaObjeto>();
    private static List<EstruturaObjeto> objetosInstanciados = new LinkedList<EstruturaObjeto>();
    private static List<Var> variaveisDeclaradas = new LinkedList<Var>();


    public static void addEstrutura(EstruturaObjeto estrutura){
        listaEstruturaClasses.addFirst(estrutura);
    }
    public static void addObjeto(EstruturaObjeto objeto){
        objetosInstanciados.addFirst(objeto);
    }
    public static void addVariavel(Var variavel){
        variaveisDeclaradas.addFirst(variavel);
    }


    public static List<EstruturaObjeto> getObjetosInstanciados() {
        return objetosInstanciados;
    }
    public static List<EstruturaObjeto> getListaEstruturaClasses() {
        return listaEstruturaClasses;
    }
    public static List<Var> getVariaveisDeclaradas() {
        return variaveisDeclaradas;
    }

    public static EstruturaObjeto getClasseEspecifica(String nome){
        EstruturaObjeto objeto = new EstruturaObjeto();
        for(int i = 0; i < listaEstruturaClasses.size(); i++){
            if(listaEstruturaClasses.get(i).getClassName().equals(nome)){
                objeto = listaEstruturaClasses.get(i);
            }
        }
        return objeto;
    }
}
