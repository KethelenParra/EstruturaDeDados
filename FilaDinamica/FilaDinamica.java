package FilaDinamica;

public class FilaDinamica<N> {
    
    private No<N> inicio;
    private No<N> fim;

    public FilaDinamica(){
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty(){
        return inicio == null;
    }

    public void enqueue(N elemento){
        No<N> novoNo = new No<>(elemento);
        
        if(isEmpty()){
            inicio = novoNo;
        } else {
            fim.setProximo(novoNo);
        }
        fim = novoNo;
    }

    public N dequeue() {
        N elementoRemovido = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null){
            fim = null;
        }

        return elementoRemovido;
    }

    public int size(){
        int tamanho = 0;
        No<N> atual = inicio;
        while (atual != null){
            tamanho ++;
            atual = atual.getProximo();
        }
        return tamanho;
    }

    public void imprimir(){
        if (isEmpty()){
            System.out.println("Fila vazia!");
            return;
        }
        No<N> atual = inicio;
        System.out.print("Fila: ");
        while(atual != null){
            System.out.println(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

}
