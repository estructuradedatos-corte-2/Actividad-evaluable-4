// Cola FIFO implementada manualmente
public class Cola {

    private Nodo frente;      // Primer elemento
    private Nodo finalCola;   // Último elemento

    // Constructor
    public Cola() {
        frente = null;
        finalCola = null;
    }

    // Método para encolar
    public void encolar(Cliente c) {

        Nodo nuevo = new Nodo(c); // Crear nuevo nodo

        if (estaVacia()) {
            frente = nuevo;         // Primer elemento
            finalCola = nuevo;
        } else {
            finalCola.setSiguiente(nuevo); // Usar setter
            finalCola = nuevo;
        }
    }

    // Método para desencolar
    public Cliente desencolar() {

        if (estaVacia()) {
            return null;
        }

        Cliente c = frente.getCliente(); // Usar getter

        frente = frente.getSiguiente(); // Avanzar

        if (frente == null) {
            finalCola = null;
        }

        return c;
    }

    // Verifica si está vacía
    public boolean estaVacia() {
        return frente == null;
    }
}