package Grafo;

public class Main {
    public static void main(String args[]){
        Grafo g = new Grafo();
        Vertice v = g.inserirVertice("v1");
        Vertice h = g.inserirVertice("v2");
        Vertice i = g.inserirVertice("v3");

        g.removerVertice(v);

        g.mostrarVertices();
    }
}
