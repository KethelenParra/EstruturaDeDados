package PilhaEstatica;

public class Main {

    public static void main(String[] args) {

        PilhaEstatica p = new PilhaEstatica(3);
        p.push(20);
        p.push(30);
        p.push(40);

        p.pop();
        p.pop();
        p.imprimir();

    }
}
