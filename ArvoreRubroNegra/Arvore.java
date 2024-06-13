package ArvoreRubroNegra;

public class Arvore {
    No raiz;
    static No nil = new No(0, false);
    Integer contador;

    Arvore() {
        this.raiz = Arvore.nil;
    }

    Arvore(int elemento) {
        this.raiz = new No(elemento, false);
    }

    private void rotacaoEsquerda(No elemento) {
        No noAux = elemento.direita;
        elemento.direita = noAux.esquerda;

        if (noAux.esquerda != Arvore.nil)
            noAux.esquerda.pai = elemento;
        noAux.pai = elemento.pai;
        if (elemento.pai == Arvore.nil)
            this.raiz = noAux;
        else if (elemento == elemento.pai.esquerda)
            elemento.pai.esquerda = noAux;
        else
            elemento.pai.direita = noAux;
        noAux.esquerda = elemento;
        elemento.pai = noAux;
    }

    private void rotacaoDireita(No elemento) {
        No noAux = elemento.esquerda;
        elemento.esquerda = noAux.direita;

        if (noAux.direita != Arvore.nil)
            noAux.direita.pai = elemento;
        noAux.pai = elemento.pai;
        if (elemento.pai == Arvore.nil)
            this.raiz = noAux;
        else if (elemento == elemento.pai.esquerda)
            elemento.pai.esquerda = noAux;
        else
            elemento.pai.direita = noAux;
        noAux.direita = elemento;
        elemento.pai = noAux;
    }

    public void adicionar(int elemento) {
        if (this.raiz == Arvore.nil) {
            this.raiz = new No(elemento, false);
        } else {
            No noAux = this.buscar(elemento);
            if (elemento < noAux.valor) {
                noAux.esquerda = new No(elemento, true);
                noAux.esquerda.pai = noAux;
                this.fixaAdicao(noAux.esquerda);
            } else if (elemento > noAux.valor) {
                noAux.direita = new No(elemento, true);
                noAux.direita.pai = noAux;
                this.fixaAdicao(noAux.direita);
            }
        }
    }

    private void fixaAdicao(No elementoCor) {
        No noAux;
        while (elementoCor.pai.cor) {
            if (elementoCor.pai == elementoCor.pai.pai.esquerda) {
                noAux = elementoCor.pai.pai.direita;
                if (noAux.cor) {
                    elementoCor.pai.cor = false;
                    noAux.cor = false;
                    elementoCor.pai.pai.cor = true;
                    elementoCor = elementoCor.pai.pai;
                } else {
                    if (elementoCor == elementoCor.pai.direita) {
                        elementoCor = elementoCor.pai;
                        this.rotacaoEsquerda(elementoCor);
                    }
                    elementoCor.pai.cor = false;
                    elementoCor.pai.pai.cor = true;
                    this.rotacaoDireita(elementoCor.pai.pai);
                }
            } else {
                noAux = elementoCor.pai.pai.esquerda;
                if (noAux.cor) {
                    noAux.cor = elementoCor.pai.cor = false;
                    elementoCor.pai.pai.cor = true;
                    elementoCor = elementoCor.pai.pai;
                } else {
                    if (elementoCor == elementoCor.pai.esquerda) {
                        elementoCor = elementoCor.pai;
                        this.rotacaoDireita(elementoCor);
                    }
                    elementoCor.pai.cor = false;
                    elementoCor.pai.pai.cor = true;
                    this.rotacaoEsquerda(elementoCor.pai.pai);
                }
            }
        }
        this.raiz.cor = false;
    }

    public void transplante(No elemento, No noAux) {
        if (elemento.pai == Arvore.nil) {
            this.raiz = noAux;
        } else if (elemento == elemento.pai.esquerda) {
            elemento.pai.esquerda = noAux;
        } else {
            elemento.pai.direita = noAux;
        }
        noAux.pai = elemento.pai;
    }

    public void excluir(int elemento) {
        No noDelete = this.buscar(elemento);

        No noAux, noAux2 = noDelete;
        boolean corOriginal = noDelete.cor;

        if (noDelete.valor == elemento) {
            if (noDelete.esquerda == Arvore.nil) {
                noAux = noDelete.direita;
                this.transplante(noDelete, noDelete.direita);
            } else if (noDelete.direita == Arvore.nil) {
                noAux = noDelete.esquerda;
                this.transplante(noDelete, noDelete.esquerda);
            } else {
                noAux2 = noDelete.sucessor();
                corOriginal = noAux2.cor;
                noAux = noAux2.direita;

                if (noAux2.pai == noDelete) {
                    noAux.pai = noAux2;
                } else {
                    this.transplante(noAux2, noAux2.direita);
                    noAux2.direita = noDelete.direita;
                    noAux2.direita.pai = noAux2;
                }
                this.transplante(noDelete, noAux2);
                noAux2.esquerda = noDelete.esquerda;
                noAux2.esquerda.pai = noAux2;
                noAux2.cor = noDelete.cor;
            }
            if (!corOriginal) {
                this.fixaExclusao(noAux);
            }
        }
    }

    private void fixaExclusao(No elementoCor) {
        No noAux;
        while (elementoCor != this.raiz && elementoCor.cor == false) {
            if (elementoCor == elementoCor.pai.esquerda) {
                noAux = elementoCor.pai.direita;

                if (noAux.cor) {
                    noAux.cor = false;
                    elementoCor.pai.cor = true;
                    this.rotacaoEsquerda(elementoCor.pai);
                    noAux = elementoCor.pai.direita;
                }
                if (!noAux.esquerda.cor && !noAux.direita.cor) {
                    noAux.cor = true;
                    elementoCor = elementoCor.pai;
                } else {
                    if (!noAux.direita.cor) {
                        noAux.esquerda.cor = false;
                        noAux.cor = true;
                        this.rotacaoDireita(noAux);
                        noAux = elementoCor.pai.direita;
                    }
                    noAux.cor = elementoCor.pai.cor;
                    elementoCor.pai.cor = false;
                    noAux.direita.cor = false;
                    this.rotacaoEsquerda(elementoCor.pai);
                    elementoCor = this.raiz;
                }
            } else {
                noAux = elementoCor.pai.esquerda;
                if (noAux.cor) {
                    noAux.cor = false;
                    elementoCor.pai.cor = true;
                    this.rotacaoDireita(elementoCor.pai);
                    noAux = elementoCor.pai.esquerda;
                }
                if (!noAux.esquerda.cor && !noAux.direita.cor) {
                    noAux.cor = true;
                    elementoCor = elementoCor.pai;
                } else {
                    if (!noAux.esquerda.cor) {
                        noAux.direita.cor = false;
                        noAux.cor = true;
                        this.rotacaoEsquerda(noAux);
                        noAux = elementoCor.pai.esquerda;
                    }
                    noAux.cor = elementoCor.pai.cor;
                    elementoCor.pai.cor = false;
                    noAux.esquerda.cor = false;
                    this.rotacaoDireita(elementoCor.pai);
                    elementoCor = this.raiz;
                }
            }
        }
        elementoCor.cor = false;
    }

    public No buscar(int elemento) {
        return this.raiz.buscar(elemento);
    }
    
    public void encontrar(int elemento) {
        No resultado = buscar(elemento);
        if (resultado != Arvore.nil) {
            System.out.println("Elemento encontrado: " + resultado.valor + " [" + color(resultado.cor) + "]");
        } else {
            System.out.println("Elemento " + elemento + " não encontrado.");
        }
    }

    void imprimir() {
        imprimir(raiz);
    }

    void imprimir(No elemento){
        if(elemento != null){
            String valor = (elemento.valor == 0) ? "nil" : elemento.valor + "";
            System.out.print(valor + " [" + color(elemento.cor) + "] -> ");
            imprimir(elemento.esquerda);
            imprimir(elemento.direita);
        }
    }

    String color(boolean cor) {
        return cor ? "VERMELHO" : "PRETO";
    }
}
