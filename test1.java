// Class to calculate simple interest based on command-line arguments
public class A1
{
    public static void main(String[] args)
    {
        // Check if the number of arguments is exactly 3
        if (args.length != 3)
        {
            System.out.println("Usage: java A1 principalAmount annualInterestRate time");
            System.out.println("Program Completed.");
            return;
        }
        try
        {
            // Convert command-line arguments to double for principal and interest rate, and int for time
            double principal = Double.parseDouble(args[0]);
            double rate = Double.parseDouble(args[1]);
            double time = Double.parseDouble(args[2]);
            // Calculate the simple interest
            double simpleInterest = (principal * rate * time) / 100;
            System.out.println("The given principalAmount = " + principal + "， annualInterstrate = " + rate + "， time = " + time);
            System.out.println("The simple interest is: " + simpleInterest);
        }
        catch (NumberFormatException e)
        {
            // If there's an error converting the command-line arguments to numbers, show the usage message
            System.out.println("Usage: java A1 principalAmount annualInterestRate time");
        }
        finally
        {
            // Always print ‘Program Completed.’ before exiting, as per the requirement
            System.out.println("Program Completed.");
        }
    }
}