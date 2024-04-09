package ListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserirInicio(10);
        lista.inserirInicio(15);
        lista.inserirInicio(20);
        lista.inserirFim(16);
        lista.inserirFim(23);
        lista.inserirMeio(11);
        lista.inserirMeio(17);


        System.out.println("Lista Duplamente Encadeada:");
        lista.imprimir();

        System.out.println("\nTamanho da lista: " + lista.tamanho());

        lista.removerInicio();
        lista.removerFim();
        lista.removerMeio(17);

        System.out.println("\nLista após remoção:");
        lista.imprimir();
        System.out.println("\nTamanho da lista: " + lista.tamanho());

        System.out.println("\nLista está vazia? " + lista.estaVazia());
    }
}