package javaproject_1;
/**
 *
 * @author Diego A. Vivolo / Gabriel Orozco
 */
public class Grafo {
    private final int vertices; // Número de vértices
    private int aristas ; // Número de aristas
    private ListNode[] adj; // Lista de adyacencia
    private final CiudadList ciudades = new CiudadList();
    

    // Clase interna para representar una lista de adyacencia
    private static class ListNode {
        Node cabeza; // cabeza de la lista
        
        // Clase interna para nodos en la lista de adyacencia
        private static class Node {
            int destino;
            Node siguiente;
            
            Node(int destino, Node siguiente) {
                this.destino = destino;
                this.siguiente = siguiente;
            }
        }

        // Método para agregar un nodo al inicio de la lista
        void agregar(int destino) {
            cabeza = new Node(destino, cabeza);
        }
    }

    // Constructor del grafo
    public Grafo(int V) {
        this.vertices = V;
        this.aristas = 0;
        adj = new ListNode[V]; // Inicializar lista de adyacencia para cada vértice
        for (int v = 0; v < V; v++) {
            adj[v] = new ListNode();
        }
    }

    // Método para agregar una arista
    public void agregarArista(int v, int w) {
        adj[v].agregar(w); // Agrega w a la lista de v
        adj[w].agregar(v); // Agrega v a la lista de w, ya que el grafo es no dirigido
        aristas++;
    }
    

    
}



