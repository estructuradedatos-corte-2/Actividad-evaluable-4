import java.util.Comparator;

// Comparator para prioridad de clientes
public class ClienteComparator implements Comparator<Cliente> {

    @Override
    public int compare(Cliente a, Cliente b) {

        // Prioridad: urgente primero
        if (!a.getTipo().equals(b.getTipo())) {

            if (a.getTipo().equals("urgente")) return -1;
            else return 1;
        }

        // Si son iguales, el que llegó primero
        return Integer.compare(a.getLlegada(), b.getLlegada());
    }
}