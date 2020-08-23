/* Считывает сообщение клиента и отправляет его серверу.
* */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutPutMessage extends Thread{
    OutPutMessage(String name){
        super(name);
    }
    private Socket sockO;
    private DataOutputStream out;

    public void ClientOutput(Socket sockO) throws IOException {
        this.sockO = sockO;
        out = new DataOutputStream(sockO.getOutputStream());
        start();
    }

    public void run() {
        try {
            Scanner tmp = new Scanner(System.in);
            String message;
            while (!sockO.isClosed()) {
                message = tmp.nextLine();
                out.writeUTF(message);
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}