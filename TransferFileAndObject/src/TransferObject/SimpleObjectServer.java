/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhaffner
 */
public class SimpleObjectServer {

    public final static int SOCKET_PORT = 8081;  // you may change this

    
    public static void main(String[] args) throws IOException {
    
        ServerSocket serverSocket = new ServerSocket(SOCKET_PORT);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        CustomObject objectReceived;
            try {
                objectReceived = (CustomObject) ois.readObject();
                System.out.println(objectReceived.getText());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SimpleObjectServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        ois.close();
        socket.close();
        serverSocket.close();
    }
}
