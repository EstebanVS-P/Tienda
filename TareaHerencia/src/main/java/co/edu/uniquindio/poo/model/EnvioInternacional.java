package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio{

    private String paisDestino;
    private boolean seguro;

    public EnvioInternacional(String codigo, String destinatario, double peso, String paisDestino, boolean seguro){
        super(codigo,destinatario,peso);
        this.paisDestino=paisDestino;
        this.seguro = seguro;
    }

    @Override
    public int precioFijo() {
        return 15000;
    }

    @Override
    public int recargo() {
        return 9000;
    }

    @Override
    public double total() {
        return precioFijo()+(recargo()*getPeso());
    }
}
