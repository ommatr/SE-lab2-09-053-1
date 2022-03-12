import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //Порт для связи с клиентом
        ServerSocket serverSocket = new ServerSocket(5555);
        //Цикл для непрерывной работы сервера
        while (true) {

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент " + (++count) + " подключился " + " \n");

            //чтение
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            //Вывод
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream()));
            //Запрос
            String request = reader.readLine();

            String[] parts = request.split(" ");

            System.out.println("Получено: Вариант = " + parts[0] + " x = " + parts[1] + " a= " + parts[2] + " b= " + parts[3] + " c=" + parts[4] + "\n" +  "n=" + parts[5] + "\n");
            double x = Double.parseDouble(parts[1]);
            double a = Double.parseDouble(parts[2]);
            double b = Double.parseDouble(parts[3]);
            double c = Double.parseDouble(parts[4]);
            double n = Double.parseDouble(parts[5]);
            double rez = V16.func(x, a, b, c, n);
            System.out.println("Рассчитано: Result= " + rez + "\n");
            //Ответ
            String response = "Рассчитано: Result= " + rez + "\n";
            //Все данные
            writer.write(response);
            writer.flush();
            //Закрывающие методы

            writer.close();
            reader.close();
            clientSocket.close();
            //}
        }


    }
}