package fabrica.busqueda;

import fabrica.comun.Nodo;

import java.util.List;

public interface IBusqueda {
    Boolean buscarRuta( List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
}
