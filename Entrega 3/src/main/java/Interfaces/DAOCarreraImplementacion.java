package Interfaces;

import Dao.Main;
import Carrera.Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOCarreraImplementacion implements DAOCarrera{
    
    //Establecer una instancia de la clase main 
    
    Main main = new Main();
    
    public DAOCarreraImplementacion(){}
    
    //Implementamos método registrar
   @Override
   public void registrar(Carrera carrera){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement insertar = conectar.prepareStatement("INSERT INTO carreras (nombrecarrera) VALUES(?)");
           
           insertar.setString(1, carrera.getCarrera());
           
           insertar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }
    
   //Implementamos el método modificar
   
   public void modificar(Carrera carrera){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement modificar = conectar.prepareStatement("UPDATE carreras set nombrecarrera = ? where id = ?");
           
           modificar.setString(1, carrera.getCarrera());
           modificar.setInt(2, carrera.getId());          
           modificar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }
   
   public void eliminar(Carrera carrera){
       try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement eliminar = conectar.prepareStatement("DELETE FROM carreras where id = ?");
           
           eliminar.setInt(1, carrera.getId());
           
           eliminar.executeUpdate();
           
       }catch(Exception e){
           System.out.println(e);
       }
   }

    @Override
    public void buscar(Carrera carrera) {
        try{
           
           Connection conectar = main.establecerConeccion();
           
           PreparedStatement buscar = conectar.prepareStatement("select * from carreras where id = ?");
           
           buscar.setInt(1, carrera.getId());
           
           ResultSet consulta = buscar.executeQuery();
           
           if( consulta.next() ){
               carrera.setCarrera(consulta.getString("nombrecarrera"));
           }
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
     
    
    
}
