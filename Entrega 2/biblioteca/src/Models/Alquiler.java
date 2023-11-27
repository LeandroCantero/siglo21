package Models;

import java.util.Date;

public class Alquiler {
    private Usuario usuario;
    private Libro libro;
    private Date fechaAlquiler;
    private Date fechaDevolucion;
    private int plazoDias = 14;

    public Alquiler(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaAlquiler = new Date();
        this.fechaDevolucion = calcularFechaDevolucion();
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Método  para calcular la fecha de devolución
    private Date calcularFechaDevolucion() {
        long tiempoAlquiler = plazoDias * 24 * 60 * 60 * 1000;  // Convertir días a milisegundos
        return new Date(fechaAlquiler.getTime() + tiempoAlquiler);
    }
}
