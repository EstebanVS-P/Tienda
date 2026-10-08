package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private final String documentoIdentidad;
    private final String nombreCompleto;
    private final String telefono;
    private final String correo;
    private final String ciudadResidencia;

    private final Tienda ownedByTienda;

    private final List<Factura> listaFacturas=new LinkedList<>();

    public Cliente(String documentoIdentidad, String nombreCompleto, String telefono, String correo, String ciudadResidencia, Tienda ownedByTienda) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudadResidencia = ciudadResidencia;
        this.ownedByTienda = ownedByTienda;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public List<Factura> getListaFacturas() {
        return Collections.unmodifiableList(listaFacturas);
    }
    //El final hace que ya no haya un set y para que una variable no se pueda modificar
    //se usa el Collections.unmodifiableList(aqui va el nombre de la lista)

    @Override
    public String toString() {
        return "Cliente{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                '}';
    }
}
