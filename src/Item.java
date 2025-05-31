public class Item {
    public String name;
    public int worth;
    public int weight;

    public Item(String name, int worth, int weight) {
        this.name = name;
        this.worth = worth;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " (Worth: " + worth + ", Weight: " + weight + "g)";
    }
}
