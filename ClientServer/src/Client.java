import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

// тут мы создаём "клиента" для нашего сервера, который тоже может с ним взаимодействовать
public class Client {
    public static void main(String[] args) throws IOException {
        //подключаемся к серваку
        Socket clientSocket = new Socket("127.0.0.1", 8000);
        //обёртка инпут стрим , которая позваляет считывать входящие данные правильно но она не может считать всё
        //InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());

        //другая обёртка(уже какая то капуста из трёх) позволяет считать уже всё сразу
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

        //вывод
        BufferedWriter writer =
                new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("введите вариант и 4 переменных: x,y,a,w");
        //----------Алгоритм ввода
        Scanner scan = new Scanner(System.in).useDelimiter( "(\\b|\\B)" ) ;
        String str = scan.toString();
        while( scan.hasNext() ) {
            String  c = scan.next();

            if (c.equalsIgnoreCase("\r")) {
                break;
            }
            else {
                str += c;
            }
        }
        
        //----------------
        
        // аналогичное отправление, что и на сервере
        writer.write(str+"\n");
        writer.flush();
        //Выводим то, что отправил сервер
        String response = reader.readLine();
        System.out.println(response);


        writer.close();
        reader.close();
        clientSocket.close();
    }
}
