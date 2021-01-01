import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try{
        ServerSocket ss= new ServerSocket(4201);
        System.out.println("Attente d'une connexion client ...");
        Socket so = ss.accept();
        System.out.println("Un client vient de se connecter ...");

        InputStream in = so.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader bfr= new BufferedReader(isr);

        OutputStream out = so.getOutputStream();
        PrintWriter pw=new PrintWriter(out,true);

      /*  String ident =bfr.readLine();
        System.out.println("le client est connexté ");*/
        pw.println("Bienvenu à toi ");
        System.out.println("DEBUT DE LA CONVERSATION AVEC LE CLIENT . . .");
        String sendMessage ="Vous etes maintenant connecté au serveur...";
        pw.println(sendMessage);
        while (true)
        {
            String receiveMessage =bfr.readLine();
            System.out.println("le client dit " + receiveMessage);
            try {
                Thread.sleep(1);
            }catch(Exception e) {
                System.out.println("erreur sur le timer ");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

        }



}
