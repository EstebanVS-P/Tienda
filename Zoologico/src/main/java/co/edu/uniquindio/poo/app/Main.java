package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Animal;
import co.edu.uniquindio.poo.model.Gato;
import co.edu.uniquindio.poo.model.Perro;
import co.edu.uniquindio.poo.model.Zoologico;

public class Main {
    public static void main(String args[]){

        Zoologico zoologico=new Zoologico("Ukumari","Pereira");

        Animal animal1 = new Gato("001", "Gris",(byte) 3,  "Michi", false);
        zoologico.registrarAnimal(animal1);

        Animal animal2 = new Perro("002", "Gris",(byte) 3,  "Michi", "pit");
        zoologico.registrarAnimal(animal2);

        Gato gato1 = (Gato) animal1;

        //Esto no se podria porque animal por dentro es un perro, no lo puedo convertir en gato
        Perro perro1 = (Perro) animal2;

        if(animal1.equals(animal2)){
            System.out.println("Son iguales");
        }else{
            System.out.println("Son distintos");
        }

        zoologico.comerTodosAnimales();
        gato1.maullar();
        perro1.ladrar();
    }
}
