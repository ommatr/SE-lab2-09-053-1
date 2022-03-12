import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

// тут мы создаём "клиента" для нашего сервера, который тоже может с ним взаимодействовать
public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 5555);
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));


        BufferedWriter writer =
                new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("введите вариант и 5 переменных: x,a,b,c,n");
        // - Вывод
        Scanner scan = new Scanner(System.in);
        char variant = scan.next().charAt(1);
        double x = scan.nextDouble();
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double n = scan.nextDouble();
        writer.write(variant + " " + x + " " + a + " " + b + " " + c + " " + n +"\n");
        writer.flush();
        //Выводим
        String response = reader.readLine();
        System.out.println(response);


        writer.close();
        reader.close();
        clientSocket.close();
    }
}