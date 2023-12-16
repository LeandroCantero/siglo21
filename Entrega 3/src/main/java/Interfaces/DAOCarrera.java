package Interfaces;

import Carrera.Carrera;

public interface DAOCarrera {
    
    public void registrar(Carrera carrera);
    
    public void modificar(Carrera carrera);
    
    public void eliminar(Carrera carrera);
    
    public void buscar(Carrera carrera);
    
}
