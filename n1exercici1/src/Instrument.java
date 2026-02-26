public abstract class Instrument {

    private String name;
    private double price;

    public Instrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    static {
        System.out.println("mensaje estático antes de que suene el tambor");
    }
    {
        System.out.println("Clase instanciada");
    }

    public abstract void play();

}
