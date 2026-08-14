package listasencadeadas;

public class ListaDuplamenteEncadeada {

    private Celula inicio;
    private Celula fim;
    private int total;

    public ListaDuplamenteEncadeada() {
        inicio = null;
        fim = null;
        total = 0;
    }

    public int getTotal() {
        return total;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserirNoFim(int dado) {

        Celula novaCelula = new Celula(dado);

        if (estaVazia()) {
            inicio = novaCelula;
            fim = novaCelula;
        } else {
            novaCelula.setAnterior(fim);
            fim.setProxima(novaCelula);
            fim = novaCelula;
        }

        total++;
    }

    public void inserirNoInicio(int dado) {

        Celula novaCelula = new Celula(dado);

        if (estaVazia()) {
            inicio = novaCelula;
            fim = novaCelula;
        } else {
            novaCelula.setProxima(inicio);
            inicio.setAnterior(novaCelula);
            inicio = novaCelula;
        }

        total++;
    }

    public void inserirNaPosicao(int dado, int posicao) {

        if (posicao < 0 || posicao > total) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 0) {
            inserirNoInicio(dado);
            return;
        }

        if (posicao == total) {
            inserirNoFim(dado);
            return;
        }

        Celula atual = inicio;

        for (int contador = 0; contador < posicao; contador++) {
            atual = atual.getProxima();
        }

        Celula novaCelula = new Celula(dado);
        Celula anterior = atual.getAnterior();

        anterior.setProxima(novaCelula);
        novaCelula.setAnterior(anterior);

        novaCelula.setProxima(atual);
        atual.setAnterior(novaCelula);

        total++;
    }

    public void removerDoInicio() {

        if (estaVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProxima();
            inicio.setAnterior(null);
        }

        total--;
    }

    public void removerDoFim() {

        if (estaVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProxima(null);
        }

        total--;
    }

    public void removerDaPosicao(int posicao) {

        if (posicao < 0 || posicao >= total) {
            System.out.println("Posição inválida!");
            return;
        }

        if (posicao == 0) {
            removerDoInicio();
            return;
        }

        if (posicao == total - 1) {
            removerDoFim();
            return;
        }

        Celula atual = inicio;

        for (int contador = 0; contador < posicao; contador++) {
            atual = atual.getProxima();
        }

        Celula anterior = atual.getAnterior();
        Celula proxima = atual.getProxima();

        anterior.setProxima(proxima);
        proxima.setAnterior(anterior);

        total--;
    }

    public void exibirLista() {

        Celula atual = inicio;

        System.out.print("[");

        while (atual != null) {

            System.out.print(atual.getDado());

            if (atual.getProxima() != null) {
                System.out.print(", ");
            }

            atual = atual.getProxima();
        }

        System.out.println("]");
    }
}