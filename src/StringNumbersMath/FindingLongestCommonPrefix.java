package StringNumbersMath;

import java.util.Arrays;

public class FindingLongestCommonPrefix {

    /**
     * String Manipulation
     * 1.22 Finding Longest Common Prefix
     *
     * SOLUTIONS: There are 6 solutions to this problem
     *
     * Example: Let's put these strings one below the other, as follows:
     * abc
     * abcd
     * abcde
     * ab
     * abcd
     * abcdef
     * A simple comparison of these strings reveals that
     * ab is the longest common prefix
     * */

    /**
     * 1. The first solution takes the first string
     * from the array and compares each of its characters
     * in the rest of the strings
     * The algorithm stops if either of the following happens:
     *
     * a. The length of the first string is greater than the length of
     * the other strings
     * b. The current character of the first string is not the same as the
     * current character of the other strings
     *
     * If the algorithm forcibly stops because of one of the preceding scenarios,
     * then the longest common prefix is the substring from 0 to the index of the
     * current character from the first string.
     * Otherwise, the longest common prefix is the first string from the array.
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public static String findingLongestCommonPrefixUsingCompare(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int firstLen = strs[0].length();

        for (int prefixLen = 0; prefixLen < firstLen; prefixLen++) {
            char currentCharOfFirstString = strs[0].charAt(prefixLen);

            for (int i = 1; i < strs.length; i++) {
                // currentCharOfOtherString = strs[i].charAt(prefixLen);
                // Stop looping
                if (prefixLen >= strs[i].length() || (strs[i].charAt(prefixLen) != currentCharOfFirstString)) {
                    return strs[i].substring(0, prefixLen);
                }
            }
        }

        return strs[0];
    }

    /**
     * 2. The second solution use algorithms Binary Search
     * a. Find the string having the minimum length. Let this length be L.
     *
     * b. Perform a binary search on any one string (from the input array of strings).
     * Let us take the first string and do a binary search on the characters from the index – 0 to L-1.
     *
     * c. Initially, take low = 0 and high = L-1
     * and divide the string into two halves – left (low to mid) and right (mid+1 to high).
     *
     * d. Check whether all the characters in the left half
     * is present at the corresponding indices (low to mid) of all the strings or not.
     * If it is present then we append this half to our prefix string
     * and we look in the right half in a hope to find a longer prefix.
     * (It is guaranteed that a common prefix string is there.)
     *
     * e. Otherwise, if all the characters in the left half is not present
     * at the corresponding indices (low to mid) in all the strings,
     * then we need not look at the right half
     * as there is some character(s) in the left half itself
     * which is not a part of the longest prefix string.
     *
     * So we indeed look at the left half in a hope to find a common prefix string.
     * (It may be possible that we don’t find any common prefix string)
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public static String findingLongestCommonPrefixUsingBST(String[] strs) {
        return strs[0];
    }

    /**
     * 3. The third solution use Sorting
     * Time Complexity: O(MAX * n * log n ) where n is the number of strings in the array
     * MAX is maximum number of characters in any string.
     * Please note that comparison of two strings would take at most O(MAX) time
     * and for sorting n strings, we would need O(MAX * n * log n ) time.
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public static String findingLongestCommonPrefixUsingSorting(String[] strs) {
        /* if size is 0, return empty string */
        if (strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        /* Sort array */
        Arrays.sort(strs);

        /* Find minimum length from first and last string */
        int minLen = Math.min(strs[0].length(), strs[strs.length-1].length());

        /* Find the common prefix between the first and last string */
        int i = 0;
        while (i < minLen && strs[0].charAt(i) == strs[strs.length-1].charAt(i)) {
            i++;
        }

        String longestPrefix = strs[0].substring(0, i);
        return longestPrefix;
    }

    /**
     * 4. The fourth solution use Two pointers approach
     * We will return the match between each string in arrays
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public String findingLongestCommonPrefixUsingTwoPointer(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        if(strs.length == 1) return strs[0];

        String result = returnMatch(strs[0], strs[1]);

        if(result == "") return "";

        for(int i = 2; i < strs.length; i++){
            String currentResult = returnMatch(strs[i], result);
            if(currentResult =="") return "";
            else result = currentResult;
        }
        return result;
    }

    public String returnMatch(String firstStr, String secondStr){
        StringBuilder sb =  new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p1 < firstStr.length() && p2 < secondStr.length()){
            if(firstStr.charAt(p1) == secondStr.charAt(p2)){
                sb.append(firstStr.charAt(p1));
                p1++;
                p2++;
            }
            else break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindingLongestCommonPrefix solution = new FindingLongestCommonPrefix();
        String[] texts = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};

        // C1
        System.out.println(solution.findingLongestCommonPrefixUsingCompare(texts));

        // C2
        System.out.println(solution.findingLongestCommonPrefixUsingSorting(texts));

        // C3
        System.out.println(solution.findingLongestCommonPrefixUsingTwoPointer(texts));
    }
}
