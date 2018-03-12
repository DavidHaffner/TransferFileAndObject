/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SimpleFileClient {

  public final static int SOCKET_PORT = 8081;      // you may change this
  public final static String SERVER = "127.0.0.1";  // localhost
  public final static String
       FILE_TO_RECEIVED = "C:/Users/ShangTzu/Desktop/CV/Haffner_životopis.pdf";  // you may change this

  public final static int FILE_SIZE = 6022386; // file size temporary hard coded
                                               // should bigger than the file to be downloaded

  
  public static void main(String[] args) throws IOException {
        Socket socket = null;

        socket = new Socket(SERVER, SOCKET_PORT); 

        File file = new File(FILE_TO_RECEIVED);
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream is = new FileInputStream(file);
        OutputStream os = socket.getOutputStream();

        int count;
        while ((count = is.read(bytes)) > 0) {
            os.write(bytes, 0, count);
        }

        os.close();
        is.close();
        socket.close();
    }
}