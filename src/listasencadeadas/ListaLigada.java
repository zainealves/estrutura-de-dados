package listasencadeadas;

public class ListaLigada {
    public ListaLigada(Celula cabeca, Celula cauda) {
        this.cabeca = cabeca;
        this.cauda = cauda;
    }
    public ListaLigada() {
    }
    private Celula cabeca;
    private Celula cauda;
    private int tamanho=0;
    
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public Celula getCabeca() {
        return cabeca;
    }
    public void setCabeca(Celula cabeca) {
        this.cabeca = cabeca;
    }
    public Celula getCauda() {
        return cauda;
    }
    public void setCauda(Celula cauda) {
        this.cauda = cauda;
    }
    

    
    
    public void inserir(int valor){
        Celula novaCelula = new Celula(valor);

        if (cabeca==null){
            cabeca = novaCelula;
            cauda = novaCelula;

        } else {
            cauda.setProxima(novaCelula);
            cauda = novaCelula;

        }
        this.tamanho++;


    }
    public void inserirNoComeco(int valor){
        Celula novaCelula = new Celula(valor);

        if (cabeca==null){
            cabeca = novaCelula;
            cauda = novaCelula;

        } else{
            novaCelula.setProxima(cabeca);
            cabeca = novaCelula;
        }
        this.tamanho++;

    }

    public void inserirPorPosicao(int valor, int posicao){
        Celula novaCelula = new Celula(valor);

        if (posicao == 0){
            inserir(valor);
        }else{
            Celula prx = cabeca;
            for(int i=0;i<posicao-1;i++ ){
                prx = prx.getProxima();
            }
            novaCelula.setProxima(prx.getProxima());
            prx.setProxima(novaCelula);
        }
    }

    public void removerDoInicio(int posicao){
        cabeca = cabeca.getProxima();
        this.tamanho--;
        if (cabeca == null){
            cauda = null;
        }

        /*Celula aux = this.cabeca;
        this.cabeca = this.cabeca.getProxima();
        aux = setProximo(proximo:null);
        this.tamanho--; */
    }

    public void removerDoFim(int posicao){
        Celula aux = this.cabeca;
        for(int i = 0; i<tamanho-2;i++){
            aux = aux.getProxima();
        }
        aux.setProxima(null);
        this.cauda = aux;
        this.tamanho--;
    }

    public void removerPorPosicao(int posicao){
        if (posicao<0 || posicao>=tamanho){
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao==0){
            removerDoInicio(posicao);
        }else if(posicao == tamanho-1){
            removerDoFim(posicao);
        }else{
            Celula aux = this.cabeca;
            for (int i = 0; i<posicao-1;i++){
                aux = aux.getProxima();

            }
            Celula removida = aux.getProxima();
            aux.setProxima(aux.getProxima().getProxima());
            removida.setProxima(null);
            this.tamanho--;
        }

    }
    public String toString(){
        if(this.tamanho==0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Celula aux = this.cabeca;
        for (int i = 0;i<this.tamanho-1;i++){
            sb.append(aux.getElemento());
            sb.append(",");
            aux = aux.getProxima();
        }

        sb.append(aux.getElemento());
        sb.append("]");
        return sb.toString();
    }


    
}