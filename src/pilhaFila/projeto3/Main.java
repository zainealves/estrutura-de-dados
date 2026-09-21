package pilhaFila.projeto3;

import java.util.Stack;

public class Main {
      public static void main(String[] args) {

        Stack<Processo> pilha = new Stack<>();

        Processo p1 = new Processo(1, "Documento A");
        Processo p2 = new Processo(2, "Documento B");
        Processo p3 = new Processo(3, "Documento C");

    
        pilha.push(p1);
        pilha.push(p2);
        pilha.push(p3);

        System.out.println("Processos na pilha:");

        for (Processo p : pilha) {
            p.mostrar();
        }

        System.out.println("\nProcesso no topo:");

        pilha.peek().mostrar();

      
        System.out.println("\nDesempilhando:");

        Processo removido = pilha.pop();
        removido.mostrar();

        System.out.println("\nPilha depois de desempilhar:");

        for (Processo p : pilha) {
            p.mostrar();
        }
    }
}
