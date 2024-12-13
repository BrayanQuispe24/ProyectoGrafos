/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRAYAN
 * @param <G>
 */
public class Floyd<G extends Comparable<G>> {

    private GrafoPesado unGrafo;
    private double[][] matrizDePesos;
    private int[][] matrizDePredecesores;
    private final int cantidadVertices;

    public Floyd(GrafoPesado unGrafo) {
        this.unGrafo = unGrafo;
        this.cantidadVertices = unGrafo.cantidadDeVertices();
        this.matrizDePredecesores = new int[cantidadVertices][cantidadVertices];
        this.matrizDePesos = new double[cantidadVertices][cantidadVertices];
        this.llenarMatrizPesosValoresIniciales();
        this.iniciarMatrizPesos();
        this.iniciarMatrizDePredecesores();
        this.ejecutarFloyd();
    }

    private void ejecutarFloyd() {
        for (int k = 0; k < cantidadVertices; k++) {
            for (int i = 0; i < cantidadVertices; i++) {
                for (int j = 0; j < cantidadVertices; j++) {
                    if (i != j) {
                        if ((this.matrizDePesos[i][k] != Double.MAX_VALUE)
                                && (this.matrizDePesos[k][j] != Double.MAX_VALUE)) {
                            if (this.matrizDePesos[i][j] > (this.matrizDePesos[i][k] + this.matrizDePesos[k][j])) {
                                this.matrizDePesos[i][j] = this.matrizDePesos[i][k] + this.matrizDePesos[k][j];
                                this.matrizDePredecesores[i][j] = k;
                            }
                        }
                    }
                }
            }
        }
    }

    public double obtenerCaminoCostoMinimo(G verticeInicio, G verticeDestino) {
        int nroVerticeInicio = this.unGrafo.nroVertice(verticeInicio);
        int nroVerticeDestino = this.unGrafo.nroVertice(verticeDestino);
        return this.matrizDePesos[nroVerticeInicio][nroVerticeDestino];
    }

    /*public List<G> obtenerCamino(G verticeInicio, G verticeDestino) {
        List<G> caminoMasCorto = new ArrayList<>();
        int nroVerticeDestino = this.unGrafo.nroVertice(verticeDestino);

    }*/
    private void iniciarMatrizPesos() {
        for (int i = 0; i < cantidadVertices; i++) {
            List<AdyacenteConPeso> adyacentes = (List<AdyacenteConPeso>) this.unGrafo.listaDeAdyacencias.get(i);
            for (AdyacenteConPeso adyacenteActual : adyacentes) {
                int nroVerticeAdyacente = adyacenteActual.getNroVertice();
                this.matrizDePesos[i][nroVerticeAdyacente] = adyacenteActual.getPeso();
            }
        }
    }

    private void llenarMatrizPesosValoresIniciales() {
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                if (i != j) {
                    this.matrizDePesos[i][j] = Double.MAX_VALUE;
                } else {
                    this.matrizDePesos[i][j] = 0;
                }

            }
        }
    }

    private void iniciarMatrizDePredecesores() {
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                if (i != j) {
                    this.matrizDePredecesores[i][j] = j;
                } else {
                    this.matrizDePredecesores[i][j] = -1;
                }
            }
        }
    }

    public void imprimirMatrizPesos() {
        System.out.println("Matriz de Pesos:");
        for (int i = 0; i < matrizDePesos.length; i++) {
            for (int j = 0; j < matrizDePesos[i].length; j++) {
                // Formato para manejar valores especiales (como Double.MIN_VALUE)
                if (matrizDePesos[i][j] == Double.MIN_VALUE) {
                    System.out.print("INF "); // Representar infinito
                } else {
                    System.out.printf("%.2f ", matrizDePesos[i][j]); // Formatear a 2 decimales
                }
            }
            System.out.println();
        }
    }

    // Método para imprimir una matriz de tipo `int`
    public void imprimirMatrizPredecesores() {
        System.out.println("Matriz de Predecesores:");
        for (int i = 0; i < matrizDePredecesores.length; i++) {
            for (int j = 0; j < matrizDePredecesores[i].length; j++) {
                System.out.print(matrizDePredecesores[i][j] + " ");
            }
            System.out.println();
        }
    }

}
