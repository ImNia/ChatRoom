/* Сервер который шлет сообщения и принимает, с выводом в консоль
    Больше ничего от него не надо
* */
package TmpFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


class ServerTest {
    public static void main(String args[]){
        try{
            System.out.println("Waiting any client");
            ServerSocket server = new ServerSocket(5000);
            Socket client1 = server.accept();
            System.out.println("First client connect!");
            Socket client2 = server.accept();

            ArrayList<Socket> company = new ArrayList<Socket>();
            company.add(client1);
            company.add(client2);

            ServerMail first = new ServerMail("FirstPerson");
            ServerMail second = new ServerMail("SecondPerson");

            first.Mail(client1, company, 1);
            second.Mail(client2, company, 2);

            //TODO Сделать ожидание закрытия сокетов
            try{
                Thread.sleep(100000);
            }catch (InterruptedException exc){
                System.out.println("Prervalcz");
            }

            client1.close();
            client2.close();
            System.out.println("Client disconnect");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}