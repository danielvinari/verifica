public class App {
    public static void main(String[] args) throws Exception {
        
        Semaforo semaforo = new Semaforo(1);
        Spogliatoio spogliatoio = new Spogliatoio(semaforo);
        Pista pista = new Pista(semaforo);

        Pilota p1 = new Pilota("Mario", spogliatoio, pista);
        Pilota p2 = new Pilota("Dario", spogliatoio, pista);
        Pilota p3 = new Pilota("Marco", spogliatoio, pista);
        Pilota p4 = new Pilota("Mirco", spogliatoio, pista);
        Pilota p5 = new Pilota("Matteo", spogliatoio, pista);
        Pilota p6 = new Pilota("Mattia", spogliatoio, pista);
        Pilota p7 = new Pilota("Beppe", spogliatoio, pista);
        Pilota p8 = new Pilota("Giuseppe", spogliatoio, pista);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();

        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
        p6.join();
        p7.join();
        p8.join();

    }
}
