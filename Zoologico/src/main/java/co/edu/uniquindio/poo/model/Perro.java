package co.edu.uniquindio.poo.model;

public class Perro extends  Animal{
    private String raza;
    //no se puede extender dos clases solo una
    public Perro(String codigo, String color, byte edad, String nombre, String raza){
        super(codigo,color,edad,nombre);
        this.raza=raza;
    }
    @Override
    public void comer() {
        System.out.println("El perro come");
    }

    @Override
    public void dormir() {
        System.out.println("El perro duerme");
    }

    @Override
    public void hacerSonido() {
        ladrar();
    }

    public void ladrar() {
        System.out.println("El perro ladra");
    }

}
