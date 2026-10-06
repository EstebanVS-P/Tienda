package co.edu.uniquindio.poo.model;

import java.util.Optional;

public class Producto {

    private final String nombre;
    private final String codigo;
    private final String descripcion;
    private int cantidadDisponible;
    private final float precio;
    private final Categoria categoria;
    private final Tienda ownedByTienda;

    public Producto(String nombre, String codigo, String descripcion, int cantidadDisponible, float precio, Categoria categoria, Tienda ownedByTienda) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
        this.categoria = categoria;
        this.ownedByTienda = ownedByTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public float getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", precio=" + precio +
                ", categoria="+ categoria+
                '}';
    }
}

