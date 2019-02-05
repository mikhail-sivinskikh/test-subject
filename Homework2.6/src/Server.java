import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader serverIncoming;
    private static BufferedWriter serverOut;
    private static BufferedReader serverReader;

    public static void main(String[] args) {
        try {
            try {

                server = new ServerSocket(4004);
                System.out.println("Server started OK");
                socket = server.accept();
                System.out.println("Server connected OK");
                try {

                    serverIncoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    serverOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    serverReader = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Chat started!");
                    while (true) {
                        if (serverReader.ready()) {
                            String message = serverReader.readLine();
                            if (message.equalsIgnoreCase("exit")) {
                                serverOut.write(message + "\n");
                                break;
                            }else{
                                serverOut.write(message + "\n");
                                System.out.println("You: " + message);
                                serverOut.flush();
                            }
                        }
                        if (serverIncoming.ready()) {
                            System.out.println("Client: " + serverIncoming.readLine());
                        }
                        Thread.sleep(1000);
                    }
                } finally {
                    socket.close();
                    serverIncoming.close();
                    serverOut.close();
                }
            } finally {
                System.out.println("Server terminated");
                server.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
