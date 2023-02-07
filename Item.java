package assn02;

public class Item {
    private String info;
    private String date;
    private String assemblyTime;
    private String category;
    private double fee;
    private int quantity;
    private double totalTime;
    private double cost;
    public Item(String info) {
        this.info = info;
        String split[] = info.split(" ");
        this.date = split[0];
        this.assemblyTime = split[1];
        this.category = split[2];
        this.fee = Double.valueOf(split[3]);
        this.quantity = Integer.valueOf(split[4]);
        this.totalTime = Double.valueOf(split[5]);
        this.cost = Double.valueOf(split[6]);
    }

    public Item() {
        this.info = "";
    }

    public String getDate() {
        return this.date;
    }

    public String getAssemblyTime() {
        return this.assemblyTime;
    }

    public String getCategory() {
        return this.category;
    }
    public double getFee() {
        return this.fee;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalTime() {
        return this.totalTime;
    }

    public double getCost() {
        return this.cost;
    }

}
