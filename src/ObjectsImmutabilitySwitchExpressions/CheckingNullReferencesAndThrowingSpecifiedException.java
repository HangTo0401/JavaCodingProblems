package ObjectsImmutabilitySwitchExpressions;

import java.util.function.Supplier;

public class CheckingNullReferencesAndThrowingSpecifiedException {

    /**
     * Objects Immutability Switch Expressions
     * 42. CheckingNullReferences And Throwing Specified Exception
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /*
     * This problem cannot be solved via the methods of java.util.Objects since
     * there is no requireNonNullElseThrow() method. Throwing
     * IllegalArgumentException or another specified exception may require a set of
     * methods:
     * requireNonNullElseThrow(T obj, X exception)
     * requireNonNullElseThrowIAE(T obj, String message)
     * requireNonNullElseThrowIAE(T obj, Supplier<String> messageSupplier)
     * requireNonNullElseThrowIAE(T obj, Supplier<? extend X> exceptionSupplier)
    * */

    /**
     * 1A. The first solution use requireNonNullElseThrowIAE method
     * Let's focus on the requireNonNullElseThrowIAE() methods.
     *
     * It throws IllegalArgumentException
     * with a custom message specified as String or as Supplier
     * (to avoid creation until null is evaluated to true):
     * This is shown in the following code:
     *
     * @param obj
     * @param message
     * @return <T> T
     * */
    public static <T> T requireNonNullElseThrowIAE(T obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
        return obj;
    }

    /**
     * 1B. The first solution use requireNonNullElseThrowIAE method with Supplier
     * Let's focus on the requireNonNullElseThrowIAE() methods.
     *
     * It throws IllegalArgumentException
     * with a custom message specified as String or as Supplier
     * (to avoid creation until null is evaluated to true):
     * This is shown in the following code:
     *
     * @param obj
     * @param messageSupplier
     * @return <T> T
     * */
    public static <T> T requireNonNullElseThrowIAEUsingSupplier(T obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new IllegalArgumentException(messageSupplier == null
                    ? null : messageSupplier.get());
        }
        return obj;
    }

    /**
     * So, throwing IllegalArgumentException can be done via these two methods.
     * But they are not enough. For example, the code may need to
     * throw IllegalStateException, UnsupportedOperationException, and so on
     *
     * 2A. The second solution use requireNonNullElseThrow with exception
     * This is shown in the following code:
     *
     * @param obj
     * @param exception
     * @return <T> T
     * */
    public static <T, X extends Throwable> T requireNonNullElseThrowUsingException(T obj, X exception) throws X {
        if (obj == null) {
            throw exception;
        }
        return obj;
    }

    /**
     * So, throwing IllegalArgumentException can be done via these two methods.
     * But they are not enough. For example, the code may need to
     * throw IllegalStateException, UnsupportedOperationException, and so on
     *
     * 2B. The another solution use requireNonNullElseThrow with Supplier
     * This is shown in the following code:
     *
     * @param obj
     * @param exceptionSupplier
     * @return <T> T
     * */
    public static <T, X extends Throwable> T requireNotNullElseThrowUsingSupplier(T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if (obj != null) {
            return obj;
        } else {
            throw exceptionSupplier.get();
        }
    }

    public static void main(String[] args) {
        CheckingNullReferencesAndThrowingSpecifiedException solution = new CheckingNullReferencesAndThrowingSpecifiedException();

        // C1
        solution.requireNonNullElseThrowIAE("hello", "Name cannot be set as null");

        // C2
        solution.requireNonNullElseThrowIAEUsingSupplier("hello", () -> "Name cannot be set as null");

        // C3
        solution.requireNonNullElseThrowUsingException("hello", new UnsupportedOperationException("Name cannot be set as null"));

        // C4
        solution.requireNotNullElseThrowUsingSupplier("hello", () -> new UnsupportedOperationException("Name cannot be set as null"));
    }
}
