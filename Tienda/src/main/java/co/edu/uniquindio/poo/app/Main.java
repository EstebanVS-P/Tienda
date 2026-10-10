package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import java.time.LocalDate;
import java.util.*;

import javax.swing.*;

public class Main {
    public static void main(String args[]){


        JOptionPane.showMessageDialog(null,"Bienvenido al sistema de gestion de la tienda.");
        String nombreTienda= JOptionPane.showInputDialog(null,"Ingresa el nombre de la tienda: ");
        String nit=  JOptionPane.showInputDialog(null,"Ingresa el codigo NIT: ");
        String telefono=  JOptionPane.showInputDialog(null,"Ingresa el telefono de la tienda: ");

        Tienda tienda = new Tienda(nombreTienda,nit,telefono);

        int opcion;

        do{
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opcion: ---Menu---\n"+
                    "1. Agregar un cliente."+
                    "\n2. Eliminar al cliente."+
                    "\n3. Buscar cliente."+
                    "\n4. Agregar poducto."+
                    "\n5. Buscar producto."+
                    "\n6. Eliminar Producto."+
                    "\n7. Generar Factura."+
                    "\n8. Eliminar la factura."+
                    "\n9. Buscar factura."+
                    "\n10. Mostrar los productos con una cantidad disponible mayor o igual a 10."+
                    "\n11. Mostrar los productos los codigos de los productos con una cantidad disponible entre 10 y 50."+
                    "\n12. Mostrar los clientes que hayan comprado el 07 de octubre de 2026."+
                    "\n13. Mostrar las facturas que tenga un cliente donde su nombre empiece por R."+
                    "\n14. Mostrar las facturas donde se haya comprado un iphone 16pro max."+
                    "\n15. Mostrar las facturas de un cliente que se llame juan y compre un iphone 16pro max."+
                    "\n16. Mostrar los productos de una categoria."+
                    "\n17. Mostrar los productos en un rango de precios."+
                    "\n18. Mostrar los productos ordenados de precio menor a mayor."+
                    "\n19. Mostrar el producto con el precio mayor."+
                    "\n20. Mostrar todos los clientes pertenecientes a una ciudad."+
                    "\n21. Salir."));


            switch(opcion){
                case 1: crearCliente(tienda);
                    break;
                case 2: eliminarClienteMain(tienda);
                    break;
                case 3: mostrarCliente(tienda);
                    break;
                case 4: crearProducto(tienda);
                    break;
                case 5: mostrarProducto(tienda);
                    break;
                case 6 : eliminarProducto(tienda);
                    break;
                case 7 : generarFactura(tienda);
                    break;
                case 8 : eliminarFacturaMain(tienda);
                    break;
                case 9 : mostrarFacturaMain(tienda);
                    break;
                case 10: crearCliente(tienda);
                    break;
                case 11: eliminarClienteMain(tienda);
                    break;
                case 12: mostrarCliente(tienda);
                    break;
                case 13: crearProducto(tienda);
                    break;
                case 14: mostrarProducto(tienda);
                    break;
                case 15 : eliminarProducto(tienda);
                    break;
                case 16 : generarFactura(tienda);
                    break;
                case 17 : eliminarFacturaMain(tienda);
                    break;
                case 18 : mostrarFacturaMain(tienda);
                    break;
                case 19 : mostrarFacturaMain(tienda);
                    break;
                case 20 : mostrarFacturaMain(tienda);
                    break;
                case 21: JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default: JOptionPane.showMessageDialog(null, "Opcion invalida.");
                    break;
            }
        }while(opcion != 14);
    }
    public static void crearCliente(Tienda tienda){
        String documentoIdentidad= JOptionPane.showInputDialog(null,"Ingresa la identificacion del cliente: ");
        String nombreCompleto= JOptionPane.showInputDialog(null,"Ingresa el nombre del cliente: ");
        String telefono= JOptionPane.showInputDialog(null,"Ingresa el telefono del cliente: ");
        String correo= JOptionPane.showInputDialog(null,"Ingresa el correo del cliente: ");
        String ciudadResidencia= JOptionPane.showInputDialog(null,"Ingresa la ciudad de residencia del cliente: ");

            String resultado = tienda.registrarCliente(documentoIdentidad,nombreCompleto,telefono,correo,ciudadResidencia);
            JOptionPane.showMessageDialog(null,  resultado);
    }
    public static void mostrarCliente(Tienda tienda){
        String documentoIdentidad= JOptionPane.showInputDialog(null,"Ingresa la identificacion del cliente a buscar: ");
        Optional<Cliente> clienteMostrar = tienda.buscarCliente(documentoIdentidad);
        if(clienteMostrar.isEmpty()){
            JOptionPane.showMessageDialog(null,  "No existe un cliente que tenga ese documento de identidad.");
        }else{
            JOptionPane.showMessageDialog(null,  clienteMostrar.get().toString());
        }
    }
    public static void eliminarClienteMain(Tienda tienda){
        String documentoIdentidad= JOptionPane.showInputDialog(null,"Ingresa la identificacion del cliente a eliminar: ");
        boolean eliminado = tienda.eliminarCliente(documentoIdentidad);
        if(eliminado==false){
            JOptionPane.showMessageDialog(null,"Cliente eliminado con exito.");
        }else{
            JOptionPane.showMessageDialog(null,"El cliente que tratas de eliminar no exite.");
        }
    }
    public static void crearProducto(Tienda tienda){
        String nombre= JOptionPane.showInputDialog(null,"Ingresa el nombre del producto:  ");
        String codigo = JOptionPane.showInputDialog(null,"Ingresa la ciudad de residencia del cliente: ");
        String descripcion = JOptionPane.showInputDialog(null,"Ingresa la descripcion del producto: ");
        int cantidadDisponible = Integer.valueOf(JOptionPane.showInputDialog(null,"Ingresa la cantidad disponible de productos: "));
        float precio = Float.valueOf(JOptionPane.showInputDialog(null,"ingresa el precio del producto: "));
        Categoria categoria = Categoria.valueOf(JOptionPane.showInputDialog(null,"Ingresa la categoria del producto: ").toUpperCase().trim());

        String resultado = tienda.registrarProducto(nombre, codigo, descripcion, cantidadDisponible, precio, categoria);
        JOptionPane.showMessageDialog(null,  resultado);
    }
    public static void mostrarProducto(Tienda tienda){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del producto que quieres ver:");
        Optional<Producto> productoMostrar = tienda.buscarProducto(codigo);
        if(productoMostrar.isPresent()){
            JOptionPane.showMessageDialog(null,productoMostrar.get().toString());
        }else{
            JOptionPane.showMessageDialog(null,"No hay productos con ese codigo.");
        }
    }
    public static void eliminarProducto(Tienda tienda){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del producto que quieres eliminar: ");

        boolean noEncontrado = tienda.eliminarProducto(codigo);
        if(noEncontrado==false){
                JOptionPane.showMessageDialog(null,"Producto eliminado con exito.");
        }else{
            JOptionPane.showMessageDialog(null,"El Producto que tratas de eliminar no exite.");
        }
    }
    public static void generarFactura(Tienda tienda) {
        Optional<Cliente> clienteOption = buscarClienteFactura(tienda);
        if(clienteOption.isEmpty()){
            return;
        }
        Cliente cliente = clienteOption.get();

        ArrayList<DetalleFactura> listaDetalles = agregarDetallesFactura(tienda);
        if(listaDetalles.isEmpty()){
            return;
        }
        MetodoPago metodo = preguntarMetodoPago();

        EstadoFactura estadoFactura = preguntarEstadoFactura();

        Random numero = new Random();
        String codigo = String.valueOf(numero.nextInt(9000)+1000);

        double total = 0;
        for(DetalleFactura ayuda: listaDetalles) {
            total = total+ayuda.getSubTotal();
        }
        LocalDate fecha = LocalDate.now();

        String resultado = tienda.registrarFactura(cliente,metodo,estadoFactura,codigo,total,fecha,listaDetalles);
        JOptionPane.showMessageDialog(null,resultado);
    }
    public static Optional<Cliente> buscarClienteFactura(Tienda tienda){
        String documentoIdentidad= JOptionPane.showInputDialog(null, "Ingresa el documento de identidad del cliente:");

        Optional<Cliente> clienteMostrar = tienda.buscarCliente(documentoIdentidad);

        return clienteMostrar;
    }
    public static MetodoPago preguntarMetodoPago(){
        MetodoPago metodo;
        byte opcion = Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa el metodo de pago (Efectivo: 1, Tarjeta debito: 2" +
                                                                                          "\nTarjeta credito: 3, Transferencia: 4): "));

        switch (opcion) {
            case 1:
                metodo = MetodoPago.EFECTIVO;
                break;
            case 2:
                metodo = MetodoPago.TARJETA_DEBITO;
                break;
            case 3:
                metodo = MetodoPago.TARJETA_CREDITO;
                break;
            case 4:
                metodo = MetodoPago.TRANSFERENCIA;
                break;
            default:
                metodo = null;
                break;
        }
        return metodo;
    }
    public static EstadoFactura preguntarEstadoFactura(){
        EstadoFactura estadoFactura;
        byte opcion = Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa el estado de la factura (Generada: 1, Cancelada: 2" +
                                                                                          "\nEnviada: 3, Pagada: 4): "));

        switch (opcion) {
            case 1:
                estadoFactura = EstadoFactura.GENERADA;
                break;
            case 2:
                estadoFactura = EstadoFactura.CANCELADA;
                break;
            case 3:
                estadoFactura = EstadoFactura.ENVIADA;
                break;
            case 4:
                estadoFactura = EstadoFactura.PAGADA;
                break;
            default:
                estadoFactura = null;
                break;
        }
        return estadoFactura;
    }
    public static ArrayList<DetalleFactura> agregarDetallesFactura(Tienda tienda){
        ArrayList<DetalleFactura> listaDetalles=new ArrayList<>();
        byte agregarOtro = 0;
        do {
            double subTotal = 0;
            String codigoProducto = JOptionPane.showInputDialog(null, "Ingresa el codigo del producto que quieres comprar: ");
            Optional<Producto> producto = tienda.buscarProducto(codigoProducto);
            if(producto.isPresent()) {
                int cantidadComprada = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresa la cantidad de productos a comprar:"));
                if(cantidadComprada>0) {
                    subTotal = tienda.obtenerPrecioUnidad(codigoProducto) * cantidadComprada;

                    int nuevoStock = tienda.disminuirStock(cantidadComprada, codigoProducto);
                    if (nuevoStock == -1) {
                        JOptionPane.showMessageDialog(null, "La cantidad de productos que deseas comprar no esta disponible" +
                                                                                 "\nen el momento tenemos disponibles " + tienda.obtenerStock(codigoProducto) + " unidades" +
                                                                                 "\neste producto no se agregara a la factura.");
                        break;
                    }
                    DetalleFactura detalleFactura = new DetalleFactura(cantidadComprada, subTotal, producto.get());
                    listaDetalles.add(detalleFactura);
                }else{
                    JOptionPane.showMessageDialog(null, "Cantidad no valida, este producto no se agregara a la factura.");
                    break;
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existe producto con ese codigo, este producto no se agregara a la factura.");
                break;
            }

            agregarOtro = Byte.valueOf(JOptionPane.showInputDialog(null, "¿Quieres agregar otro producto? 1. Si y 2. No "));
        }while(agregarOtro == 1);

        return listaDetalles;
    }
    public static void eliminarFacturaMain(Tienda tienda){
        JOptionPane.showMessageDialog(null,"Se recomienda ver primero la factura para saber el codigo.");
        String codigo= JOptionPane.showInputDialog(null, "Ingresa el codigo de la factura a eliminar:");
        boolean noEncontrada= tienda.eliminarFactura(codigo);
        if(noEncontrada==false){
            JOptionPane.showMessageDialog(null,"Factura eliminada con exito.");
        }else{
            JOptionPane.showMessageDialog(null,"No existe factura con ese codigo.");
        }
    }

    public static void mostrarFacturaMain(Tienda tienda){
        String codigo= JOptionPane.showInputDialog(null, "Ingresa el codigo de la factura a mostrar:");

        Optional<Factura> facturaMostrar = tienda.buscarFactura(codigo);
        if(facturaMostrar.isPresent()){
            JOptionPane.showMessageDialog(null,facturaMostrar.get().toString());
        }else{
            JOptionPane.showMessageDialog(null,"No existe una factura con ese codigo.");
        }
    }
    public static void pregunta7 (Tienda tienda){
        String categoria = JOptionPane.showInputDialog(null,"Ingresa la categoria de la cual quieres saber todos sus productos:");
        Categoria categoriaSeleccionada = Categoria.valueOf(categoria.toUpperCase());

        List<Producto> productosCategoria = tienda.productosCategoria(categoriaSeleccionada);
        if(!productosCategoria.isEmpty()){
            for(Producto ayuda: productosCategoria){
                JOptionPane.showMessageDialog(null, ayuda.toString());
            }
        }else {
            JOptionPane.showMessageDialog(null, "Esa categoria no existe.");
        }
    }
    public static void pregunta11(Tienda tienda){
        String ciudad = JOptionPane.showInputDialog(null,"Ingresa la ciudad de la cual quieres saber todos sus clientes:");
        List<Cliente> clientesCiudad = tienda.clientesCiudadDada(ciudad);
        if(!clientesCiudad.isEmpty()) {
            JOptionPane.showMessageDialog(null, clientesCiudad.toString());
        }else {
            JOptionPane.showMessageDialog(null, "No hay clientes en esta ciudad.");
        }
    }
}
