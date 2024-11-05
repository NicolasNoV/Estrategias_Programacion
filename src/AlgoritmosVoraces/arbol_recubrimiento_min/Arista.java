package AlgoritmosVoraces.arbol_recubrimiento_min;

class Arista implements Comparable<Arista> {
    int origen, destino, costo;

    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.costo - otra.costo;
    }
}
