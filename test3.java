import java.util.Scanner;
public class A3
{
    // Check whether the 2 strings are anagrams of each other or not
    public static boolean isAnagram(String str1, String str2)
    {
        // Remove any white spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        // Check if lengths are different
        if (str1.length() != str2.length())
        {
            return false;
        }
        // Count frequencies of characters
        int[] count = new int[26]; // for 26 letters
        for (char c : str1.toCharArray())
        {
            count[c - 'a']++;
        }
        for (char c : str2.toCharArray())
        {
            count[c - 'a']--;
            if (count[c - 'a'] < 0)
            {
                return false;
            }
        }
        return true; //If the 2 strings are anagrams, this method will return True
    }
    // Public static method to extract a substring between two indexes
    public static String extractSubstring(String str, int start, int end)
    {
        if (start < 0 || end > str.length() || start > end) //Invalid index
        {
            System.out.println("Usage: java Enter a valid index within the given string length.");
            return null;
        }
        return str.substring(start, end + 1); //Take a third string and two integer values start and end as inputs
    //end + 1 for obtaining the last letter, the number is taken before end+1
    }
    public static void main(String[] args)
    {
        // Input 3 strings and 2 integers from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anagram String 1 = ");
        String str1 = scanner.nextLine();
        System.out.print("Anagram String 2 = ");
        String str2 = scanner.nextLine();
        System.out.print("Substring Extraction String 3 = ");
        String str3 = scanner.nextLine();
        System.out.print("Starting index of substring = ");
        int start = scanner.nextInt();
        System.out.print("Ending index of substring = ");
        int end = scanner.nextInt();
        // Check if first two strings are anagrams, print the corresponding statement based on the result
        if (isAnagram(str1, str2))
        {
            System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
        }
        else
        {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        }
        // Extract substring from the third string
        String substring = extractSubstring(str3, start, end);
        if (substring != null)
        {
            System.out.println("Extracted substring: " + substring);
        }
        System.out.println("Program Completed.");
    }
}