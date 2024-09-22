abstract public class Animal {
    private String type;

    public Animal(){

    }

    public Animal(String type) {
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return getType() + ": " + type;
    }
}
