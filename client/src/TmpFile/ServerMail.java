package TmpFile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.net.Socket;

public class ServerMail extends Thread {
    ServerMail(String name){
        super(name);
    }
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    ArrayList<Socket> company;
    private int owner;
    public String mess;

    public void Mail(Socket _socket, ArrayList<Socket> tmp, int _owner){
        this.socket = _socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            out = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        company = new ArrayList<Socket>(tmp);
        owner = _owner;
        start();
    }

    //TODO Исправить блокировку
    public void run(){
        try {
           if(!socket.isClosed()){
               try {
                   mess = in.readUTF();
               }catch (IOException e){
                   e.printStackTrace();
               }
               System.out.println("Message " + owner + ": " + mess);
               for(int i = 0; i <= company.size(); i++){
                   DataOutputStream outTmp = new DataOutputStream(company.get(i).getOutputStream());
                   outTmp.writeUTF(mess);
                   outTmp.flush();
               }
           }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
