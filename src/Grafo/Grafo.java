package Grafo;

import java.util.Iterator;
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

    public void inserirVertice(Vertice v){
        vertices.add(v);
        qtdVertices++;
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

}
