/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * * @author dhaffner
 */
public class SimpleObjectClient {

    public final static int SOCKET_PORT = 8081;      // you may change this
    public final static String SERVER = "127.0.0.1";  // localhost
    
    
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket(SERVER, SOCKET_PORT);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        
        CustomObject objectToSend = new CustomObject("zkušební zpráva");
        oos.writeObject(objectToSend);
        oos.flush();

        oos.close();
        socket.close();
    }
}

