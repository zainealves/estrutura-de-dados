package pilhaFila.projeto2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    
public static void main(String[] args) {

        Queue<Processo> fila = new LinkedList<>();

        Processo p1 = new Processo(1, "Documento A");
        Processo p2 = new Processo(2, "Documento B");
        Processo p3 = new Processo(3, "Documento C");

        fila.add(p1);
        fila.add(p2);
        fila.add(p3);

        System.out.println("Fila:");

        for (Processo p : fila) {
            p.mostrar();
        }

        System.out.println("\nPrimeiro processo:");
        fila.peek().mostrar();

        System.out.println("\nRemovendo:");
        fila.poll().mostrar();

        System.out.println("\nFila depois da remocao:");

        for (Processo p : fila) {
            p.mostrar();
        }

        Stack<Processo> pilha = new Stack<>();

        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }

        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }


        System.out.println("\nFila invertida:");

        for (Processo p : fila) {
            p.mostrar();
        }
    }
}
