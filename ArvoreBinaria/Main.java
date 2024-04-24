package ArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserirNo(arvore.noRaiz, 20);
        arvore.inserirNo(arvore.noRaiz, 10);
        arvore.inserirNo(arvore.noRaiz, 30);
        arvore.inserirNo(arvore.noRaiz, 25);
        arvore.inserirNo(arvore.noRaiz, 35);

        System.out.println("Em-Ordem");
        arvore.emOrdem(arvore.noRaiz);

        System.out.println("\nPré-Ordem");
        arvore.preOrdem(arvore.noRaiz);

        System.out.println("\nPós-Ordem");
        arvore.posOrdem(arvore.noRaiz);
    }
}
