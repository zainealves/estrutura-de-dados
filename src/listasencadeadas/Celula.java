package listasencadeadas;

public class Celula {
    private Celula proxima;
    private int elemento;

    public Celula (){
        
    }

    public Celula(int elemento) {
        this.elemento = elemento;
    }

    public Celula(Celula proxima, int elemento) {
        this.proxima = proxima;
        this.elemento = elemento;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

}
    

