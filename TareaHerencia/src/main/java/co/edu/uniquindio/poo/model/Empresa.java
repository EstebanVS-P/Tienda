package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Empresa {

    private final String nombre;

    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(ArrayList<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    public String registrarEnvioInternacional(String codigo, String destinatario, double peso,String paisDestino, boolean seguro){

        Optional<Envio> envioOptional = buscarEnvios(codigo);
        if(envioOptional.isPresent()){
            return "Ya existe un envio con estos datos.";
        }else{
            Envio envio = new EnvioInternacional(codigo, destinatario, peso, paisDestino,seguro);
            listaEnvios.add(envio);
            return "Envio registrado con exito.";
        }
    }

    public String registrarEnvioNacional(String codigo, String destinatario, double peso,String ciudadDestino, boolean entregaDomicilio){

        Optional<Envio> envioOptional = buscarEnvios(codigo);
        if(envioOptional.isPresent()){
            return "Ya existe un envio con estos datos.";
        }else{
            Envio envio = new EnvioNacional(codigo, destinatario, peso, ciudadDestino,entregaDomicilio);
            listaEnvios.add(envio);
            return "Envio registrado con exito.";
        }
    }

    public String registrarEnvioExpres(String codigo, String destinatario, double peso,String ciudadDestino, boolean entregaDomicilio, byte horasEntrega){

        Optional<Envio> envioOptional = buscarEnvios(codigo);
        if(envioOptional.isPresent()){
            return "Ya existe un envio con estos datos.";
        }else{
            Envio envio = new EnvioExpres(codigo, destinatario, peso, ciudadDestino,entregaDomicilio,horasEntrega);
            listaEnvios.add(envio);
            return "Envio registrado con exito.";
        }
    }
    public Optional<Envio> buscarEnvios(String codigo){
        return listaEnvios.stream().filter(envio -> envio.getCodigo().equals(codigo)).findFirst();
    }

    public String totalInternacional(String codigo){
        for(Envio envio: listaEnvios){
            if(envio instanceof EnvioInternacional){
                if(envio.getCodigo().equals(codigo)){
                    return "El total de tu envio es: "+((EnvioInternacional)envio).total();
                }
            }
        }
        return "No se encontró un envío internacional con ese código.";
    }

    public String totalNacional(String codigo){
        for(Envio envio: listaEnvios){
            if(envio instanceof EnvioNacional){
                if(envio.getCodigo().equals(codigo)){
                    return "El total de tu envio es: "+((EnvioNacional)envio).total();
                }
            }
        }
        return "No se encontro un envio nacional con ese codigo.";
    }

    public String totalExpres(String codigo){
        for(Envio envio: listaEnvios){
            if(envio instanceof EnvioExpres){
                if(envio.getCodigo().equals(codigo)){
                    return "El total de tu envio es: "+((EnvioExpres)envio).total();
                }
            }
        }
        return "No se encontro un envio expres con ese codigo.";
    }
}
