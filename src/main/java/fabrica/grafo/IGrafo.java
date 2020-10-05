package fabrica.grafo;

import fabrica.comun.Nodo;

import java.util.List;

public interface IGrafo {

    Nodo buscarNodo(String nombre) throws Exception;

    List<Nodo> buscarRuta(String origen, String destino) throws Exception;

    void addNodo(String nombre);

    void addArco(String origen, String destino) throws Exception;

    void addArco(String origen, String destino, int peso) throws Exception;


}
