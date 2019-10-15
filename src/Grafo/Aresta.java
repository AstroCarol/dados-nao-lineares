package Grafo;

public class Aresta {
    private Vertice inicio;
    private Vertice fim;
    private boolean direcao;
    private String valor;

    public Aresta(Vertice inicio, Vertice fim){
        this.inicio = inicio;
        this.fim = fim;
        direcao = false;
    }

    public Aresta(Vertice inicio, Vertice fim, boolean direcao){
        this.inicio = inicio;
        this.fim = fim;
        this.direcao = direcao;
    }

    public void setInicio(Vertice inicio){
        this.inicio = inicio;
    }

    public Vertice getInicio(){
        return inicio;
    }

    public void setFim(Vertice fim){
        this.fim = fim;
    }

    public Vertice getFim(){
        return fim;
    }

    public void setDirecao(boolean direcao){
        this.direcao = direcao;
    }

    public boolean isDirecao(){
        return direcao;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public Boolean temVertice(Vertice n){
        return  inicio == fim || fim == inicio;
    }

    public String toString(){
        return "["+valor+"]";
    }

}
