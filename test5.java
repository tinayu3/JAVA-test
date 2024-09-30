import java.util.Scanner;
public class A5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // Create Motorcycle instance and set properties
        System.out.println("Enter Motorcycle Details:");
        System.out.print("Make: ");
        String mMake = scanner.nextLine();
        System.out.print("Model: ");
        String mModel = scanner.nextLine();
        System.out.print("Year: ");
        int mYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Fuel Type: ");
        String mFuelType = scanner.nextLine();
        System.out.print("Price: ");
        double mPrice = scanner.nextDouble();
        System.out.print("Engine Displacement: ");
        int mEngineDisplacement = scanner.nextInt();
        System.out.print("Is Off Road (true/false): ");
        boolean mIsOffRoad = scanner.nextBoolean();
        scanner.nextLine();  // Consume newline here
        Motorcycle motorcycle = new Motorcycle(mMake, mModel, mYear, mFuelType, mPrice, mEngineDisplacement, mIsOffRoad);
        // Create Car instance and set properties
        System.out.println("\nEnter Car Details:");
        System.out.print("Make: ");
        String cMake = scanner.nextLine();
        System.out.print("Model: ");
        String cModel = scanner.nextLine();
        System.out.print("Year: ");
        int cYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Fuel Type: ");
        String cFuelType = scanner.nextLine();
        System.out.print("Price: ");
        double cPrice = scanner.nextDouble();
        System.out.print("Number of Doors: ");
        int cNumDoors = scanner.nextInt();
        System.out.print("Trunk Capacity(cu ft): ");
        double cTrunkCapacity = scanner.nextDouble();
        Car car = new Car(cMake, cModel, cYear, cFuelType, cPrice, cNumDoors, cTrunkCapacity);
        // Print information
        System.out.println("\nMotorcycle Information:");
        System.out.println("Vehicle Information: ");
        //Print the information of vehicles using the printInfo() method in Motorcycle.java.
        motorcycle.printInfo();
        System.out.println("\nCar Information:");
        System.out.println("Vehicle Information: ");
        //Print the information of vehicles using the printInfo() method in Car.java.
        car.printInfo();
        System.out.println("\nProgram Completed");
    }
}
