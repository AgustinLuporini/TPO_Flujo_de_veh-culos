public class Arista implements Comparable<Arista> {
    private Vertice origen;
    private Vertice destino;
    private int peso;

    public Arista(Vertice origen, Vertice destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino() {
        return this.destino;
    }

    public int getPeso() {
        return this.peso;
    }

    public Vertice getOrigen(){return this.origen;}



    public int compareTo(Arista otra) {
        return Integer.compare(otra.getPeso(), this.peso);
    }

}

