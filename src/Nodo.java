public class Nodo {

    private Cliente cliente;   // Cliente almacenado
    private Nodo siguiente;    // Referencia al siguiente nodo

    // Constructor
    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    // Getter del cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Getter del siguiente
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Setter del siguiente
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}