package Interpreter;

public class Var<T> {
    private String cor;
    private T valor;

    public Var(String cor, T valor) {
        this.cor = cor;
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Var [cor=" + cor + ", valor=" + valor + "]";
    }
}
