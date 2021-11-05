package StringNumbersMath;

public class RemovingLeadingAndTrailingSpaces {
    /**
     * String Manipulation
     * 1.21 Removing leading and trailing spaces
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /**
     * 1. The first solution is using String.trim() method
     * This method is capable of removing all leading and trailing spaces,
     * any character whose code point is less than or equal to U+0020 or 32
     * (the space character):
     *
     * The preceding snippet of code will work as expected.
     * The trimmed string will be hello.
     * This only works because all of the white spaces that are being used
     * are less than U+0020 or 32 (the space character).
     *
     * There are 25 characters
     * (https://en.wikipedia.org/wiki/Whitespace_character#Unicode) defined as
     * white spaces and trim() covers only a part of them (in short, trim() is not
     * Unicode aware).
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public static String removeLeadingAndTrailingSpacesUsingStringTrim(String str) {
        String text = "\n \n\n" + str + "\t \n \r";
        String trimmed = text.trim();
        return trimmed;
    }

    /**
     * 2. \u2002 is another type of white space that trim() doesn't recognize (\u2002 is
     * above \u0020)
     * This means that, in such cases, trim() will not work as expected.
     * The second solution is using strip() with JDK 11.
     * This method extends the power of trim() into the land of Unicode:
     *
     * Moreover, JDK 11 comes with two flavors of strip()
     * for removing only the leading (stripLeading())
     * or only the trailing (stripTrailing()) white spaces
     * The trim() method doesn't have these flavors
     * This is shown in the following code:
     *
     * @param str
     * @return String
     */
    public static String removeLeadingAndTrailingSpacesUsingStrip(String str) {
        char space = '\u2002';
        String text = space + "\n \n\n " + str + " \t \n \r" + space;
        String stripped = text.strip();
        return stripped;
    }

    public static void main(String[] args) {
        RemovingLeadingAndTrailingSpaces solution = new RemovingLeadingAndTrailingSpaces();

        // C1
        System.out.println(solution.removeLeadingAndTrailingSpacesUsingStringTrim("   hello    "));

        // C2
        System.out.println(solution.removeLeadingAndTrailingSpacesUsingStrip("   hello    "));
    }
}
