
package agendaTelefonica;

public class TesteIntegracao {

    public static void main(String[] args) {

        // 1. Criando as quatro estruturas
        ListaEncadeada agenda = new ListaEncadeada();
        ListaDuplaEncadeada agendaDupla =
                new ListaDuplaEncadeada();

        PilhaContatos pilha = new PilhaContatos();
        FilaContatos fila = new FilaContatos();

        // 2. Criando contatos para os testes
        Contato zaine = new Contato(
                "Zaine", "1111-1111", "zaine@email.com");

        Contato livia = new Contato(
                "Lívia", "2222-2222", "livia@email.com");

        Contato mariadny = new Contato(
                "Mariadny", "3333-3333", "mariadny@email.com");

        // 3. Inserindo contatos nas duas listas
        agenda.inserirFim(zaine);
        agenda.inserirFim(livia);
        agenda.inserirFim(mariadny);

        agendaDupla.inserirFim(zaine);
        agendaDupla.inserirFim(livia);
        agendaDupla.inserirFim(mariadny);

        System.out.println("===== LISTA ENCADEADA =====");
        System.out.println(agenda.listarContatos());

        System.out.println("===== LISTA DUPLAMENTE ENCADEADA =====");
        System.out.println(agendaDupla.listarInicioFim());

        System.out.println("===== LISTA DUPLA: ORDEM INVERSA =====");
        System.out.println(agendaDupla.listarFimInicio());

        // 4. Pesquisando um contato
        Contato encontrado = agenda.pesquisarContato("Lívia");

        System.out.println("===== PESQUISA DE CONTATO =====");

        if (encontrado != null) {
            System.out.println("Contato encontrado: " + encontrado);
        } else {
            System.out.println("Contato não encontrado.");
        }

        // 5. Encontrando Lívia nas duas listas
        int posicao = agenda.buscarPosicao("2222-2222");
        int posicaoDupla = agendaDupla.buscarPosicao("2222-2222");

        // Removendo das duas listas e guardando na pilha
        if (posicao >= 0 && posicaoDupla >= 0) {

            Contato removido = agenda.removerPosicao(posicao);
            agendaDupla.removerPosicao(posicaoDupla);

            if (removido != null) {
                pilha.empilhar(removido);

                System.out.println("\nContato removido das listas "
                        + "e guardado na pilha:");
                System.out.println(removido);
            }
        }

        // 6. Adicionando contatos à fila de ligações
        Contato contatoFila = agenda.pesquisarContato("Zaine");

        if (contatoFila != null) {
            fila.enfileirar(contatoFila);
        }

        contatoFila = agenda.pesquisarContato("Mariadny");

        if (contatoFila != null) {
            fila.enfileirar(contatoFila);
        }

        System.out.println("\n===== PILHA DE CONTATOS REMOVIDOS =====");
        System.out.println(pilha.listar());

        System.out.println("===== FILA DE LIGAÇÕES =====");
        System.out.println(fila.listar());

        // 7. Retirando o contato do topo da pilha
        Contato recuperado = pilha.desempilhar();

        System.out.println("===== CONTATO RETIRADO DA PILHA =====");

        if (recuperado != null) {
            System.out.println(recuperado);
        } else {
            System.out.println("A pilha está vazia.");
        }

        // 8. Atendendo o primeiro contato da fila
        Contato atendido = fila.desenfileirar();

        System.out.println("\n===== PRIMEIRO CONTATO ATENDIDO =====");

        if (atendido != null) {
            System.out.println(atendido);
        } else {
            System.out.println("A fila está vazia.");
        }

        // 9. Conferindo o estado final das listas
        System.out.println("\n===== AGENDA FINAL =====");
        System.out.println(agenda.listarContatos());

        System.out.println("===== AGENDA DUPLA FINAL =====");
        System.out.println(agendaDupla.listarInicioFim());

        System.out.println("===== FILA APÓS ATENDIMENTO =====");
        System.out.println(fila.listar());

        System.out.println("===== TAMANHO DAS ESTRUTURAS =====");
        System.out.println("Lista encadeada: " + agenda.getTamanho());
        System.out.println("Lista dupla: " + agendaDupla.getTamanho());
        System.out.println("Pilha: " + pilha.getTamanho());
        System.out.println("Fila: " + fila.getTamanho());
    }
}
