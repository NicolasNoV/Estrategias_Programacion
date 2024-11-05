package AlgoritmosVoraces.arbol_recubrimiento_min;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase para representar el grafo y ejecutar el Algoritmo de Kruskal
public class ArbolRecubrimientoMinimo {
    private int N; // Número de municipios
    private List<Arista> aristas;

    public ArbolRecubrimientoMinimo(int N) {
        this.N = N;
        this.aristas = new ArrayList<>();
    }

    public void agregarArista(int origen, int destino, int costo) {
        aristas.add(new Arista(origen, destino, costo));
    }

    // Encontrar el representante de un conjunto usando compresión de caminos
    private int encontrar(int[] padre, int i) {
        if (padre[i] != i) {
            padre[i] = encontrar(padre, padre[i]);
        }
        return padre[i];
    }

    // Unir dos conjuntos
    private void unir(int[] padre, int[] rango, int x, int y) {
        int raizX = encontrar(padre, x);
        int raizY = encontrar(padre, y);

        if (rango[raizX] < rango[raizY]) {
            padre[raizX] = raizY;
        } else if (rango[raizX] > rango[raizY]) {
            padre[raizY] = raizX;
        } else {
            padre[raizY] = raizX;
            rango[raizX]++;
        }
    }

    // Ejecutar el Algoritmo de Kruskal
    public void kruskalMST() {
        // Ordenar las aristas por costo ascendente
        Collections.sort(aristas);

        int[] padre = new int[N];
        int[] rango = new int[N];
        for (int i = 0; i < N; i++) {
            padre[i] = i;
            rango[i] = 0;
        }

        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        for (Arista arista : aristas) {
            int origen = arista.origen;
            int destino = arista.destino;

            int conjuntoOrigen = encontrar(padre, origen);
            int conjuntoDestino = encontrar(padre, destino);

            // Agregar la arista si no forma un ciclo
            if (conjuntoOrigen != conjuntoDestino) {
                resultado.add(arista);
                costoTotal += arista.costo;
                unir(padre, rango, conjuntoOrigen, conjuntoDestino);
            }
        }

        // Imprimir el MST y su costo total
        System.out.println("Aristas en el árbol de recubrimiento mínimo:");
        for (Arista arista : resultado) {
            System.out.println("Municipio " + arista.origen + " - Municipio " + arista.destino +
                    " con costo " + arista.costo);
        }
        System.out.println("Costo total del árbol de recubrimiento mínimo: " + costoTotal);
    }

    public static void main(String[] args) {
        // Ejemplo: Crear un grafo con 4 municipios
        ArbolRecubrimientoMinimo grafo = new ArbolRecubrimientoMinimo(4);

        // Agregar aristas con el formato (origen, destino, costo)
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 6);
        grafo.agregarArista(0, 3, 5);
        grafo.agregarArista(1, 3, 15);
        grafo.agregarArista(2, 3, 4);

        // Ejecutar el algoritmo de Kruskal
        grafo.kruskalMST();
    }
}
