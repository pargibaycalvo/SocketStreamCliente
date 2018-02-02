/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.ejemplosocketstreamcliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author ped90
 */
public class PSPEjemploSocketStreamCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Creando ClienteSocket");
            Socket clienteSocket = new Socket();
            System.out.println("Estableciendo la conexión");

            //añadir ip del servidor, puede ser de un equipo en la red local
            InetSocketAddress addr = new InetSocketAddress("localhost", 27017);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje = "hola caracola";
            os.write(mensaje.getBytes());

            System.out.println("Mensaje enviado");

            System.out.println("Cerrando ClienteSocket");

            clienteSocket.close();

            System.out.println("Terminado Con Éxito");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
