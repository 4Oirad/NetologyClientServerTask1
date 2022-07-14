import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(23444);
        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new
                         InputStreamReader(socket.getInputStream()))) {
                int line = Integer.parseInt(in.readLine());
                out.println(calcFibonacciNum(line));
                break;
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    static int calcFibonacciNum(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;
        int[] fibonacciSequence = new int[index + 1];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;
        for (int i = 2; i <= index; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        return fibonacciSequence[index];
    }
}