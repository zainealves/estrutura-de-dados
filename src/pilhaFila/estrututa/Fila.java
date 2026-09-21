package pilhaFila.estrututa;

import pilhaFila.basica.Processo;
import java.util.Stack;

public class Fila {
    
private Processo[] elementos;
private int inicio;
private int fim;
private int tamanho;

public Fila(int capacidade) {
    elementos = new Processo[capacidade];
    inicio = 0;
    fim = 0;
    tamanho = 0;
}

// Adicionar processo na fila
public void adicionar(Processo processo) {

    if (tamanho == elementos.length) {
        System.out.println("Fila cheia!");
        return;
    }

    elementos[fim] = processo;
    fim = (fim + 1) % elementos.length;
    tamanho++;

    System.out.println("Processo adicionado!");
}

// Remover processo da fila
public Processo remover() {

    if (tamanho == 0) {
        System.out.println("Fila vazia!");
        return null;
    }

    Processo processo = elementos[inicio];

    elementos[inicio] = null;
    inicio = (inicio + 1) % elementos.length;
    tamanho--;

    return processo;
}

// Verificar o primeiro processo
public Processo verificar() {

    if (tamanho == 0) {
        System.out.println("Fila vazia!");
        return null;
    }

    return elementos[inicio];
}

// Mostrar todos os processos
public void mostrar() {

    if (tamanho == 0) {
        System.out.println("Fila vazia!");
        return;
    }

    System.out.println("\n--- PROCESSOS NA FILA ---");

    for (int i = 0; i < tamanho; i++) {
        int posicao = (inicio + i) % elementos.length;
        System.out.println(elementos[posicao]);
    }
}

// Inverter a fila usando uma pilha
public void inverter() {

    Stack<Processo> pilha = new Stack<>();

    // Coloca todos os processos na pilha
    while (tamanho > 0) {
        pilha.push(remover());
    }

    // Retira da pilha e coloca novamente na fila
    while (!pilha.isEmpty()) {
        adicionar(pilha.pop());
    }

    System.out.println("Fila invertida!");
}

}

