import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroPersonas {
    private static final List<String> nombreLista = new ArrayList<>();
    private static final List<String> apellidoLista = new ArrayList<>();
    private static final List<String> dniLista = new ArrayList<>();
    private static final List<String> fechaNacimientoLista = new ArrayList<>();
    private static int cantidadPersonas = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarPersona(scanner);
                case 2 -> listarPersonas();
                case 3 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("-------- Menú --------");
        System.out.println("1. Agregar Persona");
        System.out.println("2. Listar Personas");
        System.out.println("3. Salir");
        System.out.print("Ingrese la opción: ");
    }

    private static void agregarPersona(Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Ingrese el DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
            String fechaNacimiento = scanner.nextLine();

            validarNombreApellido(nombre, apellido);
            validarDNI(dni);
            validarFechaNacimiento(fechaNacimiento);

            nombreLista.add(nombre);
            apellidoLista.add(apellido);
            dniLista.add(dni);
            fechaNacimientoLista.add(fechaNacimiento);
            cantidadPersonas++;

            System.out.println("Persona agregada correctamente.\n");
        } catch (ParseException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
    private static void listarPersonas() {
        if (cantidadPersonas == 0) {
            System.out.println("No hay personas registradas.\n");
        } else {
            System.out.println("-------- Lista de Personas --------");
            for (int i = 0; i < cantidadPersonas; i++) {
                System.out.println("Nombre: " + nombreLista.get(i));
                System.out.println("Apellido: " + apellidoLista.get(i));
                System.out.println("DNI: " + dniLista.get(i));
                System.out.println("Fecha de Nacimiento: " + fechaNacimientoLista.get(i));
                System.out.println("--------------------");
            }
        }
    }

    private static void validarNombreApellido(String nombre, String apellido) {
        if (nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y el apellido no pueden estar en blanco.");
        }
    }

    private static void validarDNI(String dni) {
        //La expresión regular "\\d{8}" significa que debe haber exactamente 8 dígitos en la cadena.
        if (!dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe ser un número válido de 8 dígitos.");
        }
    }

    private static void validarFechaNacimiento(String fechaNacimiento) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(fechaNacimiento);
        } catch (ParseException e) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser una fecha válida en el formato dd/MM/yyyy.");
        }
    }
}
