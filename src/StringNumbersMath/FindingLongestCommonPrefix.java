package StringNumbersMath;

import java.util.Arrays;

public class FindingLongestCommonPrefix {

    /**
     * String Manipulation
     * 22. Finding The Longest Common Prefix
     *
     * SOLUTIONS: There are 7 solutions to this problem
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
     * We divide problem into 2 halves left (Si...Smid) and right (Smid+1...Sj)
     * where mid = (i+j)/2
     *
     * To accomplish this problem, we compare one by one the characters of left and right
     * till there is no character match.
     * Then we found the longest common prefix of left and right is solution of (Si...Sj)
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public static String findingLongestCommonPrefixUsingDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixUsingDivideAndConquer(strs, 0 , strs.length - 1);
    }

    public static String longestCommonPrefixUsingDivideAndConquer(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right)/2;
            String lcpLeft = longestCommonPrefixUsingDivideAndConquer(strs, left , mid);
            String lcpRight = longestCommonPrefixUsingDivideAndConquer(strs, mid + 1,right);
            return commonPrefixLeftAndRight(lcpLeft, lcpRight);
        }
    }

    /* Find the match between left and right side */
    public static String commonPrefixLeftAndRight(String lcpLeft, String lcpRight) {
        int min = Math.min(lcpLeft.length(), lcpRight.length());

        for (int i = 0; i < min; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, min);
    }
    /**
     * 3. The third solution use Two pointers approach
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

    /* Find the match between firstStr and secondStr */
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

    /**
     * 4. The fourth solution use Horizontal scanning
     * The algorithm iterates through the strings [S1…Sn],
     * finding at each iteration i the longest common prefix of strings LCP(S1...Si).
     * When LCP(S1...Si) is an empty string, the algorithm ends.
     * Otherwise, after n iterations, the algorithm returns LCP(S1...Sn).
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public String findingLongestCommonPrefixUsingHorizontalScanning(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // If strs[i].indexOf(prefix) = 0 means that strs[i] contains prefix
            while (strs[i].indexOf(prefix) != 0) {
                /* Remove one character in prefix */
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    /**
     * 5. The fifth solution use Vertical scanning
     * The Horizontal scanning approach will still do S comparisons.
     * One way to optimize this case is to do Vertical Scanning.
     * We compare characters from top to bottom on the same column
     * (same character index of the strings) before moving on to the next column.
     *
     * Complexity Analysis
     * •	Time complexity : O(S), where S is the sum of all characters in all strings.
     * In the worst case there will be nn equal strings with length mm
     * and the algorithm performs S=m⋅n character comparisons.
     * Even though the worst case is still the same as Horizontal scanning,
     * in the best case there are at most n⋅minLen comparisons
     * where minLen is the length of the shortest string in the array.
     *
     * •	Space complexity : O(1). We only used constant extra space.
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public String findingLongestCommonPrefixUsingVerticalScanning(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs.length; i++) {
            char currentCharOfFirstString = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != currentCharOfFirstString) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    /**
     * 6. The sixth solution use Binary Search
     * The ideal is to apply Binary Search to find a string with maximum L
     * which is common prefix of all the strings
     * The algorithm to search space is the interval in (0...minLen)
     * where minLen is the minimum string length and maximum possible common prefix
     * Each time search space is divided into 2 equal parts,
     * one of them is discarded because it's not the solution
     *
     * There are 2 possible cases:
     * a. S[1...mid] is NOT a common string. This means that j > i S[1...j] is NOT a common string
     * ,and we discard the second half of the search space
     *
     * b. S[1...mid] is a common string. This means that for for each i < j S[1...i]
     * is a common string, and we discard the first half of the search space,
     * because we try to find longer common prefix
     *
     * Complexity Analysis
     * In the worst case we have nn equal strings with length m
     * •	Time complexity :O(S⋅logm), where S is the sum of all characters in all strings.
     * The algorithm makes logm iterations,
     * for each of them there are S=m⋅n comparisons, which gives in total O(S⋅logm) time complexity.
     *
     * •	Space complexity : O(1). We only used constant extra space.
     * This is shown in the following code:
     *
     * @param strs
     * @return String
     * */
    public static String findingLongestCommonPrefixUsingBinarySearch(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int left = 1;
        int right = minLen;
         while (left <= right) {
             int middle = (left + right) / 2;

             if (isCommonPrefix(strs, middle)) {
                 left = middle + 1;
             } else {
                 right = middle - 1;
             }
         }

        int middle = (left + right) / 2;
        return strs[0].substring(0, middle);
    }

    /* Check if strs[i] contains common prefix or not*/
    public static boolean isCommonPrefix(String[] strs, int prefixLen) {
        /* str1 is common prefix*/
        String str1 = strs[0].substring(0, prefixLen);

        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }

        return true;
    }
    /**
     * 7. The seventh solution use Sorting
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

    public static void main(String[] args) {
        FindingLongestCommonPrefix solution = new FindingLongestCommonPrefix();
        String[] texts = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};

        // C1
        System.out.println(solution.findingLongestCommonPrefixUsingCompare(texts));

        // C2
        System.out.println(solution.findingLongestCommonPrefixUsingDivideAndConquer(texts));

        // C3
        System.out.println(solution.findingLongestCommonPrefixUsingTwoPointer(texts));

        // C4
        System.out.println(solution.findingLongestCommonPrefixUsingHorizontalScanning(texts));

        // C5
        System.out.println(solution.findingLongestCommonPrefixUsingVerticalScanning(texts));

        // C6
        System.out.println(solution.findingLongestCommonPrefixUsingBinarySearch(texts));

        // C7
        System.out.println(solution.findingLongestCommonPrefixUsingSorting(texts));
    }
}
