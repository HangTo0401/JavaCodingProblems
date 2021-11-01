package StringNumbersMath;

import java.util.Arrays;
import java.util.Comparator;

public class SortingArrayOfStringsByLength {

    /**
     * String Manipulation
     * 1.15 Sorting Array Of Strings By Length
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first thing that comes to mind when sorting is the use of a comparator.
     * In this case, the solution should compare lengths of strings,
     * and so the integers are returned by calling String.length()
     * for each string in the given array.
     *
     * So, if the integers are sorted (ascending or descending),
     * then the strings will be sorted.
     *
     * The Java Arrays class already provides a sort() method that takes the array
     * to sort and a comparator. In this case, Comparator<String> should do the job.
     * The following is a method that sorts the given array by relying on
     * the Arrays.sort() method:
     * This is shown in the following code:
     *
     * @param strs
     * @param direction
     * @return void
     * */
    public static void sortArrayByLength(String[] strs, String direction) {
        if (direction.equals("ASC")) {
            Arrays.sort(strs, (String s1, String s2)
                    -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs, (String s1, String s2)
                    -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
    }

    /**
     * 2. The second solution is using Java 8,
     * the Comparator interface was enriched with a significant
     * number of useful methods. One of these methods is comparingInt(),
     * which takes a function that extracts an int sort key
     * from the generic type and returns a Comparator<T> value
     * that compares it with that sort key.
     * Another useful method is reversed(), which reverses the current Comparator value.
     * Based on these two methods, we can empower Arrays.sort() as follows:
     * This is shown in the following code:
     *
     * @param strs
     * @param direction
     * @return void
     * */
    public static void sortArrayByLengthUsingJavaStreamVoid(String[] strs, String direction) {
        if (direction.equals("ASC")) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
            Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
        }
    }

    /**
     * 3. The second solutions we've presented here return void,
     * which means that they sort the given array.
     * The final solution is used to return a new sorted array
     * and not alter the given array, we can use Java 8 functional style
     * So, the code creates a stream from the given array, sorts it via the sorted()
     * stateful intermediate operation, and collects the result in another array
     * This is shown in the following code:
     *
     * @param strs
     * @param direction
     * @return String[]
     * */
    public static String[] sortArrayByLengthUsingJavaStream(String[] strs, String direction) {
        if (direction.equals("ASC")) {
            return Arrays.stream(strs)
                         .sorted(Comparator.comparingInt(String::length))
                         .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }

    public static void main(String[] args) {
        SortingArrayOfStringsByLength solution = new SortingArrayOfStringsByLength();

        String[] array = new String[]{"MAN", "KING", "ARTHUR", "HEL"};

        // C1
        solution.sortArrayByLength(array, "ASC");

        // C2
        solution.sortArrayByLengthUsingJavaStreamVoid(array, "ASC");

        // C3
        String[] arrStr = solution.sortArrayByLengthUsingJavaStream(array, "ASC");
        Arrays.stream(arrStr).forEach(System.out::println);
    }
}
