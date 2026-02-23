public class Main {
  public static void main(String[] args) {
    Car cotxe1 = new Car(125);
    Car cotxe2 = new Car(150);
    Car.model = "gt86";

    System.out.println(Car.brand);

    System.out.println(cotxe1.model);
    // El ide ya me avisa de que llamarlo a través de una instáncia es inútil porque es estático

    System.out.println("Cotxe1 potencia:" + cotxe1.getPower());
    System.out.println("Cotxe2 potencia:" + cotxe2.getPower());
    Car.brake();
    cotxe1.accelerate();
    cotxe2.accelerate();
  }
}
