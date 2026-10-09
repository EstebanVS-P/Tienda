package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//El record una vez se le agregan los datos jamas se pueden modificar
public record Factura(String codigo, LocalDate fecha, double total, EstadoFactura estadoFactura,
                      MetodoPago metodoPago, Cliente cliente, ArrayList<DetalleFactura> listaDetallesFactura){

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                ", estadoFactura=" + estadoFactura +
                ", metodoPago=" + metodoPago +
                ", cliente=" + cliente +
                '}';
    }
    public void agregarDetallesFactura(DetalleFactura detalleFactura){
        listaDetallesFactura.add(detalleFactura);
    }

    public boolean tieneCliente(String letraBuscar){
        boolean noEncontrado = true;
        boolean resultado = cliente.nombreLetra(letraBuscar);
        if(resultado==true){
            return false;
        }
        return noEncontrado;
    }
    public List<DetalleFactura> detallesFacturaIphone(){
        List<DetalleFactura> listaIphone=new LinkedList<>();
        for(DetalleFactura ayuda : listaDetallesFactura){
            if(ayuda.getProducto().getCategoria().equals(Categoria.CELULARES)){
                listaIphone.add(ayuda);
            }
        }
        return listaIphone;
    }
}
