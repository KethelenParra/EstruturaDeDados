package PilhaDinamica;

public class PilhaDinamica<N> {
    
    private No<N> topo;
    private int tamanho;
    
    public PilhaDinamica(){
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(N elemento){
        No<N> noAux = new No<>(elemento);

        noAux.setProximo(this.topo);
        this.topo = noAux;
        tamanho++;
    }

    public N pop(){
        if(isEmpty()){
            System.out.println("Pilha vazia!");
            return null;
        }

        N elementoRemovido = this.topo.getDado();
        this.topo = this.topo.getProximo();
        tamanho--;

        return elementoRemovido;
    }

    public int tamanho(){
        return tamanho;
    }

    public void imprimir(){
        if(isEmpty()){
            System.out.println("Pilha vazia!");
            return;
        }
        No<N> atual = topo;
        System.out.print("Pilha: ");
        while (atual != null){
            System.out.println(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
