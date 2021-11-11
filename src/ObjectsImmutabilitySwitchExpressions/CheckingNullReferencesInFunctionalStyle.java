package ObjectsImmutabilitySwitchExpressions;

import java.util.*;

public class CheckingNullReferencesInFunctionalStyle {

    /**
     * Objects Immutability Switch Expressions
     * 1.40 Checking null references in functional style
     * and imperative code
     *
     * Independent of functional style or imperative code,
     * checking null references is a common
     * and recommended technique used for mitigating the
     * occurrence of famous NullPointerException exception.
     *
     * This kind of checking is heavily exploited
     * for method arguments to ensure that the passing
     * references will not cause NullPointerException or unexpected behavior.
     *
     * For example, passing List<Integer> to a method may require at least two
     * null checks.
     * First, the method should ensure that the list reference itself is not null.
     * Second, depending on how the list is used,
     * the method should ensure that the list does not contain null objects
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1A. The first solution use == comparator
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return List<Integer>
     * */
    public static List<Integer> evenIntegers(List<Integer> listIntegers) {
        if (listIntegers == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> evens = new ArrayList<>();

        for (Integer nr: listIntegers) {
            if (nr != null && nr % 2 == 0) {
                evens.add(nr);
            }
        }
        return evens;
    }

    /**
     * 1B. THe another solution use Objects.isNull()
     * Notice that the preceding code uses the classical checks relying on the == and
     * != operators (integers==null, nr !=null).
     *
     * Starting with JDK 8, the ava.util.Objects class
     * contains two methods that wrap the null checks
     * based on these two operators: object == null was wrapped in
     * Objects.isNull(), and object != null was wrapped in Objects.nonNull().
     * Based on these methods, the preceding code can be rewritten as follows
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return List<Integer>
     * */
    public static List<Integer> evenIntegersUsingIsNull(List<Integer> listIntegers) {
        if (Objects.isNull(listIntegers)) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> evens = new ArrayList<>();

        for (Integer nr: listIntegers) {
            if (Objects.nonNull(nr) && nr % 2 == 0) {
                evens.add(nr);
            }
        }
        return evens;
    }

    /**
     * 2A. The second solution use filter in Java stream
     * Now, the code is somehow more expressive,
     * but this is not the main usage of these two methods.
     *
     * Actually, these two methods have been added for another
     * purpose (conforming to API notes)—to be used as predicates in the Java 8
     * functional style code.
     *
     * In functional style code, the null checks can be
     * accomplished as in the following examples:
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return Integer
     * */
    public static Integer sumIntegersUsingIsNull(List<Integer> listIntegers) {
        if (listIntegers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return listIntegers.stream()
                           .filter(Objects::nonNull)
                           .mapToInt(Integer::intValue).sum();
    }

    /**
     * 2B. The second solution use filter in Java stream
     * Now, the code is somehow more expressive,
     * but this is not the main usage of these two methods.
     *
     * Actually, these two methods have been added for another
     * purpose (conforming to API notes)—to be used as predicates in the Java 8
     * functional style code.
     *
     * In functional style code, the null checks can be
     * accomplished as in the following examples:
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return Integer
     * */
    public static Integer sumIntegers(List<Integer> listIntegers) {
        if (Objects.isNull(listIntegers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return listIntegers.stream()
                .filter(i -> i != null)
                .mapToInt(Integer::intValue).sum();
    }

    /**
     * 3A. The third solution use Compare Operator in Java stream
     * Now, the code is somehow more expressive,
     * but this is not the main usage of these two methods.
     *
     * Actually, these two methods have been added for another
     * purpose (conforming to API notes)—to be used as predicates in the Java 8
     * functional style code.
     *
     * In functional style code, the null checks can be
     * accomplished as in the following examples:
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return boolean
     * */
    public static boolean sumIntegersUsingCompareOperator(List<Integer> listIntegers) {
        if (Objects.isNull(listIntegers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return listIntegers.stream()
                .anyMatch(i -> i == null);
    }

    /**
     * 3B. The third solution use anyMatch in Java stream
     * Now, the code is somehow more expressive,
     * but this is not the main usage of these two methods.
     *
     * Actually, these two methods have been added for another
     * purpose (conforming to API notes)—to be used as predicates in the Java 8
     * functional style code.
     *
     * In functional style code, the null checks can be
     * accomplished as in the following examples:
     * This is shown in the following code:
     *
     * @param listIntegers
     * @return boolean
     * */
    public static boolean sumIntegersUsingAnyMatch(List<Integer> listIntegers) {
        if (Objects.isNull(listIntegers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return listIntegers.stream()
                .anyMatch(Objects::isNull);
    }

    public static void main(String[] args) {
        CheckingNullReferencesInFunctionalStyle solution = new CheckingNullReferencesInFunctionalStyle();
        List<Integer> numbers  = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
        
        // C1A
        List<Integer> result = solution.evenIntegers(numbers);
        result.stream().forEach(System.out::println);

        // C1B
        List<Integer> result1 = solution.evenIntegersUsingIsNull(numbers);
        result1.stream().forEach(System.out::println);

        // C2A
        int result2A = solution.sumIntegers(numbers);
        System.out.println(result2A);

        // C2B
        int result2B = solution.sumIntegersUsingIsNull(numbers);
        System.out.println(result2B);

        // C3A
        boolean result3A = solution.sumIntegersUsingCompareOperator(numbers);
        System.out.println(result3A);

        // C3B
        boolean result3B = solution.sumIntegersUsingAnyMatch(numbers);
        System.out.println(result3B);
    }
}
