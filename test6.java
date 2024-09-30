import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// GenericList class definition:represents a list of elements of type T
class GenericList<T>
{
    private final List<T> universal = new ArrayList<>();
    public void add(T element) //Add an element to the list
    {
        universal.add(element);
    }
    public T get(int index) //Retrieve an element at a given index
    {
        return universal.get(index);
    }
    public int size() //Return the number of elements in the list
    {
        return universal.size();
    }
    public void remove(T element) //Remove an element from the list by its value
    {
        universal.remove(element);
    }
    public void reverse() //Reverse the order of elements in the list
    {
        int i = 0, j = size() - 1;
        while (i < j)  //Reverse the positions of i and j
        {
            T temp = universal.get(i);
            universal.set(i, universal.get(j));
            universal.set(j, temp);
            i++;
            j--;
        }
    }
    public T findMax(Comparator<T> comparator) //Find and return the maximum element in the list using the provided comparator
    {
        T maxElement = universal.get(0);
        for (T element : universal)
        {
            if (comparator.compare(element, maxElement) > 0) //Get the largest number through recursive comparison
            {
                maxElement = element;
            }
        }
        return maxElement;
    }
}
public class A6
{
    public static void main(String[] args)
    {
        // Create a GenericList of type Integer
        GenericList<Integer> integerList = new GenericList<>();
        integerList.add(5); //Using the add method to add integers
        integerList.add(3);
        integerList.add(8);
        integerList.add(2);
        integerList.add(10);
        // Display the integer list
        System.out.println("Original Integer List:");
        for (int i = 0; i < integerList.size(); i++) //Using the size method to check the length of the list
        {
            System.out.println(integerList.get(i)); //Using the get method to display this list
        }
        // Remove an element from the integer list
        integerList.remove(3); //Using the remove method to remove a specific integer from the list
        // Display the list after removal
        System.out.println("List after removing '3':");
        for (int i = 0; i < integerList.size(); i++)
        {
            System.out.println(integerList.get(i));
        }
        // Using the reverse method to reverse the integer list
        integerList.reverse();
        // Display the list after reversal
        System.out.println("Reversed Integer List:");
        for (int i = 0; i < integerList.size(); i++)
        {
            System.out.println(integerList.get(i));
        }
        // Create a GenericList of type String
        GenericList<String> stringList = new GenericList<>();
        stringList.add("apple"); ////Using the add method to add strings
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("date");
        stringList.add("fig");
        // Display the string list
        System.out.println("Original String List:");
        for (int i = 0; i < stringList.size(); i++) //Using the size method to check the length of the list
        {
            System.out.println(stringList.get(i)); ////Using the get method to display this list
        }
        // Find and display the maximum string based on lexicographic order
        String maxString = stringList.findMax(String::compareTo);  //Using the findMax method
        System.out.println("Maximum String: " + maxString);
        // Conclude the main method
        System.out.println("\nProgram Completed");
    }
}