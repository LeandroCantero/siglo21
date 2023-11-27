package Models;

import Exceptions.DevolucionFueraDePlazoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String mail;
    private List<Alquiler> alquileres;

    public Usuario(String id, String nombre, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
        this.alquileres = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public void alquilarLibro(Libro libro) {
        if (libro.getIsDisponible()) {
            Alquiler alquiler = new Alquiler(this, libro);
            alquileres.add(alquiler);
            libro.setDisponible(false);
            System.out.println("Libro alquilado: " + libro.getTitulo() + ". Fecha de devolución: " + alquiler.getFechaDevolucion());
        } else {
            System.out.println("El libro " + libro.getTitulo() + " no está disponible para alquilar.");
        }
    }

    public void devolverLibro(Libro libro) throws DevolucionFueraDePlazoException {
        for (Alquiler alquiler : alquileres) {
            if (alquiler.getLibro().equals(libro)) {
                alquileres.remove(alquiler);
                libro.setDisponible(true);
                if (new Date().after(alquiler.getFechaDevolucion())) {
                    throw new DevolucionFueraDePlazoException("Devolución fuera de plazo. Se aplicarán cargos adicionales.");
                } else {
                    System.out.println("Libro devuelto: " + libro.getTitulo());
                }
                return;
            }
        }
        System.out.println("No se puede devolver. El libro " + libro.getTitulo() + " no estaba en préstamo.");
    }
}
