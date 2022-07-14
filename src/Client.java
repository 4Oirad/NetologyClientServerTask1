import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 23444);
// Получаем входящий и исходящий потоки информации
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            int number;
            System.out.println("Введите индекс числа Фибоначчи:");
            number = scanner.nextInt();
            out.println(number);

            System.out.println("Число Фибоначчи = " + in.readLine());

        }
    }
}
