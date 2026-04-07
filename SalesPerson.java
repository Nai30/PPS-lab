public class SalesPerson {
    String name;
    String city;
    int commission;
    int totalSales;


    public SalesPerson(String name, String city, int commission, int totalSales) {
        this.name = name;
        this.city = city;
        this.commission = commission;
        this.totalSales = totalSales;

    }
    public String toString() {
        return "SalesPerson{name='" + name + "', city='" + city + "', commission=" + commission + ", totalSales=" + totalSales + "}";
    }
    public String getName() { return name; }
    public double getTotalSales() { return totalSales; }
    public double getCommissionRate() { return commission; }
    
}
