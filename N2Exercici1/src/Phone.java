public class Phone {
    private String brand;
    private String model;

    public void call (int number) {
        System.out.println("Trucant al número " + number);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
