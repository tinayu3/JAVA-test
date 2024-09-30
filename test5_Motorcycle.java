public class Motorcycle extends Vehicle
{
    //Additional properties
    private int engineDisplacement;
    private boolean isOffRoad;
    // Constructor
    public Motorcycle(String make, String model, int year, String fuelType, double price, int engineDisplacement, boolean isOffRoad)
    {
        super(make, model, year, fuelType, price);
        this.engineDisplacement = engineDisplacement;
        this.isOffRoad = isOffRoad;
    }
    // Calculate tax based on engine displacement and off-road status
    public double calculateTax()
    {
        //Discuss tax on a case-by-case basis
        double tax = (engineDisplacement < 500) ? 50 : 100;
        if (isOffRoad) tax *= 0.5;
        return tax;
    }
    // Override printInfo to include additional properties
    @Override
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Engine Displacement: " + engineDisplacement + " cc");
        System.out.println("Is Off-Road: " + isOffRoad);
        System.out.println("Tax: $" + calculateTax());
    }
}
