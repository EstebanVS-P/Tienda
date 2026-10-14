package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Empresa;

import javax.swing.*;

public class Main {
    public static void main(String args[]){

        String nombre = JOptionPane.showInputDialog(null,"Ingresa el nombre de la empresa de envios:");
        Empresa empresa = new Empresa(nombre);

        byte opcion;
        do {

                  opcion = Byte.valueOf(JOptionPane.showInputDialog(null,"Ingresa los envios a consultar:" +
                                                                                              "\n1. Registrar un envio internacional." +
                                                                                              "\n2. Registrar un envio nacional." +
                                                                                              "\n3. Registrar un envio expres."+
                                                                                              "\n4. Calcular total de un envio internacional."+
                                                                                              "\n5. Calcular total de un envio nacional."+
                                                                                              "\n6. Calcular total de un envio expres."+
                                                                                              "\n7. Salir."));

            switch (opcion) {
                case 1:generarEnvioInternacional(empresa);
                    break;
                case 2:generarEnvioNacional(empresa);
                    break;
                case 3:generarEnvioExpres(empresa);
                    break;
                case 4:totalEnvioInternacional(empresa);
                    break;
                case 5:totalEnvioNacional(empresa);
                    break;
                case 6:totalEnvioExpres(empresa);
                    break;
                case 7: JOptionPane.showMessageDialog(null,"Gracias por usar el sistema.");
                    break;
                default: JOptionPane.showMessageDialog(null,"Opcion no valida.");
                    break;
            }
        }while(opcion!=7);
    }
    public static void generarEnvioInternacional(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio:");
        String destinatario = JOptionPane.showInputDialog(null,"Ingresa el destinatario del paquete:");
        double peso = Double.valueOf(JOptionPane.showInputDialog(null,"Ingresa el peso del paquete:"));

        String paisDestino = JOptionPane.showInputDialog(null,"Ingresa el pais de destino del paquete:");
        boolean seguro = Boolean.valueOf(JOptionPane.showInputDialog(null,"¿Necesitas seguro para tu paquete? (si=true/no=false)"));

        String resultado = empresa.registrarEnvioInternacional(codigo,destinatario,peso, paisDestino, seguro);
        JOptionPane.showMessageDialog(null,resultado);
    }
    public static void generarEnvioNacional(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio:");
        String destinatario = JOptionPane.showInputDialog(null,"Ingresa el destinatario del paquete:");
        double peso = Double.valueOf(JOptionPane.showInputDialog(null,"Ingresa el peso del paquete:"));

        String ciudadDestino = JOptionPane.showInputDialog(null,"Ingresa la ciudad de destino del paquete:");
        boolean entregaDomicilio = Boolean.valueOf(JOptionPane.showInputDialog(null,"¿Necesitas entrega a domicilio para tu paquete? (si=true/no=false)"));

        String resultado = empresa.registrarEnvioNacional(codigo,destinatario,peso,ciudadDestino,entregaDomicilio);
        JOptionPane.showMessageDialog(null,resultado);
    }
    public static void generarEnvioExpres(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio:");
        String destinatario = JOptionPane.showInputDialog(null,"Ingresa el destinatario del paquete:");
        double peso = Double.valueOf(JOptionPane.showInputDialog(null,"Ingresa el peso del paquete:"));

        String ciudadDestino = JOptionPane.showInputDialog(null,"Ingresa la ciudad de destino del paquete:");
        boolean entregaDomicilio = Boolean.valueOf(JOptionPane.showInputDialog(null,"¿Necesitas entrega a domicilio para tu paquete? (si=true/no=false)"));
        byte horasEntrega = Byte.valueOf(JOptionPane.showInputDialog(null,"Ingresa las horas maximas para la entrega:"));

        String resultado = empresa.registrarEnvioExpres(codigo,destinatario,peso,ciudadDestino,entregaDomicilio,horasEntrega);
        JOptionPane.showMessageDialog(null,resultado);
    }

    public static void totalEnvioInternacional(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio iternacional:");

        String resultado = empresa.totalInternacional(codigo);
        JOptionPane.showMessageDialog(null,resultado);
    }

    public static void totalEnvioNacional(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio nacional:");

        String resultado = empresa.totalNacional(codigo);
        JOptionPane.showMessageDialog(null,resultado);
    }

    public static void totalEnvioExpres(Empresa empresa){
        String codigo = JOptionPane.showInputDialog(null,"Ingresa el codigo del envio expres:");

        String resultado = empresa.totalExpres(codigo);
        JOptionPane.showMessageDialog(null,resultado);
    }
}
