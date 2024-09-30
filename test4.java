import java.util.InputMismatchException; //Handle abnormal input
import java.util.Scanner;
public class A4
{
    // Private data fields
    private String employeeName;
    private String employeeID;
    private double hourlyRate;
    private double hoursWorked;
    private double taxRate;
    private double bonus;
    // Parameterized constructor
    public A4(String name, String id, double rate, double hours, double tax)
    {
        this.employeeName = name;
        this.employeeID = id;
        this.hourlyRate = rate;
        this.hoursWorked = hours;
        this.taxRate = tax;
        this.bonus = 0;
    }
    // Getter for bonus
    public double getBonus()
    {
        return bonus;
    }
    // Setter for bonus
    public void setBonus(double bonus)
    {
        if(bonus >= 0.1 && bonus <= 0.5)
        {
            this.bonus = bonus;
        }
        else
        {
            System.out.println("Invalid bonus rate.");
        }
    }
    // Setter for hoursWorked
    public void setHoursWorked(double hours)
    {
        this.hoursWorked = hours;
    }
    // Method to calculate gross Pay
    public double calculateGrossPay()
    {
        return hourlyRate * hoursWorked;
    }
    // Method to calculate tax
    public double calculateTax()
    {
        return calculateGrossPay() * taxRate;
    }
    // Method to award bonus
    public double awardBonus()
    {
        return calculateGrossPay() * bonus;
    }
    // Method to calculate net pay
    public double calculateNetPay()
    {
        return calculateGrossPay() - calculateTax() + awardBonus();
    }
    // Method to display employee details
    public void displayEmployeeDetails()
    {
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Gross pay: $" + calculateGrossPay());
        System.out.println("Tax Amount: $" + calculateTax());
        System.out.println("Net Pay(after bonus): $" + calculateNetPay());
    }
    public static void main(String[] args)
    {
        //Enter basic data
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        double rate;
        while(true)
        {
            try
            {
                System.out.print("Enter hourly rate: ");
                rate = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character left in the buffer
                break;
            }
            catch (InputMismatchException e) //Input string error
            {
                System.out.println("Invalid hourly rate.");
                scanner.nextLine();  // clear the invalid input
            }
        }
        double tax;
        while(true)
        {
            try
            {
                System.out.print("Enter tax rate between 0.1 & 0.4 both inclusive(e.g.,0.2 for 20%): ");
                tax = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character
                if(tax < 0.1 || tax > 0.4)//Limit tax rate entered
                {
                    System.out.println("Invalid tax rate.");
                    continue;
                }
                break;
            }
            catch (InputMismatchException e) //Error when entering 0.1-0.4 unexpected numbers
            {
                System.out.println("Invalid tax rate.");
                scanner.nextLine();  // clear the invalid input
            }
        }
        double hours;
        while(true)
        {
            try
            {
                System.out.print("Enter hours worked: ");
                hours = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline character
                break;
            }
            catch (InputMismatchException e)//Input string error
            {
                System.out.println("Invalid hours.");
                scanner.nextLine();  // clear the invalid input
            }
        }
        A4 payroll = new A4(name, id, rate, hours, tax);
        int option;
        do
        { //Provide menu of options
            System.out.println("1. Calculate Pay");
            System.out.println("2. Award Bonus");
            System.out.println("3. Display Employee Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            switch(option)
            {
                case 1:
                    System.out.println("Net Pay: $" + payroll.calculateNetPay());
                    break;
                case 2:
                    double bonusRate;
                    while(true)
                    {
                        try
                        {
                            System.out.print("Enter bonus percentage between 0.1 & 0.5 both inclusive(e.g.,0.2 for 20%): ");
                            bonusRate = scanner.nextDouble();
                            scanner.nextLine();  // Consume the newline character
                            if(bonusRate < 0.1 || bonusRate > 0.5) //Limit tax rate entered
                            {
                                System.out.println("Invalid bonus rate.");
                                continue;
                            }
                            break;
                        }
                        catch (InputMismatchException e) //Input string error
                        {
                            System.out.println("Invalid bonus rate.");
                            scanner.nextLine();  // clear the invalid input
                        }
                    }
                    payroll.setBonus(bonusRate);
                    System.out.println("Bonus awarded: $" + payroll.awardBonus());
                    break;
                case 3:
                    payroll.displayEmployeeDetails();
                    break;
                case 4:
                    System.out.println("Program Completed");
                    break;
            }
        } while (option != 4);
        scanner.close();
    }
}