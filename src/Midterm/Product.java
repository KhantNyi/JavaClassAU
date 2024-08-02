/*
Given instruction, write a class Product with constructor, getter setters and some methods.
*/

class Product {
    private int id;
    private String name;
    private int quantity;
    private String unit;

    // default constructor
    Product() {
        this(999, "Dummy", 0, "item");
    }

    public Product(int id, String name, int quantity, String unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean restock(int numItems) {
        if (numItems > 0) {
            quantity += numItems;
            return true;
        }
        return false;
    }

    public boolean sell(int numItems) {
        if (quantity >= numItems) {
            quantity -= numItems;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (quantity > 1)
            return id + " " + name + " : " + quantity + " " + unit + "s";
        return id + " " + name + " : " + quantity + " " + unit;
    }
}
