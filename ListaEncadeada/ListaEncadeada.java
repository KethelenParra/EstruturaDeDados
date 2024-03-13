package ListaEncadeada;

public class ListaEncadeada {
    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void inserirInicio(int dado) {
        No noAux = new No(dado);
        if (inicio == null) {
            inicio = noAux;
        } else {
            noAux.proximo = inicio;
            inicio = noAux;
        }
        tamanho++;
    }

    public void inserirFim(int dado) {
        No noAux = new No(dado);
        if (inicio == null) {
            inicio = noAux;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = noAux;
        }
        tamanho++;
    }

    public void inserirMeio(int dado) {
        No noAux = new No(dado);
        if (inicio == null || dado < inicio.dado) {
            noAux.proximo = inicio;
            inicio = noAux;
        } else {
            No anterior = null;
            No atual = inicio;
            while (atual != null && dado > atual.dado) {
                anterior = atual;
                atual = atual.proximo;
            }
            anterior.proximo = noAux;
            noAux.proximo = atual;
        }
        tamanho++;
    }

    public int removerInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }
        int dadoRemovido = inicio.dado;
        inicio = inicio.proximo;
        tamanho--;
        return dadoRemovido;
    }

    public int removerFim() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }
        No anterior = null;
        No atual = inicio;
        while (atual.proximo != null) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (anterior == null) {
            inicio = null;
        } else {
            anterior.proximo = null;
        }
        tamanho--;
        return atual.dado;
    }

    public int removerMeio(int dado) {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }
        No anterior = null;
        No atual = inicio;
        while (atual != null && atual.dado != dado) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (atual == null) {
            throw new RuntimeException("Dado não encontrado na lista");
        }
        if (anterior == null) {
            inicio = inicio.proximo;
        } else {
            anterior.proximo = atual.proximo;
        }
        tamanho--;
        return atual.dado;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}