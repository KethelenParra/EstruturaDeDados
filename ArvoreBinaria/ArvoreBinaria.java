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
}
