import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Grafo grafo = new Grafo();

        //Crear lugares
        Vertice FCiencieas = new Vertice("Facultad de ciencias");
        Vertice FIngenieria = new Vertice("Facultad de ingenierías");
        Vertice FArtes = new Vertice("Facultad de arte");
        Vertice biblioteca = new Vertice("Biblioteca");
        Vertice comedor = new Vertice("Comedor");

        //Agregar lugares (Vértices)
        grafo.agregarVertice(FCiencieas);
        grafo.agregarVertice(FIngenieria);
        grafo.agregarVertice(FArtes);
        grafo.agregarVertice(biblioteca);
        grafo.agregarVertice(comedor);

        //Agregar trayectos (Aristas)
        grafo.agregarArista(FCiencieas, FIngenieria, 30);
        grafo.agregarArista(FCiencieas, comedor, 15);
        grafo.agregarArista(FIngenieria, comedor,20);
        grafo.agregarArista(FIngenieria, biblioteca, 13);
        grafo.agregarArista(FCiencieas, biblioteca, 22);
        grafo.agregarArista(comedor, biblioteca, 28);
        grafo.agregarArista(biblioteca, FArtes, 5);
        grafo.agregarArista(FArtes, comedor, 10);

        Kruskal kruskal = new Kruskal();
        List<Arista> arbolExpansionMaxima = kruskal.encontrarMST(grafo);

        System.out.println("Trayectos entre puntos seleccionados:");
        for (Arista arista : arbolExpansionMaxima) {
            System.out.println(arista.getOrigen() + " <-----> " + arista.getDestino() + " | Transito: " + arista.getPeso());
        }


    }


}