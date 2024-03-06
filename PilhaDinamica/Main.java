package PilhaDinamica;

public class Main {
    public static void main(String[] args) {
        
        PilhaDinamica p = new PilhaDinamica();
        p.push(20);
        p.push(30);
        p.push(40);

        p.pop();
        p.pop();

        System.out.println("Tamanho: " + p.tamanho());
         
        p.imprimir();
         
        p.pop();

        p.imprimir();
    }
}
