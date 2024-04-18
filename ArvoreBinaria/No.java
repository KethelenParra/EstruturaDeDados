package ArvoreBinaria;

public class No {

    int elemento;
    No direita;
    No esquerda;
    int altura;

    public No(int elemento) {
        this.elemento = elemento;
        this.direita = null;
        this.esquerda = null;
        this.altura = 1;
    }

}
