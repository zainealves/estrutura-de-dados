package agendaTelefonica;

public class PilhaContatos {

    private No topo;
    private int tamanho;

    public PilhaContatos() {
        topo = null;
        tamanho = 0;
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    // Retorna a quantidade de contatos
    public int getTamanho() {
        return tamanho;
    }

    // Adiciona um contato ao topo
    public void empilhar(Contato contato) {
        No novoNo = new No(contato);

        novoNo.setProximo(topo);
        topo = novoNo;

        tamanho++;
    }

    // Remove e retorna o contato do topo
    public Contato desempilhar() {
        if (estaVazia()) {
            return null;
        }

        Contato removido = topo.getContato();

        topo = topo.getProximo();
        tamanho--;

        return removido;
    }

    // Consulta o contato do topo sem removê-lo
    public Contato topo() {
        if (estaVazia()) {
            return null;
        }

        return topo.getContato();
    }

    // Lista os contatos do topo até a base
    public String listar() {
        if (estaVazia()) {
            return "A pilha está vazia.";
        }

        StringBuilder resultado = new StringBuilder();
        No atual = topo;

        while (atual != null) {
            resultado.append(atual.getContato())
                    .append("\n");

            atual = atual.getProximo();
        }

        return resultado.toString();
    }
}


