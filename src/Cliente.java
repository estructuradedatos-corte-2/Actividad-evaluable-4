// Clase que representa a un cliente del banco
public class Cliente {

    private int id;                 // Identificador del cliente
    private String tipo;            // Tipo: normal o urgente
    private int llegada;            // Tiempo de llegada
    private int tiempoAtencion;     // Tiempo de atención

    // Constructor
    public Cliente(int id, String tipo, int llegada, int tiempoAtencion) {
        this.id = id;
        this.tipo = tipo;
        this.llegada = llegada;
        this.tiempoAtencion = tiempoAtencion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLlegada() {
        return llegada;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}



    
