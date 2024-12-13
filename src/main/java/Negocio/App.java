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
public class App<G extends Comparable<G>> {

    private GrafoPesado<Ciudad> grafoCiudad;
    private List<Boleto> listaBoletos;

    public App() {
        this.grafoCiudad = new GrafoPesado();
        this.listaBoletos = new ArrayList<>();
    }

    public App(GrafoPesado<Ciudad> unGrafo) {
        this.grafoCiudad = unGrafo;
        this.listaBoletos = new ArrayList<>();

    }

    public App(List<Ciudad> listaDeCiudades) {
        for (Ciudad ciudadActual : listaDeCiudades) {
            this.grafoCiudad.insertarVertice(ciudadActual);
        }
    }

    public void insertarCiudad(Ciudad ciudad) {
        this.grafoCiudad.insertarVertice(ciudad);
    }

    public void insertarTramo(Ciudad ciudadDestino, Ciudad ciudadOrigen, double distancia) {
        this.grafoCiudad.insertarArista(ciudadOrigen, ciudadDestino, distancia);
    }

    public List<Ciudad> obtenerRutaMasCorta(Ciudad origen, Ciudad destino) {

        return null;
    }

    public List<Ciudad> obtenerRutaMasBarata(Ciudad origen, Ciudad destino) {
        return null;
    }

    public void crearBoleto(int numeroBoleto, String nombreCliente, String fecha,
            double precio, int distancia, String nombreCiudadOrigen,
            String nombreCiudadDestino, String ciudadesIntermedias) {
        Boleto nuevoBoleto = new Boleto(numeroBoleto, nombreCliente, fecha,
                precio, distancia, nombreCiudadOrigen,
                nombreCiudadDestino, ciudadesIntermedias);
        this.listaBoletos.add(nuevoBoleto);
    }

    public String mostrarMapa() {
        return "";
    }

    public String mostrarGrafoCiudad() {
        return this.grafoCiudad.toString();
    }
}
