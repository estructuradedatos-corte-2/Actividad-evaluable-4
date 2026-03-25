import java.util.PriorityQueue;
import java.util.Random;

// Clase principal
public class SimuladorBanco {

    public static void main(String[] args) {

        Cola colaNormal = new Cola(); // Cola manual
        PriorityQueue<Cliente> colaUrgente =
                new PriorityQueue<>(new ClienteComparator());

        Random rand = new Random();

        int tiempo = 0;
        int id = 1;

        int atendidos = 0;
        int tiempoTotalEspera = 0;

        int ventanillas = 2;
        int[] ocupadas = new int[ventanillas];

        while (tiempo < 20) {

            System.out.println("Tiempo: " + tiempo);

            // Generar cliente
            if (rand.nextBoolean()) {

                String tipo = rand.nextInt(3) == 0 ? "urgente" : "normal";

                Cliente nuevo = new Cliente(
                        id++, tipo, tiempo, rand.nextInt(5) + 1);

                if (tipo.equals("urgente")) {
                    colaUrgente.add(nuevo);
                    System.out.println("Llega URGENTE ID: " + nuevo.getId());
                } else {
                    colaNormal.encolar(nuevo);
                    System.out.println("Llega NORMAL ID: " + nuevo.getId());
                }
            }

            // Atender clientes
            for (int i = 0; i < ventanillas; i++) {

                if (ocupadas[i] == 0) {

                    Cliente siguiente = null;

                    if (!colaUrgente.isEmpty()) {
                        siguiente = colaUrgente.poll();
                    } else if (!colaNormal.estaVacia()) {
                        siguiente = colaNormal.desencolar();
                    }

                    if (siguiente != null) {

                        ocupadas[i] = siguiente.getTiempoAtencion();

                        int espera = tiempo - siguiente.getLlegada();
                        tiempoTotalEspera += espera;

                        atendidos++;

                        System.out.println("Atendiendo cliente "
                                + siguiente.getId()
                                + " en ventanilla " + i
                                + " (" + siguiente.getTipo() + ")");
                    }

                } else {
                    ocupadas[i]--;
                }
            }

            tiempo++;
        }

        // Resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Clientes atendidos: " + atendidos);

        if (atendidos > 0) {
            System.out.println("Tiempo promedio: "
                    + (tiempoTotalEspera / atendidos));
        }
    }
}