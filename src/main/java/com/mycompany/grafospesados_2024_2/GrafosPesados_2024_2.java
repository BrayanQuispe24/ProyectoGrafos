/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.grafospesados_2024_2;

import Negocio.App;
import Negocio.Ciudad;

/**
 *
 * @author BRAYAN
 */
public class GrafosPesados_2024_2 {

    public static void main(String[] args) {
        App nuevaApp = new App();
        Ciudad ciudad1 = new Ciudad("Santa Cruz");
        Ciudad ciudad2 = new Ciudad("Cochabamba");
        Ciudad ciudad3 = new Ciudad("Tarija");
        Ciudad ciudad4 = new Ciudad("Oruro");
        nuevaApp.insertarCiudad(ciudad1);
        nuevaApp.insertarCiudad(ciudad2);
        nuevaApp.insertarCiudad(ciudad3);
        nuevaApp.insertarCiudad(ciudad4);
        //nuevaApp.insertarCiudad(ciudad4);
        //nuevaApp.insertarCiudad(9);
        nuevaApp.insertarTramo(ciudad1, ciudad4, 150);
        nuevaApp.insertarTramo(ciudad1, ciudad2, 180);
        nuevaApp.insertarTramo(ciudad4, ciudad2, 200);
        nuevaApp.insertarTramo(ciudad3, ciudad1, 500);
        System.out.println(nuevaApp.mostrarGrafoCiudad());
        //unGrafo.eliminarVertice(5);
        //System.out.println(unGrafo.toString());
        // unGrafo.insertarArista(8, 9, 14);
        /* System.out.println(unGrafo.toString());
        DFS nuevoRecorrido = new DFS(unGrafo, 5);
        System.out.println(nuevoRecorrido.obtenerRecorrido());
        BFS nuevoRecorrido2 = new BFS(unGrafo, 5);
        System.out.println(nuevoRecorrido2.getRecorrido());
        System.out.println(unGrafo.getPesoArista(5, 9));
        Dijkstra algoritmo = new Dijkstra(unGrafo, 5, 7);
        System.out.println(algoritmo.vectorCostos);
        System.out.println(algoritmo.predecesores);
        System.out.println(algoritmo.CaminoMasCorto);
        System.out.println(algoritmo.getCostoCaminoMasCorto());*/
 /*Kruskal nuevoAlgoritmo=new Kruskal(unGrafo);
        System.out.println(nuevoAlgoritmo.mostrarListaAristas());
        System.out.println(nuevoAlgoritmo.toString());*/
 /*Prim algoritmoPrim=new Prim(unGrafo);
        System.out.println(algoritmoPrim.obtenerGrafoResultado().toString());
        System.out.println(algoritmoPrim.obtenerPesoTotal());*/
 /* Floyd algoritmo = new Floyd(unGrafo);
        algoritmo.imprimirMatrizPesos();
        algoritmo.imprimirMatrizPredecesores();*/
 /*HayCicloDFS ciclo= new HayCicloDFS(unGrafo,5);
        System.out.println(ciclo.hayCiclo());*/
    }
}
