package StringNumbersMath;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GeneratingAllPermutations {

    /**
     * String Manipulation
     * MUST READ PROBLEM
     * 1.10 Generating All Permutations
     *
     * SOLUTIONS: There are 3 solutions to this problem
     *
     * Problems that involve permutations commonly involve recursivity as well.
     * Basically, recursivity is defined as a process where some initial state is given
     * and each successive state is defined in terms of the preceding state.
     *
     * In our case, the state can be materialized by the letters of the given string.
     * The initial state contains the initial string and each successive state can be
     * computed by the following formula—each letter of the string will become the
     * first letter of the string (swap positions) and then permute all the
     * remaining letters using a recursive call.
     *
     * While non-recursive or other recursive solutions exist,
     * this is a classical solution to this problem.
     *
     * Representing this solution for a string, ABC, can be done like so (notice how
     * permutations are done):
     *
     * Example: ABC
     * A is fixed: ABC (swap B with B), ACB (swap B with C)
     * B is fixed: BAC (swap A with A), BCA (swap A with C)
     * C is fixed: CBA (swap B with B), CAB (swap B with A)
     * */

    /**
     * 1. The first solution to this problem is using Recursion
     * Initially, the prefix should be an empty string, ""
     * At each iteration, the prefix will concatenate (fix) the next letter from the string
     * The remaining letters are passed through the method again
     * The code for this solution is as follows:
     *
     * @param str
     */
    public static void permuteAndPrint(String str) {
        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < str.length(); i++) {
                /**
                 * prefix + str.charAt(i) is "A"
                 * str.substring(0, i) is ""
                 * str.substring(i + 1, n) is "BC"
                 */
                System.out.println(prefix + str.charAt(i));
                System.out.println(str.substring(i + 1, n) + str.substring(0, i));
                permuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    /**
     * 2. The second solution is using Set to the implementation
     * It is preferable to use Set since it eliminates duplicates
     * which means it will generate all unique permutations
     * Using List instead of Set will have DUPLICATES output
     * The code for this solution is as follows:
     *
     * @param str
     * @return Set<String>
     * */
    public static Set<String> permuteAndStoreUsingSet(String str) {
        return permuteAndStoreUsingSet("", str);
    }

    private static Set<String> permuteAndStoreUsingSet(String prefix, String str) {
        Set<String> permutations = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permutations.addAll(permuteAndStoreUsingSet(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }

        return permutations;
    }

    /**
     * 3. The final solution is using Java 8 functional style
     * The code for this solution is as follows:
     *
     * @param str
     * */
    public static void permuteAndPrintStream(String str) {
        permuteAndPrintStream("", str);
    }

    public static void permuteAndPrintStream(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.println(prefix + " ");
        } else {
            /**
             * IntStream is a sequence of
             * primitive int-valued elements and the function
             *
             * IntStream.range(0, n) create a stream of integers
             * parallel() returns a parallel IntStream
             * We use parallel() in multi-thread
             * Tạo một Stream xử lý dữ liệu song song, tương đương với parallelStream()
             * */
            IntStream.range(0, n)
                     .parallel()
                     .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                             str.substring(i + 1, n) + str.substring(0, i)));
        }
    }

    public static void main(String[] args) {
        GeneratingAllPermutations permutations = new GeneratingAllPermutations();

        // C1
        permutations.permuteAndPrint("ABC");
        System.out.println("=====================");

        // C2
        Set<String> result = permutations.permuteAndStoreUsingSet("ABC");
        result.forEach(System.out::println);
        System.out.println("=====================");

        // C3
        permutations.permuteAndPrintStream("ABC");
    }
}