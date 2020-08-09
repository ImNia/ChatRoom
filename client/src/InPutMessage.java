import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;

public class InPutMessage extends Thread{
    InPutMessage(String name){
        super(name);
    }
    private Socket sock;
    private DataInputStream in;

    public void ClientInput(Socket sock) throws IOException {
        this.sock = sock;
        in = new DataInputStream(sock.getInputStream());
        start();
    }

    public void run() {
        try {
            if (!sock.isClosed()) {
                String message = in.readUTF();
                System.out.println("Server answer: " + message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}