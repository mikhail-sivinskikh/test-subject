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



    public static class outputMsg implements Runnable {

        @Override
        public void run() {
            try {
                String output = reader.readLine();
                if (output.equalsIgnoreCase("end")) {
                    System.out.println("You ended the conversation!");
                    clientSocket.close();
                    in.close();
                    out.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            try {

                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                Thread inputMs = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String input = in.readLine();
                            System.out.println(input);
                            if (input.equalsIgnoreCase("end")) {
                                System.out.println("Server ended the conversation!");
                                clientSocket.close();
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
                            String output = reader.readLine();
                            out.write(output + "\n");
                            System.out.println(output);
                            if (output.equalsIgnoreCase("end")) {
                                System.out.println("You ended the conversation!");
                                clientSocket.close();
                                in.close();
                                out.close();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                if (clientSocket.isConnected()) {
                    inputMs.start();
                    outputMs.start();
                } else {
                    inputMs.wait(100);
                    outputMs.wait(100);
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
