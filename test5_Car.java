public class Car extends Vehicle
{
    //Additional properties
    private int numDoors;
    private double trunkCapacity;
    // Constructor
    public Car(String make, String model, int year, String fuelType, double price, int numDoors, double trunkCapacity)
    {
        super(make, model, year, fuelType, price);
        this.numDoors = numDoors;
        this.trunkCapacity = trunkCapacity;
    }
    // Calculate insurance premium based on number of doors and trunk capacity
    public double calculateInsurance()
    {
        return numDoors * 100 + trunkCapacity * 10;
    }
    // Override printInfo to include additional properties
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Number of Doors: " + numDoors);
        System.out.println("Trunk Capacity: " + trunkCapacity + " cu ft");
        System.out.println("Insurance Premium: $" + calculateInsurance());
    }
}
