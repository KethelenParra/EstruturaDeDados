package ArvoreRubroNegra;

public class Main {
    public static void main(String[] args) {
        Arvore arvoreRubroNegra = new Arvore();
        arvoreRubroNegra.adicionar(8);
        arvoreRubroNegra.adicionar(10);
        arvoreRubroNegra.adicionar(15);
        arvoreRubroNegra.adicionar(18);
        arvoreRubroNegra.adicionar(20);
        arvoreRubroNegra.adicionar(16);
        arvoreRubroNegra.adicionar(7);
        arvoreRubroNegra.adicionar(9);
        arvoreRubroNegra.imprimir();
        System.out.println();
        arvoreRubroNegra.excluir(16);
        System.out.println();
        arvoreRubroNegra.encontrar(18);
        
        arvoreRubroNegra.imprimir();
    }
}
