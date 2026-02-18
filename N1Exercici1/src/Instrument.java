public abstract class Instrument {

    String name;
    double price;

    static {
        System.out.println("antes de que suene el tambor");
    }

    abstract void play();

}
