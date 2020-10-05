package fabrica.ejemplos;

import fabrica.grafo.IGrafo;



public class FabricaGrafos {
    public static IGrafo getGrafo(String clase) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IGrafo grafo = (IGrafo) Class.forName(clase).newInstance();
        return grafo;

    }
}
