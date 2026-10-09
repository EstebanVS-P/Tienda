package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.util.Optional;

public class Main {
    public static void main(String args[]){


        JOptionPane.showMessageDialog(null,"Bienvenido al sistema de gestion de la tienda.");
        String nombreTienda= JOptionPane.showInputDialog(null,"Ingresa el nombre de la tienda: ");
        String nit=  JOptionPane.showInputDialog(null,"Ingresa el codigo NIT: ");
        String telefono=  JOptionPane.showInputDialog(null,"Ingresa el telefono de la tienda: ");

        Tienda tienda = new Tienda(nombreTienda,nit,telefono);

        Producto producto1 = new Producto("Iphone 18pro", "1234", "Iphone 18 pro de 256gb" , 10, 6200000, Categoria.CELULARES, tienda);
        Producto producto2 = new Producto("Acer Aspire Lite 15", "4321", "Computador de 16gb de RAM y 512 de almacenamiento" , 10, 3200000, Categoria.COMPUTADORES, tienda);
        Producto producto3 = new Producto("GTA 6", "6666", "Video juego GTA 6" , 10, 350000, Categoria.VIDEO_JUEGOS, tienda);
        Producto producto4 = new Producto("Xiaomi Smart Band 9", "3333", "Reloj deportivo Xiaomi Smart Band 9" , 10, 180000, Categoria.ACCESORIOS, tienda);
        Producto producto5 = new Producto("RTX 5090", "1111", "Tarjeta Gráfica GeForce RTX 5090 de 32GB" , 10, 19900000, Categoria.COMPONENTE, tienda);

        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        tienda.agregarProducto(producto4);
        tienda.agregarProducto(producto5);

        int opcion;

        do{
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opcion: ---Menu---\n"+
                    "1. Agregar un cliente."+
                    "\n2. Eliminar al cliente."+
                    "\n3. Buscar cliente."+
                    "\n4. Buscar producto."+
                    "\n5. Eliminar Producto."+
                    "\n6. Generar Factura."+
                    "\n7. Eliminar la factura."+
                    "\n8. Buscar factura."+
                    "\n14. Salir."));

            switch(opcion){
                case 1: crearCliente(tienda);
                    break;
                case 2: eliminarClienteMain(tienda);
                    break;
                case 3: mostrarCliente(tienda);
                    break;
                case 4: mostrarProducto(tienda);
                    break;
                case 5 : eliminarProducto(tienda);
                    break;
                case 6 : generarFactura(tienda);
                    break;
                case 7 : eliminarFacturaMain(tienda);
                    break;
                case 8 : mostrarFacturaMain(tienda);
                    break;
                case 14: JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
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
    public static void mostrarProducto(Tienda tienda){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del producto que quieres ver"+
                                                                              "\n(Computadore: 4321, Celular: 1234, Video Juego: 6666)"+
                                                                              "\n(Accesorio: 3333 y Componentes: 1111): ");
        Optional<Producto> productoMostrar = tienda.buscarProducto(codigo);
        if(productoMostrar.isPresent()){
            JOptionPane.showMessageDialog(null,productoMostrar.get().toString());
        }else{
            JOptionPane.showMessageDialog(null,"No hay productos con ese codigo.");
        }
    }
    public static void eliminarProducto(Tienda tienda){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del producto que quieres ver"+
                                                                              "\n(Computadore: 4321, Celular: 1234, Video Juego: 6666"+
                                                                              "\nAccesorio: 3333 y Componentes: 1111): ");
        boolean noEncontrado = tienda.eliminarProducto(codigo);
        if(noEncontrado==false){
                JOptionPane.showMessageDialog(null,"Producto eliminado con exito.");
        }else{
            JOptionPane.showMessageDialog(null,"El Producto que tratas de eliminar no exite.");
        }
    }
    public static void generarFactura(Tienda tienda){
        String documentoIdentidad= JOptionPane.showInputDialog(null, "Ingresa el documento de identidad del cliente:");

        Optional<Cliente> clienteMostrar = tienda.buscarCliente(documentoIdentidad);

        if(clienteMostrar.isPresent()) {
            Cliente clienteFactura = clienteMostrar.get();

            String codigoProducto = JOptionPane.showInputDialog(null,"Ingresa el codigo del producto que quieres comprar"+
                                                                                          "\n(Computadore: 4321, Celular: 1234, Video Juego: 6666)"+
                                                                                          "\n(Accesorio: 3333 y Componentes: 1111): ");

            int cantidadComprada = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresa la cantidad de productos a comprar:"));
            int nuevoStock = tienda.disminuirStock(cantidadComprada,codigoProducto);
            if(nuevoStock==-1){
                JOptionPane.showMessageDialog(null,"La cantidad de productos que deseas comprar no esta disponible"+
                                                                        "\nen el momento tenemos disponibles "+ tienda.obtenerStock(codigoProducto)+" unidades.");
                return;
            }
            double subTotal = tienda.obtenerPrecioUnidad(codigoProducto);
            if(subTotal==0){
                JOptionPane.showMessageDialog(null,"El codigo del producto no existe.");
                return;
            }

            Optional<Producto> producto = tienda.buscarProducto(codigoProducto);
            DetalleFactura detalleFactura = new DetalleFactura(cantidadComprada, subTotal, producto.get());
            ArrayList<DetalleFactura> listaDetalles=new ArrayList<>();

            Random random = new Random();
            int codigo = random.nextInt(9000) + 1000;

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
            Factura factura = new Factura("" + codigo, LocalDate.now(), subTotal * cantidadComprada, EstadoFactura.GENERADA, metodo, clienteFactura,listaDetalles);
            JOptionPane.showMessageDialog(null,"El codigo de tu factura es: "+codigo+" (recuerda guardarlo,"+
                                                                    "\npues te sera util mas adelante).");
            factura.agregarDetallesFactura(detalleFactura);
            tienda.agregarFactura(factura);
        }else{ JOptionPane.showMessageDialog(null,  "No existe un cliente que tenga ese documento de identidad."); }
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
}
