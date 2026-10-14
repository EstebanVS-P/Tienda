package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio{
    private String ciudadDestino;
    private boolean entregaDomicilio;

    public EnvioNacional(String codigo, String destinatario, double peso, String ciudadDestino, boolean entregaDomicilio){
        super(codigo,destinatario,peso);
        this.ciudadDestino = ciudadDestino;
        this.entregaDomicilio = entregaDomicilio;
    }

    @Override
    public int precioFijo() {
        return 6000;
    }

    @Override
    public int recargo() {
        return 2000;
    }

    @Override
    public double total() {
        return precioFijo()+(recargo()*getPeso());
    }
}
