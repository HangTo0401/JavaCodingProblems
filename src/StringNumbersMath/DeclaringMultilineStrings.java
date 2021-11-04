package StringNumbersMath;

public class DeclaringMultilineStrings {

    /**
     * String Manipulation
     * 1.19 Declaring Multiline Strings (text blocks)
     *
     * SOLUTIONS: There are 4 solutions to this problem
     *
     * Starting with JDK 13, the idea was reconsidered and, unlike the declined raw
     * string literals, text blocks are surrounded by three double quotes, """, as
     * follows:
     *
     * String text = """My high school""";
     *
     * Text blocks can be very useful for writing multiline SQL statements,
     * using polyglot languages, and so on.
     * More details can be found at https://openjdk.java.net/jeps/355.
     *
     * Nevertheless, there are several surrogate solutions
     * that can be used before JDK 13
     * These solutions have a common point—the use of the line separator:
     * private static final String LS = System.lineSeparator();
     * */
    private static final String lineSeparator = System.lineSeparator();

    /**
     * 1. The first solution use String.join() in Java 8
     * This is shown in the following code:
     *
     * @return String
     * */
    public static String declareMultilineStringsUsingJoin() {
        String text = String.join(lineSeparator, "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");
        return text;
    }

    /**
     * 2. The second solution use StringBuilder
     * This is shown in the following code:
     *
     * @return String
     * */
    public static String declareMultilineStringsUsingStringBuilder() {
        StringBuilder sb = new StringBuilder();

        sb.append(lineSeparator);
        sb.append("My high school, \n");
        sb.append("the Illinois Mathematics and Science Academy,\n");
        sb.append("showed me that anything is possible,\n");
        sb.append("and that you're never too young to think big.\n");
        return sb.toString();
    }

    /**
     * 3. The third solution use concat
     * This is shown in the following code:
     *
     * @return String
     * */
    public static String declareMultilineStringsUsingConcat() {
        String text = "My high school, " + lineSeparator +
                "the Illinois Mathematics and Science Academy," + lineSeparator +
                "showed me that anything is possible " + lineSeparator +
                "and that you're never too young to think big.\n";
        return text;
    }

    /**
     * 4. The fourth solution use String.format()
     * This is shown in the following code:
     *
     * @return String
     * */
    public static String declareMultilineStringsUsingStringFormat() {
        String text = String.format("%s" + lineSeparator + "%s" + lineSeparator + "%s" + lineSeparator +
                        "%s",
                "My high school, ",
                "the Illinois Mathematics and Science Academy,",
                "showed me that anything is possible ",
                "and that you're never too young to think big.");
        return text;
    }

    public static void main(String[] args) {
        DeclaringMultilineStrings solution = new DeclaringMultilineStrings();

        // C1
        System.out.println(solution.declareMultilineStringsUsingJoin());

        // C2
        System.out.println(solution.declareMultilineStringsUsingStringBuilder());

        // C3
        System.out.println(solution.declareMultilineStringsUsingConcat());

        // C4
        System.out.println(solution.declareMultilineStringsUsingStringFormat());
    }
}
