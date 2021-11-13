package ObjectsImmutabilitySwitchExpressions;

import java.awt.*;
import java.util.Objects;

public class CheckingNullReferencesAndReturningNonNullDefaultReferences {
    /**
     * Objects Immutability Switch Expressions
     * 1.43 Checking null references and returning non-null default references
     *
     * SOLUTIONS: There are 2 solutions to this problem
     * */

    /**
     * 1. The first  solution use if-else
     * (or the ternary operator), as in the following example
     * (as a variation, name, and color can be
     * declared as non-final and initialized with the default values at declaration)
     * This is shown in the following code:
     *
     * @param name
     * @param color
     * @return void
     * */
    private String name = "";
    private Color color = new Color(0, 0, 0);

    public void checkingNullReferencesUsingIfElse(String name, Color color) {
        if (name == null) {
            this.name = "No name";
        } else {
            this.name = name;
        }
        if (color == null) {
            this.color = new Color(0, 0, 0);
        } else {
            this.color = color;
        }

        System.out.println(this.name);
        System.out.println(this.color);
    }

    /**
     * 2. The second solution use requireNonNullElse() and requireNonNullElseGet()
     * Starting with JDK 9, we have these methods are requireNonNullElse()
     * and requireNonNullElseGet() from the Objects class.
     * Both of them take two arguments—the reference to check for nullity,
     * and the non-null default reference to return
     * in case the checked reference is null
     * This is shown in the following code:
     *
     * @param name
     * @param color
     * @return void
     * */
    public void checkingNullReferencesUsingRequireNonNull(String name, Color color) {
        this.name = Objects.requireNonNullElse(name, name);
        this.color = Objects.requireNonNullElseGet(color, () -> new Color(0, 0, 0));

        System.out.println(this.name);
        System.out.println(this.color);
    }
    public static void main(String[] args) {
        CheckingNullReferencesAndReturningNonNullDefaultReferences solution = new CheckingNullReferencesAndReturningNonNullDefaultReferences();

        // C1
        solution.checkingNullReferencesUsingIfElse("HELLO HANG", new Color(100, 0, 0));

        // C2
        solution.checkingNullReferencesUsingRequireNonNull("HELLO HANG", new Color(100, 100, 100));
    }
}
