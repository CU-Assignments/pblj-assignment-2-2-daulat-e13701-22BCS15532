import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxingSum {
    
    // Method to parse strings into Integer objects
    public static List<Integer> parseStringToIntegers(String[] numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String num : numbers) {
            try {
                integerList.add(Integer.parseInt(num)); // Autoboxing: int -> Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + num);
            }
        }
        return integerList;
    }

    // Method to calculate sum using unboxing
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing: Integer -> int
        }
        return sum;
    }

    public static void main(String[] args) {
        // Sample string array representing numbers
        String[] numberStrings = {"10", "20", "30", "40", "50"};

        // Convert strings to a list of Integers
        List<Integer> numbers = parseStringToIntegers(numberStrings);

        // Calculate the sum
        int sum = calculateSum(numbers);

        // Display the result
        System.out.println("The sum of the numbers is: " + sum);

        System.out.print("Completed By - \nName : Arpit.\nUid : 23BCS15532\nSection : Epam_801/A.");
    }
}
