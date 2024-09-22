// it was abstract, interface quiz


public class Main {
    public static void main (String[] args) {
        Movable[] testMove = {new Bird(), new Horse(), new Motorcycle(), new Car()};
        for (Movable each : testMove) {
            each.move();
            if (each instanceof Ridable)
                ((Ridable) each).ride();
        }
    }

}
