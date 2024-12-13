/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author BRAYAN
 * @param <G>
 */
public class DigrafoPesado<G extends Comparable<G>> extends GrafoPesado<G> {

    public DigrafoPesado() {
    }

    public DigrafoPesado(Iterable<G> vertices) {
        super(vertices);
    }

    @Override
    public int cantidadDeVertices() {
        //actualizar a digrafo
        return super.cantidadDeVertices();
    }

    @Override
    public void insertarArista(G verticeOrigen, G verticeDestino, double peso) {
        if (existeAdyacencia(verticeOrigen, verticeDestino)) {
            throw new Excepciones.ExcepcionAristaYaExiste();
        }
        int nroDelVerticeOrigen = nroVertice(verticeOrigen);
        int nroDelVerticeDestino = nroVertice(verticeDestino);
        AdyacenteConPeso adyacenteOrigen = new AdyacenteConPeso(nroDelVerticeDestino, peso);
        List<AdyacenteConPeso> adyacentesDelOrigen = listaDeAdyacencias.get(nroDelVerticeOrigen);
        adyacentesDelOrigen.add(adyacenteOrigen);
        Collections.sort(adyacentesDelOrigen);
    }

    @Override
    public void eliminarArista(G verticeOrigen, G verticeDestino) {
        // Verifica si existe la adyacencia antes de proceder
        if (!existeAdyacencia(verticeOrigen, verticeDestino)) {
            throw new IllegalArgumentException("La arista no existe en el grafo");
        }

        int nroOrigen = nroVertice(verticeOrigen);
        int nroDestino = nroVertice(verticeDestino);

        // Eliminar la arista de la lista de adyacencias de verticeOrigen
        List<AdyacenteConPeso> listaAdyacentesOrigen = listaDeAdyacencias.get(nroOrigen);
        AdyacenteConPeso adyacenteAEliminar = new AdyacenteConPeso(nroDestino);
        listaAdyacentesOrigen.remove(adyacenteAEliminar); // Eliminar por valor, no por índice
    }

    public int gradoDeSalidaDelVertice(G vertice) {
        return super.gradoDelVertice(vertice);
    }

    public int gradoDeEntradaDelVertice(G vertice) {
        int grado = 0;
        //para esto buscaremos por todo el grafo si algun vertice tiene
        super.validarVertice(vertice);
        int numeroVertice = super.nroVertice(vertice);
        for (List<AdyacenteConPeso> listaDeAdyacencia : listaDeAdyacencias) {
            AdyacenteConPeso adyacenteABuscar = new AdyacenteConPeso(numeroVertice);
            if (listaDeAdyacencia.contains(adyacenteABuscar)) {
                grado++;
            }
        }
        return grado;
    }
}
