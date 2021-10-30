package StringNumbersMath;

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
     * The first solution to this problem is using Recursion
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
                permuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    public static void main(String[] args) {
        GeneratingAllPermutations permutations = new GeneratingAllPermutations();
        permutations.permuteAndPrint("ABC");
    }
}