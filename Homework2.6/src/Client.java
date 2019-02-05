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

                System.out.println("Chat started!");
                while (true) {
                    if (reader.ready()) {
                        String message = reader.readLine();
                        if (message.equalsIgnoreCase("exit")) {
                            out.write(message + "\n");
                            break;
                        }else{
                        out.write(message + "\n");
                        System.out.println("You: " + message);
                        out.flush();
                        }
                    }
                    if (in.ready()) {
                        String incomingMessage = in.readLine();
                        System.out.println("Server: " + incomingMessage);
                    }

                    Thread.sleep(1000);
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
