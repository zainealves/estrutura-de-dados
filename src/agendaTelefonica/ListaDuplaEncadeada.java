package agendaTelefonica;

public class ListaDuplaEncadeada {

    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;

    public ListaDuplaEncadeada() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    // Inserir no início
    public void inserirInicio(Contato contato) {
        NoDuplo novo = new NoDuplo(contato);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }

        tamanho++;
    }

    // Inserir no fim
    public void inserirFim(Contato contato) {
        NoDuplo novo = new NoDuplo(contato);

        if (estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnterior(fim);
            fim.setProximo(novo);
            fim = novo;
        }

        tamanho++;
    }

    // Inserir em uma posição
    public boolean inserirPosicao(int posicao, Contato contato) {
        if (posicao < 0 || posicao > tamanho) {
            return false;
        }

        if (posicao == 0) {
            inserirInicio(contato);
            return true;
        }

        if (posicao == tamanho) {
            inserirFim(contato);
            return true;
        }

        NoDuplo atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        NoDuplo novo = new NoDuplo(contato);
        NoDuplo anterior = atual.getAnterior();

        novo.setAnterior(anterior);
        novo.setProximo(atual);
        anterior.setProximo(novo);
        atual.setAnterior(novo);

        tamanho++;
        return true;
    }

    // Remover do início
    public Contato removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Contato removido = inicio.getContato();

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        tamanho--;
        return removido;
    }

    // Remover do fim
    public Contato removerFim() {
        if (estaVazia()) {
            return null;
        }

        Contato removido = fim.getContato();

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }

        tamanho--;
        return removido;
    }

    // Remover de uma posição
    public Contato removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        if (posicao == tamanho - 1) {
            return removerFim();
        }

        NoDuplo atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        atual.getAnterior().setProximo(atual.getProximo());
        atual.getProximo().setAnterior(atual.getAnterior());

        tamanho--;
        return atual.getContato();
    }

    // Buscar por posição
    public Contato buscarPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        NoDuplo atual;

        // Começa pelo lado mais próximo
        if (posicao < tamanho / 2) {
            atual = inicio;

            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
        } else {
            atual = fim;

            for (int i = tamanho - 1; i > posicao; i--) {
                atual = atual.getAnterior();
            }
        }

        return atual.getContato();
    }

    // Buscar posição pelo telefone
    public int buscarPosicao(String telefone) {
        NoDuplo atual = inicio;
        int posicao = 0;

        while (atual != null) {
            if (atual.getContato().getTelefone().equals(telefone)) {
                return posicao;
            }

            atual = atual.getProximo();
            posicao++;
        }

        return -1;
    }

    // Pesquisar por nome ou telefone
    public Contato pesquisarContato(String termo) {
        if (termo == null) {
            return null;
        }

        NoDuplo atual = inicio;

        while (atual != null) {
            Contato contato = atual.getContato();

            if (contato.getNome().equalsIgnoreCase(termo)
                    || contato.getTelefone().equals(termo)) {
                return contato;
            }

            atual = atual.getProximo();
        }

        return null;
    }

    // Listar do início para o fim
    public String listarInicioFim() {
        if (estaVazia()) {
            return "A lista está vazia.";
        }

        StringBuilder resultado = new StringBuilder();
        NoDuplo atual = inicio;
        int posicao = 0;

        while (atual != null) {
            resultado.append(posicao)
                    .append(" - ")
                    .append(atual.getContato())
                    .append("\n");

            atual = atual.getProximo();
            posicao++;
        }

        return resultado.toString();
    }

    // Listar do fim para o início
    public String listarFimInicio() {
        if (estaVazia()) {
            return "A lista está vazia.";
        }

        StringBuilder resultado = new StringBuilder();
        NoDuplo atual = fim;
        int posicao = tamanho - 1;

        while (atual != null) {
            resultado.append(posicao)
                    .append(" - ")
                    .append(atual.getContato())
                    .append("\n");

            atual = atual.getAnterior();
            posicao--;
        }

        return resultado.toString();
    }
}

