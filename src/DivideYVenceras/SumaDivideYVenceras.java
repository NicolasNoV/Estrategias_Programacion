package DivideYVenceras;

public class SumaDivideYVenceras {

    public static int sumaDivideYVenceras(int[] arr, int inicio, int fin) {
        // Caso base: Si el arreglo tiene un solo elemento, devolver ese elemento
        if (inicio == fin) {
            return arr[inicio];
        }

        // Calcular el punto medio para dividir el arreglo en dos mitades
        int mitad = (inicio + fin) / 2;

        // Aplicar recursividad para las dos mitades
        int sumaIzquierda = sumaDivideYVenceras(arr, inicio, mitad);
        int sumaDerecha = sumaDivideYVenceras(arr, mitad + 1, fin);

        // Combinar los resultados de las mitades
        return sumaIzquierda + sumaDerecha;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int sumaTotal = sumaDivideYVenceras(arr, 0, arr.length - 1);
        System.out.println("La suma total de los elementos es: " + sumaTotal);
    }
}

