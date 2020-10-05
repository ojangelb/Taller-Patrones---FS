package fabrica.comun;

public class Arco {

    private Nodo origen;
    private Nodo destino;
    private int peso;

    public Arco() {
    }

    public Nodo getOrigen() {
        return this.origen;
    }

    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    public Nodo getDestino() {
        return this.destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
