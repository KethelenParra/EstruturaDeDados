package ListaDuplamenteEncadeada;

class ListaDuplamenteEncadeada {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void inserirInicio(int elemento) {
        No novoNo = new No(elemento);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else if (elemento <= primeiro.elemento) {
            novoNo.proximo = primeiro;
            primeiro.anterior = novoNo;
            primeiro = novoNo;
        } else {
            inserirMeio(elemento);
        }
        tamanho++;
    }

    public void inserirFim(int elemento) {
        No novoNo = new No(elemento);
        if (ultimo == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else if (elemento >= ultimo.elemento) {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        } else {
            inserirMeio(elemento);
        }
        tamanho++;
    }

    public void inserirMeio(int elemento) {
        No novoNo = new No(elemento);
        No atual = primeiro;
        while (atual != null && atual.elemento < elemento) {
            atual = atual.proximo;
        }
        if (atual == null) {
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        } else if (atual == primeiro) {
            novoNo.proximo = primeiro;
            primeiro.anterior = novoNo;
            primeiro = novoNo;
        } else {
            novoNo.proximo = atual;
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
        }
        tamanho++;
    }

    public int removerInicio() {
        if (primeiro == null) {
            return -1; // Lista vazia
        }
        int elementoRemovido = primeiro.elemento;
        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            primeiro = primeiro.proximo;
            if (primeiro != null) {
                primeiro.anterior = null;
            }
        }
        tamanho--;
        if (tamanho == 0) { // Ajuste para quando há apenas um elemento na lista
            primeiro = null;
            ultimo = null;
        }
        return elementoRemovido;
    }
    
    public int removerFim() {
        if (ultimo == null) {
            return -1; // Lista vazia
        }
        int elementoRemovido = ultimo.elemento;
        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            ultimo = ultimo.anterior;
            if (ultimo != null) {
                ultimo.proximo = null;
            }
        }
        tamanho--;
        if (tamanho == 0) { // Ajuste para quando há apenas um elemento na lista
            primeiro = null;
            ultimo = null;
        }
        return elementoRemovido;
    }

    public int removerMeio(int elemento) {
        if (primeiro == null) {
            return -1; // Lista vazia
        }
        if (primeiro.elemento == elemento) {
            return removerInicio();
        }
        if (ultimo.elemento == elemento) {
            return removerFim();
        }
        No atual = primeiro;
        while (atual != null && atual.elemento != elemento) {
            atual = atual.proximo;
        }
        if (atual == null) {
            return -1; // Elemento não encontrado
        }
        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;
        tamanho--;
        return atual.elemento;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}