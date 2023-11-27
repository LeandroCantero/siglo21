import Exceptions.DevolucionFueraDePlazoException;
import Exceptions.LibroNoEncontradoException;
import Models.Biblioteca;
import Models.Libro;
import Models.Usuario;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Biblioteca biblioteca = new Biblioteca();
    static Libro harryPotter = new Libro("Harry Potter", "J. K. Rowling", "Fantasía");
    static Libro seniorDeLosAnillos = new Libro("Señor de los Anillos", "J. R. R. Tolkien", "Fantasía");
    static Libro habitosAtomicos = new Libro("Hábitos Atómicos", "James Clear", "Auto Ayuda");
    static Libro habitosAtomicos2 = new Libro("Hábitos Atómicos 2", "James Clear", "Auto Ayuda");
    static Usuario usuario1 = new Usuario("01", "Juan", "Juan@hotmail.com");
    static Usuario usuario2 = new Usuario("01", "Juan", "Juan@hotmail.com");


    public static void main(String[] args) {
        consultasYBusquedas();
        gestionUsuarios();

    }

    public static void consultasYBusquedas() {
        biblioteca.agregarLibro(harryPotter);
        biblioteca.agregarLibro(habitosAtomicos);
        biblioteca.agregarLibro(habitosAtomicos2);
        try {
            // Intentar eliminar un libro
            biblioteca.eliminarLibro(harryPotter);
            System.out.println("Libro eliminado: " + harryPotter.getTitulo());
            // Intenta eliminar un libro que no está en el catálogo
            biblioteca.eliminarLibro(seniorDeLosAnillos);
        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Libro libroEncontrado = biblioteca.buscarLibros("James Clear");
            System.out.println("¡Libro encontrado!" + "\nTitulo: " + libroEncontrado.getTitulo() + "\nAutor: " + libroEncontrado.getAutor() + "\nGénero: " + libroEncontrado.getGenero());

        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void gestionUsuarios(){
        biblioteca.registrarUsuario(usuario1);
        biblioteca.getUsuarios();
        usuario1.alquilarLibro(habitosAtomicos);
        usuario1.alquilarLibro(seniorDeLosAnillos);
        usuario2.alquilarLibro(habitosAtomicos2);
        usuario1.alquilarLibro(habitosAtomicos2);
        try {
            usuario1.devolverLibro(habitosAtomicos);
        } catch (DevolucionFueraDePlazoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}