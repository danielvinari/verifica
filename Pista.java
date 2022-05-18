public class Pista {

    Semaforo semaforo;

    public Pista(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void usaPista(String s){

        System.out.println(s + " è entrato in pista. ");

        System.out.println(s + " è uscito dalla pista. ");
        
    }
    
}
