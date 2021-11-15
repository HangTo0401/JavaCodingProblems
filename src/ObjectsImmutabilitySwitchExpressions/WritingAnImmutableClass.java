package ObjectsImmutabilitySwitchExpressions;

public class WritingAnImmutableClass {
    /**
     * Objects Immutability Switch Expressions
     * 49. Writing an immutable class
     * An immutable class must respect several requirements, such as the
     * following:
     * a. The class should be marked as final to suppress extensibility
     * (other classes cannot extend this class; therefore, they cannot
     * override methods)
     * b. All fields should be declared private and final (they are not
     * visible in other classes, and they are initialized only once in the
     * constructor of this class)
     * c. The class should contain a parameterized public constructor (or a
     * private constructor and factory methods for creating instances)
     * that initializes the fields
     * d. The class should provide getters for fields
     * e. The class should not expose setters
     * */
    public final class Point {
        private final double x;
        private final double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
    }

    /**
     * If the immutable class should manipulate mutable objects, consider the
     * problems 50.
     * */
}
