package co.edu.uniquindio.poo.model;

//subclase o clase concreta
public class Gato extends Animal{

    private boolean vacunado;

    //los atributos del animal, mas el de el
    public Gato(String codigo, String color, byte edad, String nombre, boolean vacunado){
        super(codigo, color, edad, nombre);//invocar el constructor de la clase padre y luego las propias
        this.vacunado = vacunado;

    }

    @Override
    public void hacerSonido() {
        maullar();
    }

    @Override
    public void comer() {
        System.out.println("El gato toma leche");
    }

    @Override
    public void dormir() {
        System.out.println("El gato duerme");
    }
    public void maullar() {
        System.out.println("El gato maulla");
    }
}
