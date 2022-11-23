package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends Thread {

    private PrintWriter out = null;
    private BufferedReader in = null;

    public ClientHandler(Socket s, List<ClientHandler> clients) {
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        ArrayList<Persona>persone = new ArrayList<>();
        String nazioneRichiesta;
        String r;

        boolean running = true;
        while (running) {
            try {
                
                r = in.readLine();

                switch (r) {
                    case "AGGIUNTA DI PERSONE":
                        out.println("Inserisci il Nome:");
                        String nome = in.readLine();
                        
                        out.println("Inserisci il Cognome:");
                        String cognome = in.readLine();
                        
                        out.println("Inserisci la nazione di residenza:");
                        String nazResidenza = in.readLine();
                        out.println("Inserimento completato.");

                        Persona a = new Persona(nome, cognome, nazResidenza);
                        persone.add(a);
                        break;
                
                    case "RICHIESTA ELENCO PER NAZIONE":
                        out.println("Inserisci la nazione: ");
                        nazioneRichiesta = in.readLine();
                        ArrayList<Persona>filtro = new ArrayList<>();
                        
                        for (int i = 0; i < persone.size(); i++) {
                            if (persone.get(i).getNazioneDiResidenza().equals(nazioneRichiesta)) {
                                filtro.add(persone.get(i));
                            }
                        }
                        for (int i = 0; i < filtro.size(); i++) {
                            out.println("Pos. lista: #" + i);
                            out.println("Nome:" + filtro.get(i).getNome());
                            out.println("Cognome:" + filtro.get(i).getCognome());
                            out.println("Nazione di residenza:" + filtro.get(i).getNazioneDiResidenza());
                        }
                        break;

                    case "RICHIESTA ELENCO COMPLETO":
                        for (int i = 0; i < persone.size(); i++) {
                            out.println("Pos. lista: #" + i);
                            out.println("Nome:" + persone.get(i).getNome());
                            out.println("Cognome:" + persone.get(i).getCognome());
                            out.println("Nazione di residenza:" + persone.get(i).getNazioneDiResidenza());
                         
                        }
                        break;
                    
                    case "CHIUDI":
                        out.println("Hai chiuso la connessione");
                        running = false;
                        break;
                        
                    default:
                        out.println("Comando non valido");
                        break;
                }

            } catch (IOException e) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
                out.close();
            }
        }

    }
}
