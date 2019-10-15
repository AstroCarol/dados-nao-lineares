package Grafo;

public class Vertice {
    private String chave;
    private String valor;
    private int grau_no;

    public Vertice(String chave, String valor){
        this.chave = chave;
        this.valor = valor;
    }

    public void setChave(String chave){
        this.chave = chave;
    }

    public String getChave(){
        return chave;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }

    public void setGrau_no(int grau_no){
        this.grau_no = grau_no;
    }

    public int getGrau_no(){
        return grau_no;
    }

}
