package FilaEstatica;

public class Main {

    public static void main(String[] args) {

        FilaEstatica  f = new FilaEstatica(3);
        f.inserir(20);
        f.inserir(30);
        f.inserir(40);

        f.remove();
        f.imprimir();

    }
}
