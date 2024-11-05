package AlgoritmosDinamicos.Sucesion_Lucas;

public class lucasMemorizacion {

    // Array para almacenar resultados intermedios (memorización)
    private static int[] memo;

    // Método de programación dinámica por memorización
    public static int SucesionLucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        if (memo[n] == -1) {
            memo[n] = SucesionLucas(n - 1) + SucesionLucas(n - 2);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10; // Cambiar el valor de n para calcular el n-ésimo término de la sucesión de Lucas
        memo = new int[n + 1];

        // Inicializar todos los valores en -1 para indicar que no han sido calculados
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        System.out.println("Lucas(" + n + ") por memorización: " + SucesionLucas(n));
    }
}
