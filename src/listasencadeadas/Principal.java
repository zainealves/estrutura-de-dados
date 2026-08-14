package listasencadeadas;

public class Principal {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada valores = new ListaDuplamenteEncadeada();

        System.out.println("Inserindo números no final:");
        valores.inserirNoFim(10);
        valores.inserirNoFim(20);
        valores.inserirNoFim(30);
        valores.inserirNoFim(40);
        valores.inserirNoFim(50);
        valores.exibirLista();

        System.out.println("\nInserindo o número 5 no início:");
        valores.inserirNoInicio(5);
        valores.exibirLista();

        System.out.println("\nInserindo o número 25 na posição 3:");
        valores.inserirNaPosicao(25, 3);
        valores.exibirLista();

        System.out.println("\nRetirando o primeiro elemento:");
        valores.removerDoInicio();
        valores.exibirLista();

        System.out.println("\nRetirando o último elemento:");
        valores.removerDoFim();
        valores.exibirLista();

        System.out.println("\nRetirando o elemento da posição 2:");
        valores.removerDaPosicao(2);
        valores.exibirLista();
    }
}