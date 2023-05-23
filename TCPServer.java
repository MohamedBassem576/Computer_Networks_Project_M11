package computer_networks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int serverPort = 5000; // Server port number

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(serverPort);

            System.out.println("Server is running and waiting for client connection...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Create input and output streams for socket communication
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);

            // Receive the sentence from the client
            String sentence = input.readLine();
            System.out.println("Received sentence from client: " + sentence);

            // Convert the sentence to uppercase
            String modifiedSentence = sentence.toUpperCase();

            // Send the modified sentence back to the client
            output.println(modifiedSentence);

            // Close the sockets and streams
            clientSocket.close();
            serverSocket.close();
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

