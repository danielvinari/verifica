public class Spogliatoio {

    Semaforo semaforo;

    public Spogliatoio(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void usaSpogliatoio(String s){

        System.out.println(s + " ha occupato lo sogliatoio. ");

        System.out.println(s + " ha occupato lo spogliatoio. ");
        
    }
    
}
