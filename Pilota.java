import java.util.ArrayList;

public class Pilota extends Thread{
    
    String nome;
    Spogliatoio spogliatoio;
    Pista pista;
    

    

    public Pilota(String nome, Spogliatoio spogliatoio, Pista pista) {
        this.nome = nome;
        this.spogliatoio = spogliatoio;
        this.pista = pista;
    }



    @Override
    public void start() {
        
        long start;
        long stop;
        ArrayList<Giro> giri;
        ArrayList<Long> classifica;
        boolean casco, tuta;

        spogliatoio.semaforo.P();
            spogliatoio.usaSpogliatoio(nome);
            casco = true;
            tuta = true;
        spogliatoio.semaforo.V();

        pista.semaforo.P();
            pista.usaPista(nome);
            start = System.nanoTime();

            try {
            
                for (int i = 0; i < 14; i++){

                    Thread.sleep((long)(Math.random() * 1000));

                }
            } catch (Exception e) {

            }

        pista.semaforo.V();
        
        stop = System.nanoTime();
        
        spogliatoio.semaforo.P();
            spogliatoio.usaSpogliatoio(nome);
            casco = false;
            tuta = false;
        spogliatoio.semaforo.V();
        try {
            
            for (int i = 0; i < 14; i++){

                long a = (stop-start)/1000000;
                classifica.add(a);
            }
        } catch (Exception e) {

        }
    }
}
