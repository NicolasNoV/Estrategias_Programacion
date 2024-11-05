package AlgoritmosDinamicos.Mochila;

public class MochilaDinamica {
    public static int knapsack(int[] pesos, int[] valores, int capacidad) {
        int n = valores.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // El valor máximo está en dp[n][capacidad]
        System.out.println("n ="+n+" "+"capacidad ="+capacidad);
        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] valores = {2, 5, 10, 14, 15};
        int[] pesos = {1, 3, 4, 5, 7};
        int capacidad = 8;

        int maximoValor = knapsack(pesos, valores, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + maximoValor);
    }
}
