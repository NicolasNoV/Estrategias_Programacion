package AlgoritmosVoraces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Objeto {
    double peso;
    double valor;

    Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class Mochila {

    public static double llenarMochila(List<Objeto> objetos, double pesoMaximo, Comparator<Objeto> criterio) {
        // Ordenar los objetos según el criterio seleccionado
        Collections.sort(objetos, criterio);

        double pesoActual = 0;
        double valorTotal = 0;

        System.out.println("Objetos seleccionados:");
        for (Objeto objeto : objetos) {
            if (pesoActual + objeto.peso <= pesoMaximo) {
                // Agregar el objeto completo
                pesoActual += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println("Peso: " + objeto.peso + ", Valor: " + objeto.valor);
            } else {
                // Agregar la fracción del objeto que cabe
                double pesoRestante = pesoMaximo - pesoActual;
                double fraccion = pesoRestante / objeto.peso;
                valorTotal += objeto.valor * fraccion;
                pesoActual += objeto.peso * fraccion;
                System.out.println("Peso fraccionado: " + (objeto.peso * fraccion) + ", Valor fraccionado: " + (objeto.valor * fraccion));
                break;
            }
        }

        return valorTotal;
    }

    public static void main(String[] args) {
        // Ejemplo de objetos con peso y valor
        List<Objeto> objetos = new ArrayList<>();
        objetos.add(new Objeto(10, 60));
        objetos.add(new Objeto(20, 100));
        objetos.add(new Objeto(30, 120));

        double pesoMaximo = 50;

        // Heurística 1: Seleccionar el objeto más valioso
        System.out.println("\nHeurística 1: Seleccionar el objeto más valioso");
        double valor1 = llenarMochila(objetos, pesoMaximo, Comparator.comparingDouble((Objeto o) -> -o.valor));
        System.out.println("Valor total de la carga: " + valor1);

        // Heurística 2: Seleccionar el objeto más ligero
        System.out.println("\nHeurística 2: Seleccionar el objeto más ligero");
        double valor2 = llenarMochila(objetos, pesoMaximo, Comparator.comparingDouble((Objeto o) -> o.peso));
        System.out.println("Valor total de la carga: " + valor2);

        // Heurística 3: Seleccionar el objeto con el mayor valor por unidad de peso
        System.out.println("\nHeurística 3: Seleccionar el objeto con el mayor valor por unidad de peso");
        double valor3 = llenarMochila(objetos, pesoMaximo, Comparator.comparingDouble((Objeto o) -> -(o.valor / o.peso)));
        System.out.println("Valor total de la carga: " + valor3);
    }
}

