public class Vehicle
{
    //Private data numbers
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private double price;
    // Constructor
    public Vehicle(String make, String model, int year, String fuelType, double price)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.price = price;
    }
    // Public method to print vehicle info
    public void printInfo()
    {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Price: $" + price);
    }
}
