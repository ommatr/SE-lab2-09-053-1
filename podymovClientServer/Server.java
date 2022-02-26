package podymovClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");
                clientSocket = server.accept();
                try {

                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    String var = word.substring(0, word.indexOf(" "));
                    double value = Double.parseDouble(word.substring(word.indexOf(" ") + 1));
                    System.out.println("Получено: " + "Вариант = "+ var + " x = " + value);

                    if (var.equals("V7") || var.equals("v7")){
                        String line = "Result: " + V7.func(value);
                        System.out.println("Рассчитано: " + line);
                        out.write(line);
                    } else {
                        System.out.println("Wrong var...");
                        out.write("Неверный ввод...");
                    }
                    out.flush();

                } finally {
                    clientSocket.close();

                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
