package Carrera;


public class Carrera {
    
    private int id;
    
    private String nombrecarrera;
    
    public Carrera (){}
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getCarrera(){
        return this.nombrecarrera;
    }
    
    public void setCarrera(String nombrecarrera){
        this.nombrecarrera = nombrecarrera;
    }
}
