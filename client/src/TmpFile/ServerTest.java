/* Сервер который шлет сообщения и принимает, с выводом в консоль
    Больше ничего от него не надо
* */
package TmpFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerTest {
    public static void main(String args[]){
        try{
            System.out.println("Waiting any client");
            ServerSocket server = new ServerSocket(5000);
            Socket client = server.accept();
            System.out.println("Client connect!");

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            while(!client.isClosed()){
                String mes = in.readUTF();
                System.out.println("Message: " + mes);
                out.writeUTF("OK");
                out.flush();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            client.close();
            System.out.println("Client disconnect");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}