public class Horse extends Animal implements Movable, Ridable {

    public Horse() {
        super("Horse");
    }

    public Horse(String type) {
        super(type);
    }

    @Override
    public String move() {
        String action = getType() + " is jogging.";
        System.out.println(action); // Print the message
        return action; // Return the string as required by the interface
    }

    @Override
    public String ride() {
        String action = getType() + " is ridden by a jockey.";
        System.out.println(action); // Print the message
        return action; // Return the string
    }
}
