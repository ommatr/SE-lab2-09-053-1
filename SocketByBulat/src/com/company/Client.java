package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static  void main(String[] args) throws IOException {
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
        System.out.println("введите вариант и переменную: ");

        Scanner scanner = new Scanner(System.in);
        String some=scanner.nextLine();






        ArrayList<String> listslov=new ArrayList<>();
                StringBuffer sb = new StringBuffer(some);
                sb.delete(0,1);
                String str=new String(sb);
                for (String retval : str.split(" ")) {
                    listslov.add(retval);

                }
                int nomervarianta= Integer.parseInt(listslov.get(0));
                listslov.remove(0);
                ArrayList<Integer> listznachenii=new ArrayList<>();
                for (String values:listslov) {
                    listznachenii.add(Integer.parseInt(values));
                }
                System.out.println(listznachenii);
        //----------Алгоритм ввода



        // аналогичное отправление, что и на сервере
        writer.write(nomervarianta + " " + listznachenii.get(0) + "\n");
        writer.flush();
        //Выводим то, что отправил сервер
        String response = reader.readLine();
        System.out.println(response);


        writer.close();
        reader.close();
        clientSocket.close();
    }
}


