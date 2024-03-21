package ListaDuplamenteEncadeada;

public class No {

    No proximo;
    int elemento;
    public No anterior;

    public No(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No getProximo() {
        return proximo;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public int getElemento() {
        return elemento;
    }
    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
}
