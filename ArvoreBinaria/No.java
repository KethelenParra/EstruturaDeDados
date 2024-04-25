package ArvoreBinaria;

public class No {

    int elemento;
    No direita;
    No esquerda;

    public No(int elemento) {
        this.elemento = elemento;
        this.direita = null;
        this.esquerda = null;
    }

    @Override
    public String toString() {
        return "elemento no: " + elemento;
    }
  
}
