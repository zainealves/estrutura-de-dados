package agendaTelefonica;

public class ListaEncadeada {

    private No inicio;
    private int tamanho;

    public ListaEncadeada() {
        inicio = null;
        tamanho = 0;
    }

    // Verifica se a lista está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // Retorna a quantidade de contatos
    public int getTamanho() {
        return tamanho;
    }

    // Insere um contato no início
    public void inserirInicio(Contato contato) {
        No novoNo = new No(contato);

        novoNo.setProximo(inicio);
        inicio = novoNo;

        tamanho++;
    }

    // Insere um contato no fim
    public void inserirFim(Contato contato) {
        No novoNo = new No(contato);

        if (estaVazia()) {
            inicio = novoNo;
        } else {
            No atual = inicio;

            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }

            atual.setProximo(novoNo);
        }

        tamanho++;
    }

    // Insere um contato em uma posição específica
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

        No novoNo = new No(contato);
        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);

        tamanho++;
        return true;
    }

    // Remove o contato do início
    public Contato removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Contato removido = inicio.getContato();
        inicio = inicio.getProximo();

        tamanho--;
        return removido;
    }

    // Remove o contato do fim
    public Contato removerFim() {
        if (estaVazia()) {
            return null;
        }

        if (tamanho == 1) {
            return removerInicio();
        }

        No atual = inicio;

        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }

        Contato removido = atual.getProximo().getContato();
        atual.setProximo(null);

        tamanho--;
        return removido;
    }

    // Remove um contato de uma posição específica
    public Contato removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        Contato removido = atual.getProximo().getContato();

        atual.setProximo(atual.getProximo().getProximo());

        tamanho--;
        return removido;
    }

    // Retorna o contato de uma posição
    public Contato buscarPorPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        No atual = inicio;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual.getContato();
    }

    // Retorna a posição de um contato pelo telefone
    public int buscarPosicao(String telefone) {
        No atual = inicio;
        int posicao = 0;

        while (atual != null) {
            if (atual.getContato().getTelefone()
                    .equals(telefone)) {
                return posicao;
            }

            atual = atual.getProximo();
            posicao++;
        }

        return -1;
    }

   
    public Contato pesquisarContato(String termo) {
        if (termo == null) {
            return null;
        }

        No atual = inicio;

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

    // Lista todos os contatos
    public String listarContatos() {
        if (estaVazia()) {
            return "A agenda está vazia.";
        }

        StringBuilder resultado = new StringBuilder();
        No atual = inicio;
        int posicao = 0;

        while (atual != null) {
            resultado.append("Posição ")
                    .append(posicao)
                    .append(": ")
                    .append(atual.getContato())
                    .append("\n");

            atual = atual.getProximo();
            posicao++;
        }

        return resultado.toString();
    }

}