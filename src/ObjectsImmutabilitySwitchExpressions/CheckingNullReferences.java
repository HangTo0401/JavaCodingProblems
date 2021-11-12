package ObjectsImmutabilitySwitchExpressions;

import java.awt.*;
import java.util.Objects;

public class CheckingNullReferences {

    /**
     * Objects Immutability Switch Expressions
     * 1.41 Checking null references and throwing customized
     * NullPointerException
     *
     * The next problem, checking null references
     * and throwing the specified exception
     * (for example, IllegalArgumentException),
     * addresses the IllegalArgumentException approach.
     *
     * SOLUTIONS: There are 3 solutions to this problem
     * */

    /**
     * 1. The first solution use == operator and manual
     * instantiation of the NullPointerException class
     * Checking null references and throwing NullPointerException with
     * customized messages can be accomplished using the following code (this
     * code does these four times, twice in the constructor and twice in the
     * assignDriver() method):
     * This is shown in the following code:
     *
     * @param license
     * @return boolean
     * */
    public void checkingNullReferencesUsingOperator(String license) {
        if (license == null) {
            throw new NullPointerException("License cannot be null");
        }
    }

    /**
     * 2. The second solution use Objects.requireNonNull()
     * Starting with JDK 7, this combination of code
     * was hidden in a static method named Objects.requireNonNull()
     * Via this method, the preceding code can be
     * rewritten in an expressive manner
     *
     * So, if the specified reference is null,
     * then Objects.requireNonNull() will throw a NullPointerException
     * with the message provided. Otherwise, it returns the checked reference
     * This is shown in the following code:
     *
     * @param license
     * @return boolean
     */
    public void checkingNullReferencesUsingRequireNonNull(String license) {
        Objects.requireNonNull(license, "License cannot be null");
    }

    /**
     * 3. The third solution use Objects.requireNonNull() in Java 8
     * Starting with JDK 8, there is one more Objects.requireNonNull().
     * This one wraps the custom message of NullPointerException in Supplier
     * This means that the message creation is postponed
     * until the given reference is null
     * (this means that using the + operator for concatenating parts of the message is no
     * longer an issue).
     * This is shown in the following code:
     *
     * @param license
     * @return boolean
     * */
    public void checkingNullReferencesUsingRequireNonNullJava8(String license) {
        Objects.requireNonNull(license, () ->"License cannot be null ... Consider one from " + license);
    }

    public static void main(String[] args) {
        CheckingNullReferences solution = new CheckingNullReferences();

        // C1
        solution.checkingNullReferencesUsingOperator(null);

        // C2
        solution.checkingNullReferencesUsingRequireNonNull(null);

        // C3
        solution.checkingNullReferencesUsingRequireNonNullJava8(null);
    }
}
