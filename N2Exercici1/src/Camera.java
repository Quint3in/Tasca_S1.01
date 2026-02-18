public interface Camera {

    default void takePhoto(){
        System.out.println("Fent una foto.");
    }

}
