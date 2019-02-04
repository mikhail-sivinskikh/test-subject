import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedWriter out;
    private static BufferedReader in;
    private static BufferedReader reader;

    public static void main(String[] args) {
        try {
            try {

                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//
//                Thread inputMs = new Thread(() -> {
//                    try {
//                        while (true) {
//                            if (in.ready()) {
//                                String message = in.readLine();
//                                System.out.println("Client: " + message);
//                                if (in.readLine().equalsIgnoreCase("exit")){
//                                    break;
//                                }
//                            }
//                            Thread.sleep(300);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//
//                Thread outputMs = new Thread(() -> {
//                    try {
//                        while (true) {
//                            if (reader.ready()) {
//                                String message = reader.readLine();
//                                if (!message.equalsIgnoreCase("exit")) {
//                                    out.write(message);
//                                    System.out.println("You: " + message);
//                                    out.flush();
//                                }
//                                break;
//                            }
//                            Thread.sleep(300);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//                System.out.println("Chat started!");
//                inputMs.start();
//                outputMs.start();

                while (true) {
                    System.out.println(123);
                    if (reader.ready()) {
                        String message = reader.readLine();
                        if (message.equalsIgnoreCase("exit")) {
                            break;
                        }else{
                        out.write(message);
                        System.out.println("You: " + message);
                        out.flush();
                        }
                    }
                    if (in.ready()) {
                        System.out.println("we are here");
                        String incomingMessage = in.readLine();
                        System.out.println("Server: " + incomingMessage);
                    }
                    Thread.sleep(500);
                }

            } finally {
                System.out.println("Client terminated");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
