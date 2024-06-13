package ArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserirNo(arvore.noRaiz, 5);
        arvore.inserirNo(arvore.noRaiz, 3);
        arvore.inserirNo(arvore.noRaiz, 2);
        arvore.inserirNo(arvore.noRaiz, 4);
        arvore.inserirNo(arvore.noRaiz, 7);
        arvore.inserirNo(arvore.noRaiz, 8);
        arvore.inserirNo(arvore.noRaiz, 9);

        System.out.println("Em-Ordem");
        arvore.emOrdem(arvore.noRaiz);

        System.out.println("\nPré-Ordem");
        arvore.preOrdem(arvore.noRaiz);

        System.out.println("\nPós-Ordem");
        arvore.posOrdem(arvore.noRaiz);

        System.out.println("\nBusca " + arvore.buscaNo(4));

        int elementoParaRemover = 3;
        arvore.removerNo(elementoParaRemover);

        System.out.println("Em-Ordem");
        arvore.emOrdem(arvore.noRaiz);

        System.out.println();
        arvore.altura();
        
    }
}
