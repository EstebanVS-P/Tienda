package co.edu.uniquindio.poo.model;

public class DetalleFactura {

    private final int cantidadComprada;
    private final double subTotal;
    private final Producto producto;

    public DetalleFactura(int cantidadComprada, double subTotal, Producto producto) {
        this.cantidadComprada = cantidadComprada;
        this.subTotal = subTotal;
        this.producto = producto;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "cantidadComprada=" + cantidadComprada +
                ", subTotal=" + subTotal +
                ", producto=" + producto +
                '}';
    }
}