package ObjectsImmutabilitySwitchExpressions;

public class PassingMutableObjectsToImmutableClass {
    /**
     * Objects Immutability Switch Expressions
     * 50. Passing/returning mutable objects to/from an immutable class
     *
     * We have two problems can break down immutability:
     * 50-a. Passing mutable objects to an immutable class can break down immutability.
     * 50-b. Returning mutable objects from an immutable class can break down immutability
     * */

    public static class Radius {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
    }

    /*Then, let's pass an instance of this class to an immutable class named, Point.*/
    public static final class Point {
        private final double x;
        private final double y;
        private final Radius radius;

        public Point(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public Radius getRadius() {
            return radius;
        }
    }

    /**
     * 1. The first solution to 50-a problem is cloning the Radius object
     * and storing the clone as the field of Point
     *
     * This time, the Point class immutability level has increased
     * (calling r.setStart(5) will not affect the radius field
     * since this field is a clone of r).
     *
     * But the Point class is not completely immutable
     * because there is one more problem to solve is that
     * returning mutable objects from an immutable class
     * can break down immutability
     * */
    public static final class PointUsingRadiusCloneObj {
        private final double x;
        private final double y;
        private final Radius radius;

        public PointUsingRadiusCloneObj(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;

            Radius clone = new Radius();
            clone.setStart(radius.getStart());
            clone.setEnd(radius.getEnd());
            this.radius = clone;
        }

        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }
        public Radius getRadius() {
            return radius;
        }
    }

    /**
     * 2. The second solution to 50-b problem is modifying
     * the getRadius() method to return a clone of the radius field
     * */
    public static final class PointModifyingRadiusCloneObj {
        private final double x;
        private final double y;
        private final Radius radius;

        public PointModifyingRadiusCloneObj(double x, double y, Radius radius) {
            this.x = x;
            this.y = y;

            Radius clone = new Radius();
            clone.setStart(radius.getStart());
            clone.setEnd(radius.getEnd());
            this.radius = clone;
        }

        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }

        // Modifying getRadius()
        public Radius getRadius() {
            Radius clone = new Radius();
            clone.setStart(this.radius.getStart());
            clone.setEnd(this.radius.getEnd());
            return clone;
        }
    }

    public static void main(String[] args) {
        /* Problem 50-a: Passing mutable objects to an immutable class can break down immutability. */
        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point p = new Point(1.23, 4.12, r);
        System.out.println("Radius start: " + p.getRadius().getStart());// 0

        /**
         * Is this class still immutable?
         * The answer is NO.
         * The Point class is not immutable anymore
         * because its state can be changed as in the following example:
         *
         * Notice that calling p.getRadius().getStart() returned two different results;
         * therefore, the state of p has been changed, so Point is no longer immutable.
         * */
        r.setStart(5);
        System.out.println("Radius start: " + p.getRadius().getStart());// 5

        /* Problem 50-b: Returning mutable objects to an immutable class can break down immutability. */
        Radius radius = new Radius();
        radius.setStart(0);
        radius.setEnd(120);

        Point point = new Point(1.23, 4.12, radius);
        System.out.println("Radius start: " + point.getRadius().getStart());// 0

        /**
         * Again, calling p.getRadius().getStart() returned two different results;
         * therefore, the state of p has been changed
         * */
        point.getRadius().setStart(5);
        System.out.println("Radius start: " + point.getRadius().getStart());// 5

        /* Solution to resolve both 50-a and 50-b problem */
        Radius radiusObj = new Radius();
        radiusObj.setStart(0);
        radiusObj.setEnd(120);

        PointModifyingRadiusCloneObj pointToRadiusObj = new PointModifyingRadiusCloneObj(1.23, 4.12, radiusObj);
        System.out.println("Radius start: " + pointToRadiusObj.getRadius().getStart());// 0

        radiusObj.setStart(5);
        System.out.println("Radius start: " + pointToRadiusObj.getRadius().getStart());// 5
    }
}
