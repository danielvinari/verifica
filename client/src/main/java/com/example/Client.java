package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            System.out.println("Comandi: AGGIUNTA DI PERSONE, RICHIESTA ELENCO PER NAZIONE, RICHIESTA ELENCO COMPLETO, CHIUDI: ");
            String command = keyboard.readLine();
            
            
            out.println(command);

            if (command.equalsIgnoreCase("AGGIUNTA DI PERSONE")){
                System.out.println(in.readLine());
                out.println(keyboard.readLine());
                

                System.out.println(in.readLine());
                out.println(keyboard.readLine());

                System.out.println(in.readLine());
                out.println(keyboard.readLine());

            }

            if (command.equalsIgnoreCase("RICHIESTA ELENCO PER NAZIONE")) {
                System.out.println(in.readLine());
                out.println(keyboard.readLine());
                System.out.println(in.readLine());
                System.out.println(in.readLine());
                System.out.println(in.readLine());
            }

            if (command.equalsIgnoreCase("RICHIESTA ELENCO COMPLETO")) {
                System.out.println(in.readLine());
                System.out.println(in.readLine());
                System.out.println(in.readLine());
            }
            
            if (command.equalsIgnoreCase("CHIUDI"))
                break;

            String serverResponse = in.readLine();
            System.out.println("SERVER: " + serverResponse);
        }
        in.close();
        out.close();
        s.close();
    }
}