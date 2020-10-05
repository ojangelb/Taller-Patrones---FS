package fabrica.grafo;

import fabrica.busqueda.BusquedaBFS;
import fabrica.busqueda.BusquedaDFS;
import fabrica.busqueda.IBusqueda;
import fabrica.comun.Arco;
import fabrica.comun.Nodo;


import java.util.*;

public class GDirigidoImpl implements IGrafo {
    List<Nodo> nodos = new ArrayList();
    List<Arco> arcos = new ArrayList();
    private static IBusqueda busqueda;



    private void setEstrategia(String estrategia) {

        if (estrategia.equals("BFS")) {
            busqueda = new BusquedaBFS();
        } else {
            if (!estrategia.equals("DFS")) {
                throw new RuntimeException("Configuración Invalida");
            }

            busqueda = new BusquedaDFS();
        }

    }

    public void addNodo(String nombre) {
        Nodo nodo = new Nodo();
        nodo.setNombre(nombre);
        this.nodos.add(nodo);
    }

    public void addArco(String origen, String destino) throws Exception {
        Nodo nodoOrigen = this.buscarNodo(origen);
        Nodo nodoDestino = this.buscarNodo(destino);
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Busqueda: NodoOrigen no encontrado");
        } else if (nodoDestino == null) {
            throw new RuntimeException("Error en la Busqueda: NodoOrigen no encontrado");
        } else {
            Arco arco = new Arco();
            arco.setOrigen(nodoOrigen);
            arco.setDestino(nodoDestino);
            this.arcos.add(arco);
            nodoOrigen.agregarArco(arco);
        }
    }

    public Nodo buscarNodo(String nombre) {
        Iterator var3 = this.nodos.iterator();

        while(var3.hasNext()) {
            Nodo nodo = (Nodo)var3.next();
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }

        return null;
    }

    public boolean existeRuta(String origen, String destino) throws Exception {
        return this.buscarRuta(origen, destino) != null;
    }

    public List<Nodo> buscarRuta(String origen, String destino) throws Exception {
        Nodo nodoOrigen = this.buscarNodo(origen);
        Nodo nodoDestino = this.buscarNodo(destino);
        List<Nodo> nodosRuta = new ArrayList();
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        } else if (nodoDestino == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        } else {
            if (busqueda == null) {
                this.setEstrategia("DFS");
            }

            return busqueda.buscarRuta(nodosRuta, nodoOrigen, nodoDestino) ? nodosRuta : null;
        }
    }

    public void addArco(String origen, String destino, int peso) throws Exception {
        throw new UnsupportedOperationException("No se manejan arcos con pesos para esta configuración");
    }

}
