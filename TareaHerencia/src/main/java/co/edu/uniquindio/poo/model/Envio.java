package co.edu.uniquindio.poo.model;

public abstract class Envio {

    private final String codigo;
    private final String destinatario;
    private final double peso;

    public Envio(String codigo, String destinatario, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public abstract int precioFijo();

    public abstract int recargo();

    public abstract double total();


}
