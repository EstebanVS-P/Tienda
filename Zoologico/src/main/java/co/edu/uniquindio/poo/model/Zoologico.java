package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Zoologico {
    private String nombre;
    private final String direccion;

    private ArrayList<Animal> listaAnimales= new ArrayList<>();
    public Zoologico(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    public void setListaAnimales(ArrayList<Animal> listaAnimales) {

    }

    public String registrarAnimal (Animal animal){
        Optional<Animal> animalOptional = buscarAnimal(animal.getCodigo());
        if(animalOptional.isPresent()){
            return "Este animal ya existe";
        }else{
            listaAnimales.add(animal);
            return "Animal registrado con exito";
        }
    }
    public Optional<Animal> buscarAnimal(String codigo){
        return listaAnimales.stream().filter(animal -> animal.getCodigo().equals(codigo)).findFirst();
    }

    public void comerTodosAnimales() {
        for(Animal animal: listaAnimales){
            animal.comer();
        }
    }
    public void comerTodosGatos() {
        for(Animal animal: listaAnimales){
            if(animal instanceof Gato){
                animal.comer();
            }
        }
    }
    public void maullarTodosGatos() {
        for(Animal animal: listaAnimales){
            if(animal instanceof Gato){
                ((Gato) animal).maullar();
            }
        }
    }
}
