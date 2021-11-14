package ObjectsImmutabilitySwitchExpressions;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsAndHashCode {
    /**
     * Objects Immutability Switch Expressions
     * 1.46 equals() and hashCode()
     *
     * The equals() and hashCode() methods are defined in java.lang.Object.
     * Since Object is the superclass of all Java objects,
     * these two methods are available for all objects.
     *
     * Their main goal is to provide an easy, efficient, and robust
     * solution for comparing objects, and to determine whether they are equal.
     * Without these methods and their contracts, the solution relies on the big and
     * cumbersome if statements meant to compare each field of an object.
     *
     * When these methods are not overridden, Java will use their default
     * implementations.
     *
     * Unfortunately, the default implementation is not really
     * serving the goal of determining whether two objects have the same value.
     * By default, equals() checks identity.
     *
     * In other words, it considers that two objects are equal if,
     * and only if, they are represented by the same memory
     * address (same object references), while hashCode() returns an integer
     * representation of the object memory address. This is a native function
     * known as the identity hash code.
     *
     * For example, let's assume the following class:
     * public class Player {
     *      private int id;
     *      private String name;
     *  public Player(int id, String name) {
     *      this.id = id;
     *      this.name = name;
     *  }
     * }
     * Then, let's create two instances of this class containing the same
     * information, and let's compare them for equality:
     * Player p1 = new Player(1, "Rafael Nadal");
     * Player p2 = new Player(1, "Rafael Nadal");
     * System.out.println(p1.equals(p2)); // false
     * System.out.println("p1 hash code: " + p1.hashCode()); //
     * 1809787067
     * System.out.println("p2 hash code: " + p2.hashCode()); //
     * 157627094
     * For us, p1 and p2 are equal, but notice that equals() has returned false (the
     * p1 and p2 instances have exactly the same field values, but they are stored at
     * different memory addresses). This means that relying on the default
     * implementation of equals() is not acceptable
     *
     * NOTE THAT:
     * Do not use the == operator for testing the equality of objects
     * (avoid if(p1 == p2)).
     *
     * The == operator compares whether the references of two objects
     * are pointing to the same object,
     * whereas equals() compares object values
     * (as humans, this is what we care about).
     *
     * SOLUTIONS: There are 1 solution to this problem
     * */

    /**
     * Common mistakes of working with equals() and hashCode():
     * You override equals() and forget to override hashCode() or vice
     * versa (override both or none).
     *
     * You use the == operator instead of equals() for comparing object
     * values.
     *
     * In equals(), you omit one or more of the following:
     * Start by adding the self-check (if (this == obj)...).
     * Since no instance should be equal to null, continue by
     * adding null-check (if(obj == null)...).
     *
     * Ensure that the instance is what we are expecting (use
     * getClass() or instanceof).
     *
     * Finally, after these corner-cases, add field
     * comparisons.
     *
     * You violate equals() symmetry via inheritance.
     *
     * Assume a class A and a class B extending A and adding a new field.
     *
     * The B class overrides the equals() implementation inherited from A,
     * and this implementation is added to the new field.
     *
     * Relying on instanceof will reveal that
     * b.equals(a) will return false (as expected),
     * but a.equals(b) will return true (not expected),
     * so symmetry is broken.
     *
     * Relying on slice comparison will not work
     * since this breaks transitivity and reflexivity.
     *
     * Fixing the problem means relying on getClass()
     * instead of instanceof
     * (via getClass(), instances of the type and its subtypes cannot be equal),
     * or better relying on composition instead of inheritance as in the application
     * bundled to this book (P46_ViolateEqualsViaSymmetry).
     *
     * Since JDK 7, the Objects class has come with several helpers for dealing with
     * object equality and hash codes, as follows
     *
     * Objects.equals(Object a, Object b): Tests whether the a object is
     * equal to the b object.
     *
     * Objects.deepEquals(Object a, Object b): Useful for testing
     * whether two objects are equal (if they are arrays, the test is
     * performed via Arrays.deepEquals()).
     *
     * Objects.hash(Object ... values): Generates a hash code for a
     * sequence of input values.
     * */

    private int id;
    private String name;

    public EqualsAndHashCode(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * 1A. The first solution override equals() method
     * Rules of equals() method:
     * Reflexivity (phản xạ): An object is equal to itself, which means that
     * p1.equals(p1) must return true.
     *
     * Symmetry (cân xứng): p1.equals(p2) must return the same result
     * (true/false) as p2.equals(p1).
     *
     * Transitive (bắc cầu): If p1.equals(p2) and p2.equals(p3), then also
     * p1.equals(p3).
     *
     * Consistent (đồng nhất): Two equal objects must remain equal all the time
     * unless one of them is changed.
     *
     * Null returns false: All objects must be unequal to null
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        // Compare the runtime class of current object with obj
        if (getClass() != obj.getClass()) {
            return false;
        }

        // casting obj to EqualsAndHashCode object
        final EqualsAndHashCode other = (EqualsAndHashCode) obj;

        if (this.id != other.id) {
            return false;
        }

        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        return true;
    }

    /**
     * 1B. Continue the first solution, now we have to override hashcode() method
     * The hashCode() contract imposes the following:
     *
     * Two equal objects conforming to equals() must return the same
     * hash code.
     *
     * Two objects with the same hash code are not mandatory equals.
     *
     * As long as the object remains unchanged, hashCode() must return
     * the same value.
     *
     * As a rule of thumb, in order to respect the equals() and hashCode() contracts,
     * follow two golden rules:
     * When equals() is overridden, hashCode() must be overridden as
     * well, and vice versa.
     *
     * Use the same identifying attributes for both methods in the same
     * order
     * */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    public static void main(String[] args) {
        Set<EqualsAndHashCode> players = new HashSet<>();
        EqualsAndHashCode p1 = new EqualsAndHashCode(1, "HangTo");
        EqualsAndHashCode p2 = new EqualsAndHashCode(1, "HangTo");

        players.add(p1);
        players.add(p2);

        // Before override equals() method
        System.out.println(p1.equals(p2)); // false
        System.out.println("p1 hash code: " + p1.hashCode()); //1809787067
        System.out.println("p2 hash code: " + p2.hashCode()); //157627094

        System.out.println("========================");
        // After override equals() method
        System.out.println(p1.equals(p2)); // true
        System.out.println("p1 hash code: " + p1.hashCode()); //1809787067
        System.out.println("p2 hash code: " + p2.hashCode()); //157627094

        /**
         * Conforming to the preceding implementation of equals(), p1, and p2 are
         * equal; therefore, the HashSet size should be 1, not 2
         * Moreover, it should contain HangTo. So, what happened?
         * */
        // Before override hashcode() method
        System.out.println("Set size: " + players.size()); // 2
        System.out.println("Set contains HangTo: " + players.contains(new EqualsAndHashCode(1, "HangTo"))); // false

        /**
         * The general answer resides in how Java was created.
         *
         * It is easy to intuit that equals() is not a fast method;
         * therefore, lookups will face performance penalties
         * when a significant number of equality comparisons are needed.
         *
         * For example, this adds a serious drawback in the case of lookups by specific
         * values in collections
         * (for example, HashSet, HashMap, and HashTable),
         * since it may require a large number of equality comparisons.
         *
         * Based on this statement, Java tried to reduce equality comparisons by
         * adding buckets.
         *
         * A bucket is a hash-based container that groups equal objects.
         * This means that equal objects should return the same hash code,
         * while unequal objects should return different hash codes (if two unequal
         * objects have the same hash code, then this is a hash collision, and the objects
         * will go in the same bucket).
         * So, Java compares the hash codes, and only if these are the same
         * for two different object references (not for the same
         * object references) does it proceed further and call equals().
         * Basically, this accelerates the lookups in collections.
         * */

        /**
         * But what happened in our case? Let's see it step by step:
         * a. When p1 is created, Java will assign to it a hash code based on the
         * p1 memory address.
         * b. When p1 is added to Set, Java will link a new bucket to the p1 hash
         * code.
         * c. When p2 is created, Java will assign to it a hash code based on the
         * p2 memory address.
         * d. When p2 is added to Set, Java will link a new bucket to the p2 hash
         * code (when this happens, it looks like HashSet is not working as
         * expected, and it allows duplicates).
         * e. When players.contains(new EqualsAndHashCode(1, "HangTo")) is
         * executed, a new object, p3, is created with a new hash code based
         * on the p3 memory address.
         * f. So, in the frame of contains(), testing p1 and p3, respectively, p2
         * and p3 , for equality involves checking their hash codes,
         *
         * Since the p1 hash code is different from the p3 hash code,
         * and the p2 hash code is different from the p3 hash code,
         * the comparisons stop without evaluating equals()
         * and this means that HashSet doesn't contain the object (p3)
         *
         * That's reason why we have to override hashcode() too
         * */

        // After override hashcode() method
        System.out.println("Set size: " + players.size()); // 2
        System.out.println("Set contains HangTo: " + players.contains(new EqualsAndHashCode(1, "HangTo"))); // false
    }
}
