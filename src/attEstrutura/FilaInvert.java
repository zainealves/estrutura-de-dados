package attEstrutura;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaInvert {
     public static <T> void inverter(Queue<T> fila) {
        Deque<T> pilha = new ArrayDeque<>();

        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }
        while (!pilha.isEmpty()) {
            fila.offer(pilha.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva caracteres separados por espaço:");
        String linha = sc.nextLine().trim();

        Queue<String> fila = new LinkedList<>();
        if (!linha.isEmpty()) {
            for (String item : linha.split("\\s+")) {
                fila.offer(item);
            }
        }

        System.out.println("Fila original: " + fila);

        inverter(fila);

        System.out.println("Invertida: " + fila);
        sc.close();
    }
}
