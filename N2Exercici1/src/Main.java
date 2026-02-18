public class Main {
    public static void main(String[] args) {
        Smartphone asd = new Smartphone("Samsung","A10");
        asd.call(23);
        asd.ringAlarm();
        asd.takePhoto();
        System.out.println(asd.getBrand());
        System.out.println(asd.getModel());
    }
}