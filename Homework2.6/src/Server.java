import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader serverReader;

    public static void main(String[] args) {
        try {
            try {

                server = new ServerSocket(4004);
                System.out.println("Server started OK");
                socket = server.accept();
                System.out.println("Server connected OK");
                try {

                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    serverReader = new BufferedReader(new InputStreamReader(System.in));

                    Thread inputMs = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String input = in.readLine();
                                System.out.println(input);
                                if (input.equalsIgnoreCase("end")) {
                                    System.out.println("Server ended the conversation!");
                                    server.close();
                                    in.close();
                                    out.close();
                                }
                                if (!input.isEmpty()) {
                                    System.out.println("new Message! \n" + input);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    Thread outputMs = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String output = serverReader.readLine();
                                out.write(output + "\n");
                                System.out.println(output);
                                if (output.equalsIgnoreCase("end")) {
                                    System.out.println("You ended the conversation!");
                                    server.close();
                                    in.close();
                                    out.close();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    if (socket.isConnected()) {
                        inputMs.start();
                        outputMs.start();
                    } else {
                        inputMs.wait(100);
                        outputMs.wait(100);
                    }
                } finally {
                    socket.close();
                    in.close();
                    out.close();
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
