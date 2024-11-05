package AlgoritmosDinamicos.Coeficientes_Binomiales;

public class CoeficientesBinomiales {

    // Método para calcular coeficientes binomiales usando tabulación
    public static int binomialCoefficient(int n, int k) {
        int[][] binomial = new int[n + 1][k + 1];

        // Llenado de la tabla
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Condiciones base: C(n, 0) = 1 y C(n, n) = 1
                if (j == 0 || j == i) {
                    binomial[i][j] = 1;
                } else {
                    // Relación de recurrencia
                    binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j];
                }
            }
        }
        return binomial[n][k];
    }

    public static void main(String[] args) {
        int n = 5; // Cambiar para probar otros valores de n
        int k = 2; // Cambiar para probar otros valores de k

        System.out.println("El coeficiente binomial C(" + n + ", " + k + ") es: " + binomialCoefficient(n, k));
    }
}

