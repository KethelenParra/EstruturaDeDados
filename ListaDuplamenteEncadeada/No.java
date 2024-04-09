package ListaDuplamenteEncadeada;

class No {
    int elemento;
    No proximo;
    No anterior;

    public No(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
}
