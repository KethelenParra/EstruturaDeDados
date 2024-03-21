package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada {

    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
    }

    public void inserirInicio(int elemento){
        No noAux = new No(elemento);
        if (primeiro == null) {
            primeiro = noAux;
            ultimo = noAux;
        } else {
            noAux.proximo = primeiro;
            primeiro.anterior = noAux; 
            primeiro = noAux;
        }
        tamanho++;
    }

    public void imprimir() {
        No atual = primeiro;
        System.out.print("Lista Duplamente Encadeada: ");
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
