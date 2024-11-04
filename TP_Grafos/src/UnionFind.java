import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnionFind {
    private Map<Vertice, Vertice> padre;
    private Map<Vertice, Integer> rango;

    public UnionFind(Set<Vertice> vertices) {
        padre = new HashMap<>();
        rango = new HashMap<>();
        for (Vertice vertice : vertices) {
            padre.put(vertice, vertice);
            rango.put(vertice, 0);
        }
    }

    public Vertice encontrar(Vertice vertice) {
        if (padre.get(vertice) != vertice) {
            padre.put(vertice, encontrar(padre.get(vertice)));
        }
        return padre.get(vertice);
    }

    public void unir(Vertice vertice1, Vertice vertice2) {
        Vertice raiz1 = encontrar(vertice1);
        Vertice raiz2 = encontrar(vertice2);

        if (raiz1 != raiz2) {
            if (rango.get(raiz1) < rango.get(raiz2)) {
                padre.put(raiz1, raiz2);
            } else if (rango.get(raiz1) > rango.get(raiz2)) {
                padre.put(raiz2, raiz1);
            } else {
                padre.put(raiz2, raiz1);
                rango.put(raiz1, rango.get(raiz1) + 1);
            }

        }
    }

    public boolean mismoConjunto(Vertice vertice1, Vertice vertice2) {
        return encontrar(vertice1) == encontrar(vertice2);
    }



}