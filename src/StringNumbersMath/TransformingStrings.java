package StringNumbersMath;

import java.util.stream.Stream;

public class TransformingStrings {
    /**
     * String Manipulation
     * 1.24 Transforming Strings
     * Let's assume that we have a string and we want to transform it into another
     * string (for example, transform it into upper case).
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /**
     * 1A. The first solution use Map
     * In JDK 8, we can accomplish this via map()
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public static String transformingStringsUsingMap(String str) {
        String resultMap = Stream.of(str)
                .map(s -> s + " world")
                .findFirst()
                .get();
        return resultMap;
    }

    /**
     * 1B. The another solution of first approach use Map
     * In JDK 8, we can accomplish this via map()
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    public static String transformingStringsUsingMapLowerCase(String str) {
        // hello world
        String resultMap = Stream.of(str)
                .map(String::toLowerCase)
                .map(s -> s + " world")
                .findFirst()
                .get();
        return resultMap;
    }

    /**
     * 2A. The second solution use transform function in JDK 12
     * Starting with JDK 12, we can rely on a new method named transform
     * Let's rewrite the preceding snippets of code via transform():
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    /* Function<? super String, ? extends R> f */
    public static String transformingStringsUsingTransform(String str) {
        // hello world
        String result = str.transform(s -> s + " world");
        return result;
    }

    /**
     * 2B. The second solution use transform function in JDK 12
     * Starting with JDK 12, we can rely on a new method named transform
     * Let's rewrite the preceding snippets of code via transform():
     * This is shown in the following code:
     *
     * @param str
     * @return String
     * */
    /* Function<? super String, ? extends R> f */
    public static String transformingStringsUsingTransformLowerCase(String str) {
        // hello world
        String result = str.transform(String::toLowerCase)
                           .transform(s -> s + " world");
        return result;
    }

    public static void main(String[] args) {
        TransformingStrings solution = new TransformingStrings();

        // C1A
        System.out.println(solution.transformingStringsUsingMap("hello"));

        // C1B
        System.out.println(solution.transformingStringsUsingMapLowerCase("hello"));

        // C2A
        System.out.println(solution.transformingStringsUsingTransform("hello"));

        // C2B
        System.out.println(solution.transformingStringsUsingTransformLowerCase("hello"));
    }
}
