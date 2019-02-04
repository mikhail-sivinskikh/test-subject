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

//                    Thread inputMs = new Thread(() -> {
//                        try {
//                            while (true) {
//                                if (serverIncoming.ready()) {
//                                    String message = serverIncoming.readLine();
//                                    System.out.println("Client: " + message);
//                                    if (serverIncoming.readLine().equalsIgnoreCase("exit")) {
//                                        break;
//                                    }
//                                }
//                                Thread.sleep(300);
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    });
//
//                    Thread outputMs = new Thread(() -> {
//                        try {
//                            while (true) {
//                                if (serverReader.ready()) {
//                                    String message = serverReader.readLine();
//                                    if (!message.equalsIgnoreCase("exit")) {
//                                        out.write(message);
//                                        System.out.println("You: " + message);
//                                        out.flush();
//                                    }
//                                    break;
//                                }
//                                Thread.sleep(300);
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    });
//                    System.out.println("Chat started!");
//                    inputMs.start();
//                    outputMs.start();

                    while (true) {
                        System.out.println(123);
                        if (serverReader.ready()) {
                            String message = serverReader.readLine();
                            if (message.equalsIgnoreCase("exit")) {
                                break;
                            }else{
                                serverOut.write(message);
                                System.out.println("You: " + message);
                                serverOut.flush();
                            }
                        }
                        if (serverIncoming.ready()) {
                            System.out.println("Server: " + serverIncoming.readLine());
                            serverIncoming.reset();
                        }
                        Thread.sleep(500);
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
