package pilhaFila.projeto3;

public class Processo {
    int pid;
    String conteudo;

    public Processo(int pid, String conteudo) {
        this.pid = pid;
        this.conteudo = conteudo;
    }

    public void mostrar() {
        System.out.println("PID: " + pid + " | Conteudo: " + conteudo);
    }
}
