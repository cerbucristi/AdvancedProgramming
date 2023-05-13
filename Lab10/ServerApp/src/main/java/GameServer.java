
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private ServerSocket serverSocket;
    private List<ClientThread> clients;

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clients = new ArrayList<>();
    }

    public void start() throws IOException {
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
            ClientThread clientThread = new ClientThread(clientSocket, this);
            clients.add(clientThread);
            clientThread.start();
        }
    }

    public void broadcast(String message) {
        for (ClientThread client : clients) client.sendMessage(message);
    }

    public void removeClient(ClientThread client) {
        clients.remove(client);
    }
    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer(12345);
        gameServer.start();
    }
}
