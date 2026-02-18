public class Main {
  public static void main(String[] args) {
    Car asd = new Car(125);
    Car asd2 = new Car(150);
    Car.model = "gt86";

    Car.brake();
    asd.accelerate();
  }
}
