package Interpreter;

import java.util.LinkedList;
import java.util.List;

//CRIA DUAS LISTA UMA DE ESTRUTURAS DAS CLASSES DECLARADAS
//E A OUTRA DE OBJETOS INSTANCIADOS COM BASE NESSAS ESTRUTURAS DECLARADAS
public class ListasObjetos {
    private static List<EstruturaObjeto> listaEstruturaClasses = new LinkedList<EstruturaObjeto>();
    private static List<EstruturaObjeto> objetosInstanciados = new LinkedList<EstruturaObjeto>();

    public static void addEstrutura(EstruturaObjeto estrutura){
        listaEstruturaClasses.addFirst(estrutura);
    }

    public static void addObjeto(EstruturaObjeto objeto){
        objetosInstanciados.addFirst(objeto);
    }

    public static List<EstruturaObjeto> getObjetosInstanciados() {
        return objetosInstanciados;
    }

    public static List<EstruturaObjeto> getListaEstruturaClasses() {
        return listaEstruturaClasses;
    }
}
