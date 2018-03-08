/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileServer {

  public final static int SOCKET_PORT = 13267;  // you may change this
  public final static String FILE_TO_SEND = "C:/Users/Student/Desktop/enigma1.txt";  // you may change this

  
  public static void main (String [] args ) throws IOException {
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    try {
      serverSocket = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
          socket = serverSocket.accept();
          System.out.println("Accepted connection : " + socket);
          // send file
          File myFile = new File (FILE_TO_SEND);
          byte [] myByteArray  = new byte [(int)myFile.length()];
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          bis.read(myByteArray,0,myByteArray.length);
          os = socket.getOutputStream();
          System.out.println("Sending " + FILE_TO_SEND + "(" + myByteArray.length + " bytes)");
          os.write(myByteArray,0,myByteArray.length);
          os.flush();
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (socket!=null) socket.close();
        }
      }
    }
    finally {
      if (serverSocket != null) serverSocket.close();
    }
  }
}