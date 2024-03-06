package FilaDinamica;

public class No<N> {
    
    private N dado;
    private No<N> proximo;

    public No(N dado){
        this.dado = dado;
        this.proximo = null;
    }

    public N getDado() {
        return dado;
    }

    public void setDado(N dado) {
        this.dado = dado;
    }

    public No<N> getProximo() {
        return proximo;
    }

    public void setProximo(No<N> proximo) {
        this.proximo = proximo;
    } 
}
