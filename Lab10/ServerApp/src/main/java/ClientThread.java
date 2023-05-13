
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private GameServer server;

    public ClientThread(Socket clientSocket, GameServer server) throws IOException {
        this.clientSocket = clientSocket;
        this.server = server;
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void run() {
        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);


            String message;
            while ((message = input.readLine()) != null) {
                if (message.equals("stop")){
                    System.out.println("Server stopped");
                    break;}
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " sent message: " + message);
                handleMessage(message);
            }


            clientSocket.close();
            server.removeClient(this);
        } catch (IOException e) {

        }
    }

    public void sendMessage(String message) {
        output.println(message);
    }

    private void handleMessage(String message) {
        if (message.equals("stop")) {
            server.broadcast("Server stopped");
            try {
                input.close();
                output.close();
                clientSocket.close();
                server.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}