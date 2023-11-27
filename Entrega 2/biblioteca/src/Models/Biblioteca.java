package Models;

import Exceptions.LibroNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libro.setDisponible(true);
        catalogo.add(libro);
    }

    public void eliminarLibro(Libro libro) throws LibroNoEncontradoException {
        if (catalogo.contains(libro)) {
            libro.setDisponible(false);
            catalogo.remove(libro);
        } else {
            throw new LibroNoEncontradoException("El libro con título '" + libro.getTitulo() + "' no fue encontrado.");
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void getUsuarios(){
        System.out.println("Lista de usuarios: ");
        for (Usuario usuario : usuarios){
            System.out.println(usuario.getNombre());
        }
    }

    public void alquilarLibro(Usuario usuario, Libro libro) {
        // Implementar lógica para alquilar un libro a un usuario
    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        // Implementar lógica para devolver un libro a la biblioteca
    }

    public Libro buscarLibros(String criterio) throws LibroNoEncontradoException {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equals(criterio) || libro.getAutor().equals(criterio) || libro.getGenero().equals(criterio)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("El libro con título '" + criterio + "' no fue encontrado.");
    }
}
