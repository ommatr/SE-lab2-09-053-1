package Sadovnichaya;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            writer.write("Введите вариант (v_) и числа a, b, c, x\n");
            writer.flush();

            String word = reader.readLine();
            String[] words=word.split(" ");
            Double result=0.0;
            if (words[0].equals("v8")||words[0].equals("V8")) {
                result = V8.func8(Double.valueOf(words[1]), Double.valueOf(words[2]), Double.valueOf(words[3]), Double.valueOf(words[4]));
            }
            System.out.println("Получено: Вариант = "+words[0].toUpperCase()+" a = "+words[1]+" b = "+words[2]+" c = "+words[3]+" x = "+words[4]);
            System.out.println("Рассчитано: Результат = "+result);
            writer.write("Result = " + result + "\n");
            writer.flush();

            reader.close();
            writer.close();
            clientSocket.close();
        }
    }
}
