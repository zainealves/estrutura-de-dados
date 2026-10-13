package agendaTelefonica;

public class FilaContatos {

    private No inicio;
    private No fim;
    private int tamanho;

    public FilaContatos() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    // Verifica se a fila está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // Retorna a quantidade de contatos
    public int getTamanho() {
        return tamanho;
    }

    // Adiciona um contato ao fim da fila
    public void enfileirar(Contato contato) {
        No novoNo = new No(contato);

        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }

        tamanho++;
    }

    // Remove e retorna o primeiro contato
    public Contato desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        Contato removido = inicio.getContato();

        inicio = inicio.getProximo();
        tamanho--;

        if (inicio == null) {
            fim = null;
        }

        return removido;
    }

    // Consulta o primeiro contato sem removê-lo
    public Contato primeiro() {
        if (estaVazia()) {
            return null;
        }

        return inicio.getContato();
    }

    // Lista os contatos na ordem de atendimento
    public String listar() {
        if (estaVazia()) {
            return "A fila está vazia.";
        }

        StringBuilder resultado = new StringBuilder();
        No atual = inicio;
        int posicao = 1;

        while (atual != null) {
            resultado.append(posicao)
                    .append("º - ")
                    .append(atual.getContato())
                    .append("\n");

            atual = atual.getProximo();
            posicao++;
        }

        return resultado.toString();
    }
}

