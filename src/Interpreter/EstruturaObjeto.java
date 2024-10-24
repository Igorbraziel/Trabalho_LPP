package Interpreter;

import java.util.LinkedList;
import java.util.List;

//POSSUI A ESTRUTURA GENERICA PARA CLASSES DA LINGUAGEM BOOL
//A ESTRUTURA GENÉRICA DAS CLASSES E OS OBJETOS SÃO INSTANCIADOS COMO OBJETOS DESSA CLASSE

public class EstruturaObjeto {
    private String className;
    private List<DefinicaoMetodo> metodos = new LinkedList<DefinicaoMetodo>();
    private String variaveisDaClasse;

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


    public void setVariaveisDaClasse(String variaveisDaClasse){this.variaveisDaClasse = variaveisDaClasse;}
    public void setClassName(String className) {
        this.className = className;
    }
    public void setMetodos(List<DefinicaoMetodo> metodos) {
        this.metodos = metodos;
    }
}
