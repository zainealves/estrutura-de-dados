
package agendaTelefonica;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    // As quatro estruturas do projeto
    private static final ListaEncadeada agenda =
            new ListaEncadeada();

    private static final ListaDuplaEncadeada agendaDupla =
            new ListaDuplaEncadeada();

    private static final PilhaContatos pilha =
            new PilhaContatos();

    private static final FilaContatos fila =
            new FilaContatos();

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarContato();
                    break;

                case 2:
                    listarContatos();
                    break;

                case 3:
                    pesquisarContato();
                    break;

                case 4:
                    removerContato();
                    break;

                case 5:
                    recuperarContato();
                    break;

                case 6:
                    adicionarFila();
                    break;

                case 7:
                    atenderFila();
                    break;

                case 8:
                    exibirPilha();
                    break;

                case 9:
                    exibirFila();
                    break;

                case 10:
                    listarListaDuplaInversa();
                    break;

                case 11:
                    listarTamanhos();
                    break;

                case 0:
                    System.out.println(
                            "Encerrando a Agenda Telefônica...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }

    // Exibe as opções do sistema
    private static void exibirMenu() {
        System.out.println("================================");
        System.out.println("       AGENDA TELEFÔNICA");
        System.out.println("================================");
        System.out.println("1 - Cadastrar contato");
        System.out.println("2 - Listar contatos");
        System.out.println("3 - Pesquisar contato");
        System.out.println("4 - Remover contato");
        System.out.println("5 - Recuperar último contato removido");
        System.out.println("6 - Adicionar contato à fila de ligações");
        System.out.println("7 - Atender próximo contato da fila");
        System.out.println("8 - Exibir pilha de removidos");
        System.out.println("9 - Exibir fila de ligações");
        System.out.println("10 - Listar contatos em ordem inversa");
        System.out.println("11 - Mostrar tamanho das estruturas");
        System.out.println("0 - Sair");
        System.out.println("================================");
    }

    // Lê um número inteiro sem encerrar o programa
    // quando o usuário digitar algo inválido
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.nextLine();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }

    // Cadastra nas duas listas
    private static void cadastrarContato() {
        System.out.println("\n--- CADASTRAR CONTATO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();

        System.out.print("E-mail: ");
        String email = scanner.nextLine().trim();

        if (nome.isEmpty() || telefone.isEmpty()
                || email.isEmpty()) {
            System.out.println(
                    "Preencha todos os campos.");
            return;
        }

        // Evita cadastrar o mesmo telefone novamente
        if (agenda.buscarPosicao(telefone) >= 0) {
            System.out.println(
                    "Já existe um contato com esse telefone.");
            return;
        }

        Contato novoContato =
                new Contato(nome, telefone, email);

        agenda.inserirFim(novoContato);
        agendaDupla.inserirFim(novoContato);

        System.out.println(
                "Contato cadastrado com sucesso!");
    }

    // Lista os contatos da agenda
    private static void listarContatos() {
        System.out.println("\n--- LISTA ENCADEADA ---");
        System.out.println(agenda.listarContatos());

        System.out.println("--- LISTA DUPLAMENTE ENCADEADA ---");
        System.out.println(agendaDupla.listarInicioFim());
    }

    // Pesquisa pelo nome ou telefone
    private static void pesquisarContato() {
        System.out.println("\n--- PESQUISAR CONTATO ---");

        System.out.print("Digite o nome ou telefone: ");
        String termo = scanner.nextLine().trim();

        Contato encontrado =
                agenda.pesquisarContato(termo);

        if (encontrado != null) {
            System.out.println("Contato encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println(
                    "Contato não encontrado.");
        }
    }

    // Remove das duas listas e guarda na pilha
    private static void removerContato() {
        System.out.println("\n--- REMOVER CONTATO ---");

        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine().trim();

        int posicao = agenda.buscarPosicao(telefone);
        int posicaoDupla =
                agendaDupla.buscarPosicao(telefone);

        if (posicao < 0 || posicaoDupla < 0) {
            System.out.println(
                    "Contato não encontrado nas duas listas. "
                    + "Nenhuma alteração foi feita.");
            return;
        }

        // Confere se as duas listas apontam para
        // o mesmo contato antes de alterar qualquer uma
        Contato contatoPrincipal =
                agenda.buscarPorPosicao(posicao);

        Contato contatoDuplo =
                agendaDupla.buscarPorPosicao(posicaoDupla);

        if (contatoPrincipal == null
                || contatoDuplo == null
                || !contatoPrincipal.getTelefone()
                        .equals(contatoDuplo.getTelefone())) {
            System.out.println(
                    "As listas estão inconsistentes. "
                    + "A remoção foi cancelada.");
            return;
        }

        Contato removido = agenda.removerPosicao(posicao);
        Contato removidoDuplo =
                agendaDupla.removerPosicao(posicaoDupla);

        if (removido != null && removidoDuplo != null) {
            pilha.empilhar(removido);

            System.out.println(
                    "Contato removido e guardado na pilha:");
            System.out.println(removido);
        } else {
            System.out.println(
                    "Não foi possível concluir a remoção.");
        }
    }

    // Recupera o contato mais recentemente removido
    private static void recuperarContato() {
        System.out.println(
                "\n--- RECUPERAR CONTATO REMOVIDO ---");

        if (pilha.estaVazia()) {
            System.out.println(
                    "Não há contatos na pilha.");
            return;
        }

        Contato contato = pilha.topo();

        // Evita duplicar o telefone nas listas
        if (agenda.buscarPosicao(contato.getTelefone()) >= 0
                || agendaDupla.buscarPosicao(
                        contato.getTelefone()) >= 0) {
            System.out.println(
                    "Esse telefone já está cadastrado. "
                    + "O contato permanece na pilha.");
            return;
        }

        // Retira da pilha e reintegra às duas listas
        Contato recuperado = pilha.desempilhar();

        if (recuperado != null) {
            agenda.inserirFim(recuperado);
            agendaDupla.inserirFim(recuperado);

            System.out.println(
                    "Contato recuperado com sucesso:");
            System.out.println(recuperado);
        }
    }

    // Adiciona um contato existente à fila
    private static void adicionarFila() {
        System.out.println(
                "\n--- ADICIONAR À FILA DE LIGAÇÕES ---");

        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine().trim();

        Contato contato =
                agenda.pesquisarContato(telefone);

        if (contato == null) {
            System.out.println(
                    "Contato não encontrado na agenda.");
            return;
        }

        fila.enfileirar(contato);

        System.out.println(
                "Contato adicionado à fila:");
        System.out.println(contato);
    }

    // Atende o primeiro contato da fila
    private static void atenderFila() {
        System.out.println(
                "\n--- ATENDER PRÓXIMO CONTATO ---");

        Contato atendido = fila.desenfileirar();

        if (atendido == null) {
            System.out.println(
                    "Não há contatos aguardando na fila.");
        } else {
            System.out.println(
                    "Contato atendido:");
            System.out.println(atendido);
        }
    }

    // Exibe a pilha
    private static void exibirPilha() {
        System.out.println(
                "\n--- PILHA DE CONTATOS REMOVIDOS ---");
        System.out.println(pilha.listar());
    }

    // Exibe a fila
    private static void exibirFila() {
        System.out.println(
                "\n--- FILA DE LIGAÇÕES ---");
        System.out.println(fila.listar());
    }

    // Percorre a lista dupla do fim para o início
    private static void listarListaDuplaInversa() {
        System.out.println(
                "\n--- CONTATOS EM ORDEM INVERSA ---");
        System.out.println(agendaDupla.listarFimInicio());
    }

    // Exibe a quantidade de elementos
    private static void listarTamanhos() {
        System.out.println("\n--- TAMANHO DAS ESTRUTURAS ---");

        System.out.println(
                "Lista encadeada: " + agenda.getTamanho());

        System.out.println(
                "Lista dupla: " + agendaDupla.getTamanho());

        System.out.println(
                "Pilha: " + pilha.getTamanho());

        System.out.println(
                "Fila: " + fila.getTamanho());
    }
}
