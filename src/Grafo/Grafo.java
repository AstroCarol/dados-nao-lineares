package Grafo;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;


public class Grafo {
    private int qtdVertices, indice1, indice2;
    private Vector vertices;
    private Aresta matrizAdj[][];
    public Grafo(){
        qtdVertices = 0;
        vertices = new Vector();
    }

    public Vertice inserirVertice(String g){
        Vertice v = new Vertice(g, "");
        vertices.add(v);
        qtdVertices++;
        return v;
    }

    public void removerVertice(Vertice v){
        vertices.remove(v);
        qtdVertices--;
    }

    public void inserirAresta(Vertice inicio, Vertice fim){
        Aresta a = new Aresta(inicio, fim);
        int indice1 = buscar(inicio.getChave());
        int indice2 = buscar(fim.getChave());
        matrizAdj[indice1][indice2] = matrizAdj[indice2][indice1] = a;
    }

    public void removerAresta(Vertice inicio, Vertice fim){
        int indice1 = buscar(inicio.getChave());
        int indice2 = buscar(fim.getChave());
        matrizAdj[indice1][indice2] = matrizAdj [indice2][indice1] = null;
    }

    public void inserirLaco(Vertice inicio, Vertice fim){
        Aresta a = new Aresta(inicio, fim);
        int indice1 = buscar(inicio.getChave());
        int indice2 = buscar(fim.getChave());
        matrizAdj[indice1][indice2] = a;
    }

    public void removerLaco(Vertice inicio, Vertice fim){
        int indice1 = buscar(inicio.getChave());
        int indice2 = buscar(fim.getChave());
        matrizAdj[indice1][indice2] = null;
    }

    public void inserirArestaAdjacente(Vertice inicio, Vertice fim){

    }

    public void removerArestaAdjacente(Vertice inicio, Vertice fim){

    }

    public List<Vertice> getVertice(){
        return vertices;
    }

    private int buscar(String chave){
        Iterator i = vertices.iterator();
        int ind =  0;
        while (i.hasNext()){
            Vertice v = (Vertice)(i.next());
            if(v.getChave()==chave)
                return ind;
            ind++;
        }
        return -1;
    }

    public void mostrarVertices(){
        for (int i = 0; i < vertices.size(); i++){
            System.out.print(vertices.elementAt(i)+",");
        }
    }

    public void mostrarMatriz(){
        for (int i = 0; i < qtdVertices; i++){
            for (int j = 0; j < qtdVertices; j++){
                System.out.print(matrizAdj[i][j]+" ");
            }
            System.out.println();
        }
    }
}
