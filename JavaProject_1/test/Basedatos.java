/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author Diego A. Vivolo / Gabriel Orozco
 */
public class Basedatos {
    
    private static final String CIUDADES_SECTION = "Ciudades;";
    private static final String RUTA_SECTION = "Rutas;";
    private static final String STORE_PREFIX = "Almacen ";
    private static final int READING_NULL = 0;
    private static final int READING_CIUDAD = 1;
    private static final int READING_STOCK = 2;
    private static final int READING_RUTA = 3;

    private Basedatos() {}  

    public static Grafo readBasedatos(File file) throws IOException {
        return readBasedatos(new FileReader(file));
    }
        
        
    public static Grafo readBasedatos(Reader baseReader) throws IOException {
        Grafo grafo = new Grafo();        
        
        try (BufferedReader reader = new BufferedReader(baseReader)) {

            int mode = READING_NULL;
            Ciudad ciudad = null; 
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith(STORES_SECTION)) {
                    mode = READING_CIUDAD;
                } else if (line.startsWith(RUTA_SECTION)) {
                    mode = READING_RUTA;
                } else if (mode == READING_CIUDAD) {
                    String name = line.split(":")[0].replace(CIUDAD_PREFIX, "");
                    ciudad = grafo.createGrafo(name);
      
}  
    
    
    
    public static StoreGraph readDatabase(Reader baseReader) throws IOException {
        StoreGraph graph = new StoreGraph();

        try (BufferedReader reader = new BufferedReader(baseReader)) {

            int mode = READING_NULL;
            Store store = null;

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.startsWith(STORES_SECTION)) {
                    mode = READING_STORE;
                } else if (line.startsWith(ROUTES_SECTION)) {
                    mode = READING_ROUTE;
                } else if (mode == READING_STORE) {
                    String name = line.split(":")[0].replace(STORE_PREFIX, "");
                    store = graph.createStore(name);
                    if (!line.endsWith(";")) {
                        mode = READING_STOCK;
                    }
                } else if (mode == READING_STOCK) {
                    String[] data = line.split(";")[0].split(",");
                    if (store != null && data.length >= 2) {
                        Stock stock = new Stock(data[0], Integer.parseInt(data[1]));
                        store.getStock().append(stock);
                    }
                    if (line.endsWith(";")) {
                        mode = READING_STORE;
                    }
                } else if (mode == READING_ROUTE) {
                    String[] data = line.split(",");
                    if (data.length >= 3) {
                        graph.createRoute(data[0], data[1], Integer.parseInt(data[2]));
                    }
                }
            }
        }

        return graph;
    }
       /**
     * Escribe la base de datos hacia un archivo
     * @param graph grafo que representa la base de datos
     * @param file archivo a leer
     * @throws IOException si ocurre un error al escribir al archivo
     */
    public static void writeDatabase(StoreGraph graph, File file) throws IOException {
        writeDatabase(graph, new FileWriter(file));
    }

    /**
     * Escribe la base de datos a trav�s de un escritor
     * @param graph grafo que representa la base de datos
     * @param baseWriter escritor a utilizar
     * @throws IOException si ocurre un error al escribir los datos
     */
    public static void writeDatabase(StoreGraph graph, Writer baseWriter) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(baseWriter)) {

            writer.write("%s\n".formatted(STORES_SECTION));

            for (ListNode<Store> storeNode = graph.getStores().getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
                Store store = storeNode.getValue();
                writer.write("%s%s:".formatted(STORE_PREFIX, store.getName()));
                for (ListNode<Stock> stockNode = store.getStock().getFirst(); stockNode != null; stockNode = stockNode.getNext()) {
                    Stock stock = stockNode.getValue();
                    writer.write("\n%s,%d".formatted(stock.getProduct(), stock.getAmount()));
                }
                writer.write(";\n");
            }

            StoreList pending = new StoreList(), visited = new StoreList();
            pending.append(graph.getStores().getFirst().getValue());

            writer.write("%s\n".formatted(ROUTES_SECTION));

            for (ListNode<Store> storeNode = pending.getFirst(); storeNode != null; storeNode = storeNode.getNext()) {
                Store store = storeNode.getValue();
                for (ListNode<Route> routeNode = store.getRoutes().getFirst(); routeNode != null; routeNode = routeNode.getNext()) {
                    Route route = routeNode.getValue();
                    if(!route.isBackwards()) {
                        writer.write("%s,%s,%d\n".formatted(store.getName(), route.getStore().getName(), route.getDistance()));
                    }
                    if(visited.find(route.getStore().getName()) == null && pending.find(route.getStore().getName()) == null) {
                        pending.append(route.getStore());
                    }
                }
                pending.remove(store.getName());
                visited.append(store);
            }

            writer.flush();
        }
    }
}

    
    
    
    
    
    
    public class AjusteParametros{
        public static double alpha = 1.0;
        
        public static double beta = 2.0;
        
        
        
        public static int HomigasCan =;
    }
}
