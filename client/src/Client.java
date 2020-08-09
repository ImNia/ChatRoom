import java.io.IOException;
import java.net.Socket;
import java.lang.InterruptedException;

class Client{
    public static void main(String arg[]){
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Server find!");

            InPutMessage inPut = new InPutMessage("first");
            OutPutMessage outPut = new OutPutMessage("second");

            //TODO Посмотреть другой ввод вывод

            inPut.ClientInput(socket);
            outPut.ClientOutput(socket);

            try{
                Thread.sleep(50000);
            }catch (InterruptedException exc){
                System.out.println("Prervalcay");
            }
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}