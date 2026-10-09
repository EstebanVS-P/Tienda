package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaFacturas=" + listaFacturas +
                ", listaProductos=" + listaProductos +
                '}';
    }

    public String registrarCliente(String documentoIdentidad, String nombreCompleto, String telefono, String correo, String ciudadResidencia) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isEmpty()) {
            Cliente clienteNuevo = new Cliente(documentoIdentidad, nombreCompleto, telefono, correo, ciudadResidencia, this);
            listaClientes.add(clienteNuevo);
            return "El cliente fue registrado con exito";
        }
        return "No se puede registrar, pues ya existe un cliente con esta informacion";
    }

    // cambiar esto if(clienteEncontrado!=null){ por un optional
    //hacer el metodo buscar cliente con optional
    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream().filter(cliente -> documentoIdentidad.equals(cliente.getDocumentoIdentidad())).findFirst();
    }

    public boolean eliminarCliente(String documentoIdentidad) {
        boolean noEncontrado = true;
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isPresent()) {
            listaClientes.remove(clienteEncontrado.get());
            return false;
        }
        return noEncontrado;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    public Optional<Producto> buscarProducto(String codigo) {
        for (Producto ayuda : listaProductos.values()) {
            if (ayuda.getCodigo().equals(codigo)) {
                return Optional.of(ayuda);
            }
        }
        return Optional.empty();
    }

    public boolean eliminarProducto(String codigo) {
        boolean noEncontrado = true;
        Optional<Producto> productoEncontrado = buscarProducto(codigo);
        if (productoEncontrado.isPresent()) {
            listaProductos.remove(productoEncontrado.get());
            return false;
        }
        return noEncontrado;
    }

    public int obtenerStock(String codigoProducto) {
        int stock = 0;
        Optional<Producto> productoEncontrado = buscarProducto(codigoProducto);
        if (productoEncontrado.isPresent()) {
            stock = productoEncontrado.get().getCantidadDisponible();
        }
        return stock;
    }

    public int disminuirStock(int cantidadComprada, String codigoProducto) {
        int stock = obtenerStock(codigoProducto);
        int nuevoStock = 0;
        if (stock > cantidadComprada) {
            nuevoStock = stock - cantidadComprada;
        } else {
            return -1;
        }
        Optional<Producto> productoEncontrado = buscarProducto(codigoProducto);
        if (productoEncontrado.isPresent()) {
            productoEncontrado.get().setCantidadDisponible(nuevoStock);
        }
        return nuevoStock;
    }

    public double obtenerPrecioUnidad(String codigoProducto) {
        double precio = 0;
        Optional<Producto> productoEncontrado = buscarProducto(codigoProducto);
        if (productoEncontrado.isPresent()) {
            precio = productoEncontrado.get().getPrecio();
        }
        return precio;
    }

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public Optional<Factura> buscarFactura(String codigo) {
        return listaFacturas.stream().filter(factura -> factura.codigo().equals(codigo)).findFirst();
    }

    public boolean eliminarFactura(String codigo) {
        boolean noEncontrada = true;
        Optional<Factura> facturaEncontrada = buscarFactura(codigo);
        if (facturaEncontrada.isPresent()) {
            listaFacturas.remove(facturaEncontrada.get());
            return false;
        }
        return noEncontrada;
    }
    //Taller punto 1
    public List<Producto> mostrarProductosCanMayorDiez(){
        List<Producto> listaProductosMayores = new LinkedList<>();
        for(Producto ayuda: listaProductos.values()){
            if(ayuda.getCantidadDisponible()>=10){
                listaProductosMayores.add(ayuda);
            }
        }
        return listaProductosMayores;
    }
    //punto 2
    public List<String> productosMayoresCodigos(){
        List<String> listaCodigosMayores = new LinkedList<>();
        for(Producto ayuda: listaProductos.values()){
            if(ayuda.getCantidadDisponible()>=10 && ayuda.getCantidadDisponible()<50){
                listaCodigosMayores.add(ayuda.getCodigo());
            }
        }
        return listaCodigosMayores;
    }
    //punto 3
    public List<Cliente> clientesComprados7(LocalDate fechaConsula){
        List<Cliente> listaClientes7=new LinkedList<>();
        for(Factura ayuda : listaFacturas){
            if(ayuda.fecha().equals(fechaConsula)){
                listaClientes7.add(ayuda.cliente());
            }
        }
        return listaClientes7;
    }
    //punto 4
    public List<Factura> facturaClienteC(String letraBuscar){
        List<Factura> listaFacturasC = new LinkedList<>();
        for(Factura ayuda : listaFacturas){
            if(ayuda.tieneCliente(letraBuscar)==true){
                listaFacturasC.add(ayuda);
            }
        }
        return listaFacturasC;
    }
    //punto 5
    public List<Factura> facturaIphone(){
        List<Factura> listaFacturaIphone=new LinkedList<>();
        for(Factura ayuda : listaFacturas){
            if(!ayuda.detallesFacturaIphone().isEmpty()){
                listaFacturaIphone.add(ayuda);
            }
        }
        return listaFacturaIphone;
    }
    //punto 6





















}
