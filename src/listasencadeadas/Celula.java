package listasencadeadas;

public class Celula {

    private int dado;
    private Celula anterior;
    private Celula proxima;

    public Celula(int dado) {
        this.dado = dado;
        this.anterior = null;
        this.proxima = null;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }
}
