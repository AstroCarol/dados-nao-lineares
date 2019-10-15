package Grafo;

import java.util.Vector;
import java.util.ArrayList;


public class Grafo {
    private int qtdVertices;
    private Vector vertices;
    private Aresta matrizAdj[][];
    public Grafo(){
        qtdVertices = 0;
        vertices = new Vector();
    }

    public void inserirVertice(Vertice v){
        vertices.add(v);
    }

    public void removerVertice(Vertice v){
        vertices.remove(v);
    }

    public void inserirAresta(Vertice inicio, Vertice fim){

    }

}
