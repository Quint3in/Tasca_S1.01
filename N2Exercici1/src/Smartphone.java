public class Smartphone extends Phone implements Clock, Camera {

    public Smartphone(String brand, String model) {
        this.setModel(model);
        this.setBrand(brand);
    }

}
