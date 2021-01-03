import java.io.*;
import java.net.Socket;

public class Conversation extends Thread {

    private Socket socket;
    private static int numClient = 0 ;
    public Conversation(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            numClient++;
            System.out.println("Nombre de client connecté "+numClient);
            InputStream in = this.socket.getInputStream();
            OutputStream out = this.socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bfr = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(out, true);

            String sendMessage = "Bienvenu, Vous etes le client numéro..."+numClient;
            pw.println(sendMessage);
            while(true) {
                String receiveMessage = bfr.readLine();
                if(receiveMessage != null) {
                    System.out.println("le client dit " + receiveMessage);
                }
                }
        }catch (IOException e){
            System.out.println("erreur lors de la construction des flux E/S !!!");
        }
    }
}
