package agendaTelefonica;

public class NoDuplo {

    private Contato contato;
    private NoDuplo anterior;
    private NoDuplo proximo;

    public NoDuplo(Contato contato) {
        this.contato = contato;
        this.anterior = null;
        this.proximo = null;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }
}

