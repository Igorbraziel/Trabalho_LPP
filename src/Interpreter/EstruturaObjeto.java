package Interpreter;

import java.util.LinkedList;
import java.util.List;

//POSSUI A ESTRUTURA GENERICA PARA CLASSES DA LINGUAGEM BOOL
//A ESTRUTURA GENÉRICA DAS CLASSES E OS OBJETOS SÃO INSTANCIADOS COMO OBJETOS DESSA CLASSE

public class EstruturaObjeto {
    private String className;
    private List<DefinicaoMetodo> metodos = new LinkedList<DefinicaoMetodo>();
    private List<Var> listaVars = new LinkedList<Var>();

    EstruturaObjeto(String className, List<DefinicaoMetodo> metodos, List<Var> listaVars){
        this.metodos = metodos;
        this.className = className;
        this.listaVars = listaVars;
    }

    public String getClassName() {
        return className;
    }
    public List<DefinicaoMetodo> getMetodos() {
        return metodos;
    }
    public List<Var> getListaVars() {
        return listaVars;
    }

    public void setListaVars(List<Var> listaVars) {
        this.listaVars = listaVars;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public void setMetodos(List<DefinicaoMetodo> metodos) {
        this.metodos = metodos;
    }
}
