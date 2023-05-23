package computer_networks;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String serverIP = "192.168.1.30"; // Server IP address
        int serverPort = 5000; // Server port number

        try {
            // Connect to the server
            Socket socket = new Socket(serverIP, serverPort);

            // Create input and output streams for socket communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            // Read user input from the console
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a sentence: ");
            String sentence = reader.readLine();

            // Send the sentence to the server
            output.println(sentence);

            // Receive the response from the server
            String modifiedSentence = input.readLine();
            System.out.println("Server response: " + modifiedSentence);

            // Close the socket and streams
            socket.close();
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
