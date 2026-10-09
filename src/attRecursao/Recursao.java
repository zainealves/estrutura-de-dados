package attRecursao;

import java.util.Scanner;

public  class Recursao {
    

        public static int fibonacci(int termo) {
            if (termo <= 1) {
                return termo;
            }
    
            return fibonacci(termo - 2) + fibonacci(termo - 1);
        }
    
        public static int calcularPotencia(int base, int expoente) {
            if (expoente == 0) {
                return 1;
            }
    
            return calcularPotencia(base, expoente - 1) * base;
        }
    
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
    
            System.out.println(" SEQUÊNCIA DE FIBONACCI ");
            System.out.print("Informe a quantidade de termos: ");
            int termos = teclado.nextInt();
    
            if (termos < 0) {
                System.out.println("Quantidade inválida!");
            } else {
                for (int i = 0; i < termos; i++) {
                    System.out.print(fibonacci(i) + " ");
                }
                System.out.println();
            }
    
            System.out.println("\n CÁLCULO DE POTÊNCIA ");
            System.out.print("Informe a base: ");
            int base = teclado.nextInt();
    
            System.out.print("Informe o expoente: ");
            int expoente = teclado.nextInt();
    
            if (expoente < 0) {
                System.out.println("O expoente deve ser maior ou igual a zero.");
            } else {
                int resultado = calcularPotencia(base, expoente);
                System.out.println("Resultado: " + resultado);
            }
    
            teclado.close();
        }
    }

