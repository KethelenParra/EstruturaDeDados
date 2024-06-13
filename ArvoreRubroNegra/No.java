package ArvoreRubroNegra;


public class No {
    Integer valor;
    No pai, esquerda, direita;
    boolean cor; // true = vermelho, false = preto

    public No(Integer valor, boolean cor) {
        this.valor = valor;
        this.pai = this.esquerda = this.direita = Arvore.nil;
        this.cor = cor;
    }

    public No buscar(int elemento){
        if(elemento < this.valor && this.esquerda != Arvore.nil) 
            return this.esquerda.buscar(elemento);
        else if (elemento > this.valor && this.direita != Arvore.nil)
            return this.direita.buscar(elemento);
        else 
            return this;
    }

    public No sucessor(){
        if (this.direita != Arvore.nil)
            return this.direita.menor();
        else    
            return this;
    }

    public No antecessor() {
        if (this.esquerda != Arvore.nil)
            return this.esquerda.maior();
        else
            return this;
    }

    public No menor(){
        if(this.esquerda != Arvore.nil)
            return esquerda.menor();
        else 
            return this;
    }

    public No maior(){
        if(this.direita != Arvore.nil)
            return direita.maior();
        else
            return this;
    }
}
