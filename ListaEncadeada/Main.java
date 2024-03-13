package ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirFim(10);
        lista.inserirMeio(5);
        lista.inserirMeio(7);
        lista.inserirMeio(3);
        lista.inserirMeio(8);
        lista.inserirMeio(4);
        lista.inserirInicio(1);

        lista.imprimir(); 
        System.out.println("Tamanho: " + lista.tamanho());

        lista.removerMeio(7);
        lista.removerInicio();
        lista.removerFim();

        lista.imprimir(); 

        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Esta vazia? " + lista.estaVazia());
    }
}

