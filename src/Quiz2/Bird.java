public class Bird extends Animal implements Movable {

    public Bird(){
        super("Bird");
    }

    public Bird(String type) {
        super(type);
    }

    @Override
    public String move() {
        String action = getType() + " is flying.";
        System.out.println(action); // Print the message
        return action; // Return the string as required by the interface
    }
}
