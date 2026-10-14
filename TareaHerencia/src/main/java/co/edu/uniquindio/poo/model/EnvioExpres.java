package co.edu.uniquindio.poo.model;

public class EnvioExpres extends Envio{
    private String ciudadDestino;
    private boolean entregaDomicilio;
    private byte horasEntrega;

    public EnvioExpres(String codigo, String destinatario, double peso, String ciudadDestino, boolean entregaDomicilio, byte horasEntrega){
        super(codigo,destinatario,peso);
        this.ciudadDestino = ciudadDestino;
        this.entregaDomicilio = entregaDomicilio;
        this.horasEntrega = horasEntrega;
    }

    @Override
    public int precioFijo() {
        return 7800;
    }

    @Override
    public int recargo() {
        return 2600;
    }

    @Override
    public double total() {
        if(horasEntrega<=24){
            return precioFijo()+(recargo()*getPeso())+5000;
        }else{
            return precioFijo()+(recargo()*getPeso());
        }
    }
}
