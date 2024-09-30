import java.util.Scanner;
public class A2
{
    private int[] UserArray; //Create an array to store data
    public void CreateArray()
    {
        Scanner sc = new Scanner(System.in);
        int len = 0;
        // Accepting array length
        System.out.println("Please enter the length of an array :");
        //Make sure the entered data is an integer between 2-10
        try
        {
            len = sc.nextInt();
            if (len < 2 || len > 10)
            {
                System.out.println("Usage: Enter a length between 2-10");
                CreateArray();
                return;
            }
        }
        catch (Exception e)
        {
            System.out.println("Usage: Input should only be integer numbers");
            sc.next();  // Clear invalid input
            CreateArray();
            return;
        }
        // Accepting array elements
        UserArray = new int[len];
        System.out.println("Please enter 5 elements of the array:");
        for (int i = 0; i < len; i++)
        {
            try
            {
                UserArray[i] = sc.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Usage: Input should only be integer numbers");
                sc.next();  // Clear invalid input
                i--;  // Decrement counter to re-input at the same position
            }
        }
    }
    public void PrintArray(int[] array) // Print need array
    {
        for (int i : array)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public int[] CopyArray(int[] array) //Copy array for need
    {
        int[] copiedArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            copiedArray[i] = array[i];
        }
        return copiedArray;
    }
    public int[] SortArray() //Sort from smallest to largest
    {
        int[] sortedArray = CopyArray(UserArray);
        // Using simple bubble sort for demonstration
        for (int i = 0; i < sortedArray.length - 1; i++)
        {
            for (int j = 0; j < sortedArray.length - 1 - i; j++)
            {
                if (sortedArray[j] > sortedArray[j + 1])
                {
                    // swap position
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
    public void PrintSum() // Print sum of odd and even elements
    {
        int sumOdd = 0; //name sum of odd
        int sumEven = 0; //name sum of even
        for (int num : UserArray)
        {
            if (num % 2 == 0)
            {
                sumEven += num;
            }
            else
            {
                sumOdd += num;
            }
        }
        System.out.println("The sum of all odd elements: " + sumOdd);
        System.out.println("The sum of all even elements: " + sumEven);
    }
    public void SearchInteger()  // Search specific integer
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer to search: ");
        int searchInt = sc.nextInt();
        for (int i = 0; i < UserArray.length; i++)
        {
            if (UserArray[i] == searchInt)
            {
                System.out.println("Integer found at index " + i + ".");
                return;
            }
        }
        System.out.println("No such integer was found.");
    }

}
    public void SmallestInteger()  // Print smallest integer and its index
    {
        int min = UserArray[0];
        int index = 0;
        for (int i = 1; i < UserArray.length; i++)
        {
            if (UserArray[i] < min)
            {
                min = UserArray[i];
                index = i;
            }
        }
        System.out.println("Smallest integer found is " + min + " at index " + index + ".");
    }
    public int[] ReverseArray() // Reverse array
    {
        int[] reversedArray = new int[UserArray.length];
        for (int i = 0; i < UserArray.length; i++)
        {
            reversedArray[i] = UserArray[UserArray.length - 1 - i];
        }
        return reversedArray;
    }
    public void ReplaceInteger() // Replace an integer and print new array
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer to insert:");
        int newInt = sc.nextInt();
        System.out.println("Enter the index to be inserted at:");
        int index = sc.nextInt();
        if (index >= 0 && index < UserArray.length)
        {
            int[] newArray = CopyArray(UserArray);
            newArray[index] = newInt; //insert new integer at need position
            System.out.println("The new array is:");
            PrintArray(newArray);
        }
    }
    public static void main(String[] args)
    {
        A2 obj = new A2();
        try
        {
            obj.CreateArray();
            System.out.println("The input array is:" );
            obj.PrintArray(obj.UserArray);
            System.out.println("The copied array is:" );
            obj.PrintArray(obj.UserArray);
            int[] SortedArray = obj.SortArray();
            System.out.println("The sorted array is:");
            obj.PrintArray(SortedArray);
            obj.PrintSum();
            obj.SearchInteger();
            obj.SmallestInteger();
            int[] ReversedArray = obj.ReverseArray();
            System.out.println("The reversed array is:");
            obj.PrintArray(ReversedArray);
            obj.ReplaceInteger();
        }
        finally
        {
            // Always print ‘Program Completed.’ before exiting, as per the requirement
            System.out.println("Program Completed.");
        }
    }
}