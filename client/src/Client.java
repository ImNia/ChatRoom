import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Client{
    public static void main(String arg[]){
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Server find!");

            //TODO Посмотреть другой ввод вывод
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            if(!socket.isClosed()) {
                out.writeUTF("Give me message?");
                out.flush();
                String mes = in.readUTF();
                System.out.println("Server answer: " + mes);
            }
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}