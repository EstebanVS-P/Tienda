package co.edu.uniquindio.poo.model;

import java.util.Objects;

//SUperclase la clase padre
public abstract class Animal {

    private final String codigo;
    private byte edad;
    private final String color;
    private String nombre;

    public Animal(String codigo, String color, byte edad, String nombre) {
        this.codigo = codigo;
        this.color = color;
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    //La clase object es el papa de todas las clases en java
    @Override
    public boolean equals(Object o) {
        if(o==null || getClass() != o.getClass())return false;
        Animal animal = (Animal)o;
        return Objects.equals(codigo, animal.codigo);
    }
    //comer, dormir, hacerSonido
    public abstract void comer();

    public abstract void dormir();

    public abstract void hacerSonido();
}
