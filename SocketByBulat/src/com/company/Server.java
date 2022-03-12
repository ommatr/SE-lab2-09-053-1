package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //Зашли в нужный нам порт
        ServerSocket serverSocket = new ServerSocket(8000);
        //Цикл для непрерывной работы сервера и ожидания других клиентов
        while (true) {
            //Создали серверный соккет, при этом создав туннель с клиентным сокетом
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент " + (++count) + " подключился " + " \n");

            //блок кода чтения
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            //Создали выводной поток, который умеет хранить кеш
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream()));
            //(Запрос) входные данные клиента
            String request = reader.readLine();


            ArrayList<String> listslov=new ArrayList<>();
            StringBuffer sb = new StringBuffer(request);
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



            //------

            //------

            System.out.println("Получено: Вариант = " + nomervarianta + " x = " + listznachenii.get(0)  + "\n");


            double rez = V14.v14(listznachenii.get(0));
            System.out.println("Рассчитано: Result= " + rez + "\n");
            //(Ответ) выходные данные
            String response = "Рассчитано: Result= " + rez + "\n";
            //Выводим все данные
            writer.write(response);
            writer.flush();
            //Три метода закрывающие "работу"

            writer.close();
            reader.close();
            clientSocket.close();
            //}
        }
        //так как работа серва в цикле нам не нужно закрывать работу сервера
        //serverSocket.close();

    }

        }




    //ArrayList<String> listslov=new ArrayList<>();
    //        StringBuffer sb = new StringBuffer("V12 62 7");
    //        sb.delete(0,1);
    //        String str=new String(sb);
    //        for (String retval : str.split(" ")) {
    //            listslov.add(retval);
    //
    //        }
    //        int nomervarianta= Integer.parseInt(listslov.get(0));
    //        listslov.remove(0);
    //        ArrayList<Integer> listznachenii=new ArrayList<>();
    //        for (String values:listslov) {
    //            listznachenii.add(Integer.parseInt(values));
    //        }
    //        System.out.println(listznachenii);
