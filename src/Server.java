    import java.io.*;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.ArrayList;
    import java.util.List;

    public class Server extends  Thread {
        ServerSocket ss = null;
        List<String> listClient= new ArrayList<>();
        @Override
        public void run() {
            try {
                ss = new ServerSocket(4201);
                while (true) {
                    System.out.println("Attente d'une connexion client ...");
                    Socket so = ss.accept();
                    Conversation c = new Conversation(so);
                    c.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
        Server s = new Server();
        s.run();
        }
            }
