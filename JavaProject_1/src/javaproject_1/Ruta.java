package javaproject_1;

/**
 *
 * @author Diego A. Vivolo / Gabriel Orozco
 */
public class Ruta{
    private String origen;
    private String sigCiudad;
    private int destino;
    
    

    public Ruta(String origen_etiqueta, String destino_etiqueta, int peso) {
        
        this.origen = origen;
        this.sigCiudad = sigCiudad;
    }
    
    public boolean equals(Object n){
        Ruta a = (Ruta)n;
        return false;
    }
 
    /**
     * @return the origen_etiqueta
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen_etiqueta the origen_etiqueta to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino_etiqueta
     */
    public String getsigCiudad(){
        return sigCiudad;
    }

    /**
     * @param destino_etiqueta the destino_etiqueta to set
     */
    public void setsigCiudad(String sigCiudad) {
        this.sigCiudad = sigCiudad;
    }
    
        /**
     * Metodo para mostrar la ruta
     * @return ruta String de la ruta
     */
    
    public String show() {
        String ruta = getOrigen() + "," + getsigCiudad();
        return ruta;        
                
    } 

}
  