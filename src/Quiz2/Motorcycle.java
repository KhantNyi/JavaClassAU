public class Motorcycle extends Vehicle implements Movable, Ridable {

    public Motorcycle(){
        super("Motorcycle");
    }

    public Motorcycle(String typeV) {
        super(typeV);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String move() {
        String action = getTypeV() + " is running.";
        System.out.println(action); // Print the message
        return action; // Return the string as required by the interface
    }

    public String ride() {
        String action2 = getTypeV() + " is ridden by a biker.";
        System.out.println(action2);
        return action2;
    }
}
