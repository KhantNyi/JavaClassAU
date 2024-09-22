public class Car extends Vehicle implements Movable {

    public Car() {
        super("Car");
    }

    public Car(String typeV) {
        super(typeV);
    }

    @Override
    public String move() {
        String action = getTypeV() + " is running.";
        System.out.println(action); // Print the message
        return action; // Return the string as required by the interface
    }
}
