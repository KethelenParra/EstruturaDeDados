package FilaDinamica;

public class Main {
    
    public static void main(String[] args) {
        FilaDinamica<Integer> fila = new FilaDinamica<>();
        
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        fila.dequeue();
        fila.dequeue();

        System.out.println("Tamanho: " + fila.size());

        fila.imprimir();
        
        fila.dequeue();

        fila.imprimir();
       
    }
}
