package AlgoritmosDinamicos.Sucesion_Lucas;

public class lucasTabulacion {

    // Método de programación dinámica por tabulación
    public static int SucesionLucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int[] lucas = new int[n + 1];
        lucas[0] = 2;
        lucas[1] = 1;

        for (int i = 2; i <= n; i++) {
            lucas[i] = lucas[i - 1] + lucas[i - 2];
        }

        return lucas[n];
    }

    public static void main(String[] args) {
        int n = 10; // Cambiar el valor de n para calcular el n-ésimo término de la sucesión de Lucas
        System.out.println("Lucas(" + n + ") por tabulación: " + SucesionLucas(n));
    }
}

