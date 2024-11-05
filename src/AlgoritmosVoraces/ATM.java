package AlgoritmosVoraces;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    // Definir las denominaciones de billetes y su disponibilidad en el cajero
    static int[] denominaciones = {100000, 50000, 20000, 10000};
    static int[] cantidadDisponible = {50, 100, 200, 300};

    public static Map<Integer, Integer> calcularBilletes(int monto) {
        Map<Integer, Integer> billetesEntregados = new HashMap<>();

        // Verificar que el monto sea múltiplo de 10000
        if (monto % 10000 != 0) {
            System.out.println("El monto solicitado debe ser divisible por 10000.");
            return null;
        }

        // Iterar sobre las denominaciones en orden descendente
        for (int i = 0; i < denominaciones.length; i++) {
            int billete = denominaciones[i];
            int cantidad = cantidadDisponible[i];

            // Calcular cuántos billetes de esta denominación podemos usar
            int cantidadNecesaria = monto / billete;
            int billetesAEntregar = Math.min(cantidadNecesaria, cantidad);

            // Actualizar el monto restante
            monto -= billetesAEntregar * billete;

            // Almacenar el número de billetes entregados
            billetesEntregados.put(billete, billetesAEntregar);

            // Si ya hemos cumplido con el monto, terminamos
            if (monto == 0) {
                break;
            }
        }

        // Si aún queda monto por entregar, no es posible satisfacer la solicitud
        if (monto > 0) {
            System.out.println("No hay suficiente cantidad de billetes para entregar el monto solicitado.");
            return null;
        }

        return billetesEntregados;
    }

    public static void main(String[] args) {
        int montoSolicitado = 370000;  // Ejemplo de monto solicitado
        Map<Integer, Integer> resultado = calcularBilletes(montoSolicitado);

        if (resultado != null) {
            System.out.println("Billetes entregados:");
            for (Map.Entry<Integer, Integer> entrada : resultado.entrySet()) {
                System.out.println("Denominación: " + entrada.getKey() + " - Cantidad: " + entrada.getValue());
            }
        }
    }
}

