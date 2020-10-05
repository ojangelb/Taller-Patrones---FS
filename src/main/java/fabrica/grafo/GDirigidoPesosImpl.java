package fabrica.grafo;

import fabrica.busqueda.BusquedaBFS;
import fabrica.busqueda.BusquedaDFS;
import fabrica.busqueda.IBusqueda;
import fabrica.comun.Arco;
import fabrica.comun.Nodo;

import java.util.ArrayList;
import java.util.List;


public class GDirigidoPesosImpl implements IGrafo {

    List<Nodo> nodos = new ArrayList<>();
    List<Arco> arcos = new ArrayList<>();
    private static IBusqueda busqueda;


    private void setEstrategia(String estrategia) {

        if(estrategia.equals("BFS"))
            busqueda = new BusquedaBFS();
        else if (estrategia.equals("DFS"))
            busqueda = new BusquedaDFS();
        else
            throw new RuntimeException("Configuración Invalida");
    }

    public void addNodo(String nombre)
    {
        Nodo nodo = new Nodo();
        nodo.setNombre(nombre);
        nodos.add(nodo);
    }


    public void addArco(String origen, String destino) throws Exception
    {

        throw new UnsupportedOperationException("No se manejan arcos sin pesos para esta configuración");

    }

    public Nodo buscarNodo(String nombre)
    {
        for (Nodo nodo: nodos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    public boolean existeRuta(String origen, String destino) throws Exception {
        if (buscarRuta(origen, destino) != null) {
            return true;
        }
        return false;
    }

    public List<Nodo> buscarRuta(String origen, String destino) throws Exception {

        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);
        List<Nodo> nodosRuta = new ArrayList<>();

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        }

        if(busqueda == null) this.setEstrategia("BFS");

        if (busqueda.buscarRuta(nodosRuta, nodoOrigen, nodoDestino)) {
            return nodosRuta;
        } else {
            return null;
        }
    }


    public void addArco(String origen, String destino, int peso) throws Exception {
        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la B�squeda: NodoOrigen no encontrado");
        }

        Arco arco = new Arco();
        arco.setOrigen(nodoOrigen);
        arco.setDestino(nodoDestino);
        arco.setPeso(peso);
        arcos.add(arco);
        nodoOrigen.agregarArco(arco);



    }

}
