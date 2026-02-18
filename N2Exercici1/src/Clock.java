public interface Clock {

    default void ringAlarm(){
        System.out.println("Sona l'alarma.");
    }
}