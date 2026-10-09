package attEstrutura;

import java.text.Normalizer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PilhaPalin {
     private static String normalizar(String texto) {
        String semAcento = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcento.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    public static boolean ehPalindromo(String texto) {
        String limpo = normalizar(texto);
        Deque<Character> pilha = new ArrayDeque<>();

        // Empilha todos os caracteres
        for (char c : limpo.toCharArray()) {
            pilha.push(c);
        }

        for (char c : limpo.toCharArray()) {
            if (c != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escreva sua palavra ou frase: ");
        String entrada = sc.nextLine();

        if (ehPalindromo(entrada)) {
            System.out.println("\"" + entrada + "\" Palíndromo.");
        } else {
            System.out.println("\"" + entrada + "\" NÃO é um palíndromo.");
        }
        sc.close();
    }
}
