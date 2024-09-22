abstract public class Vehicle {
    private String typeV;

    public Vehicle(){

    }

    public Vehicle(String typeV) {
        this.setTypeV(typeV);
    }

    public String getTypeV() {
        return typeV;
    }

    public void setTypeV(String typeV) {
        this.typeV = typeV;
    }

    public String toString() {
        return getTypeV() + ": " + typeV;
    }
}
