package ArvoreBinaria;

public class ArvoreBinaria {
    public No noRaiz;

    ArvoreBinaria(){
        this.noRaiz = null;
    }

    public void inserirNo(No noAtual, int elemento){
        if(this.noRaiz == null){
            this.noRaiz = new No(elemento);
            System.out.println(this.noRaiz.elemento);
        }
        else if(elemento < noAtual.elemento){
            if(noAtual.esquerda == null){
                noAtual.esquerda = new No(elemento);
                System.out.println(elemento);
            } else {
                noAtual = noAtual.esquerda;
                inserirNo(noAtual, elemento);
            }            
        }
        else if(elemento > noAtual.elemento){
            if(noAtual.direita == null){
                noAtual.direita = new No(elemento);
                System.out.println(elemento);
            } else {
                inserirNo(noAtual.direita, elemento);
            }
        }
    }
    public void emOrdem(No noArvore){
        if(noArvore.esquerda != null){
            emOrdem(noArvore.esquerda);
        }
        System.out.print(" " + noArvore.elemento);
        if(noArvore.direita != null){
            emOrdem(noArvore.direita);
        }
    }


    public void preOrdem(No noArvore){
        System.out.print(" " + noArvore.elemento);
        if (noArvore.esquerda != null){
            preOrdem(noArvore.esquerda);
        }
        if (noArvore.direita != null){
            preOrdem(noArvore.direita);
        }
    }

    public void posOrdem(No noArvore){
        if(noArvore.esquerda != null){
            posOrdem(noArvore.esquerda);
        }
        if(noArvore.direita != null){
            posOrdem(noArvore.direita);
        }
        System.out.print(" " + noArvore.elemento);
    }

    public No buscaNo(int elemento){
        No noAtual = noRaiz;
        while (noAtual != null && noAtual.elemento != elemento) {
            if (elemento < noAtual.elemento) {
                noAtual = noAtual.esquerda;
            } else {
                noAtual = noAtual.direita;
            }
        }
        return noAtual;
    }
    
    public void removerNo(int elemento) {
        this.noRaiz = remover(this.noRaiz, elemento);
    }

    private No remover(No raiz, int elemento) {
        if (raiz == null) {
            return raiz;
        }

        if (elemento < raiz.elemento) {
            raiz.esquerda = remover(raiz.esquerda, elemento);
        } else if (elemento > raiz.elemento) {
            raiz.direita = remover(raiz.direita, elemento);
        } else {
            // Nó com um único filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nó com dois filhos: encontre o nó sucessor e substitua
            raiz.elemento = encontrarMenor(raiz.direita);
            raiz.direita = remover(raiz.direita, raiz.elemento);
        }
        return raiz;
    }

    private int encontrarMenor(No raiz) {
        int menor = raiz.elemento;
        while (raiz.esquerda != null) {
            menor = raiz.esquerda.elemento;
            raiz = raiz.esquerda;
        }
        return menor;
    }
}
