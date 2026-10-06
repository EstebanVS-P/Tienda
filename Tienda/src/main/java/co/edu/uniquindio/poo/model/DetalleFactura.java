package co.edu.uniquindio.poo.model;

public class DetalleFactura {

    private final int cantidadComprada;
    private final double subTotal;

    public DetalleFactura(int cantidadComprada, double subTotal) {
        this.cantidadComprada = cantidadComprada;
        this.subTotal = subTotal;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "cantidadComprada=" + cantidadComprada +
                ", subTotal=" + subTotal +
                '}';
    }
}