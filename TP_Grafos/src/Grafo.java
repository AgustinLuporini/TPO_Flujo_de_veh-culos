import java.util.*;

public class Grafo {
    private Map<Vertice, List<Arista>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    public Map<Vertice, List<Arista>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void agregarVertice(Vertice vertice) {
        listaAdyacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void agregarArista(Vertice origen, Vertice destino, int peso) {
        // Asegurarse de que ambos vértices existen en el grafo
        listaAdyacencia.putIfAbsent(origen, new ArrayList<>());
        listaAdyacencia.putIfAbsent(destino, new ArrayList<>());

        // Crear una nueva arista con origen y destino
        Arista nuevaArista = new Arista(origen, destino, peso);

        // Agregar arista en ambas direcciones
        listaAdyacencia.get(origen).add(nuevaArista);
        Arista aristaInversa = new Arista(destino, origen, peso);
        listaAdyacencia.get(destino).add(aristaInversa);
    }



    public List<Arista> obtenerAristas() {
        Set<Arista> aristasSet = new HashSet<>();
        for (List<Arista> lista : listaAdyacencia.values()) {
            for (Arista arista : lista) {
                aristasSet.add(arista);
            }
        }
        return new ArrayList<>(aristasSet);
    }



    public int cantVertices(){
        return this.listaAdyacencia.size();
    }
}
