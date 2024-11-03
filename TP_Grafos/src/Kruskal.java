import java.util.*;
public class Kruskal {
    public List<Arista> encontrarMST(Grafo grafo) {
        //Parte 1: Inicialización y ordenamiento
        List<Arista> aristas = grafo.obtenerAristas();
        Collections.sort(aristas);

        //Parte 2: Union-Find para representar conjuntos
        UnionFind unionFind = new UnionFind(grafo.getListaAdyacencia().keySet());

        //Parte 3: construcción del MST
        List<Arista> mst = new ArrayList<>();
        for (Arista arista : aristas) {
            if (mst.size() == grafo.cantVertices() - 1){
                break;
            }
            Vertice origen = arista.getOrigen();
            Vertice destino = arista.getDestino();


            // Agregar aristas si no pertenecen al mismo conjunto
            if (!unionFind.mismoConjunto(origen, destino)) {
                mst.add(arista);
                unionFind.unir(origen, destino);
            }
        }
        return mst;
    }
}

