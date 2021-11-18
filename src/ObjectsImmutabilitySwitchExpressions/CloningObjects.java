package ObjectsImmutabilitySwitchExpressions;
import com.rits.cloning.Cloner;

class Radius implements Cloneable {
    private int start;
    private int end;

    public Radius(int begin, int end) {
        this.start = begin;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class CloningObjects implements Cloneable {
    /**
     * 53. Cloning objects
     * Cloning objects is not a daily task, but it is important to do it properly.
     * Mainly, cloning objects refers to creating copies of objects. There are two
     * main types of copies—shallow copies (copy as little as possible) and deep
     * copies (copy everything).
     *
     * SOLUTIONS: There are 6 solutions to clone object in Java
     * Manual Cloning
     * Using clone() method
     * Using Copy constructor
     * Using CLONING LIBRARY
     * Using Serialization
     * Using JSON
     * */

    private double x;
    private double y;

    // Create Radius object
    private Radius radius;

    public CloningObjects() {}

    public CloningObjects(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // getters and setters
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }


    /**
     * 1. The first solution use Manual cloning
     * It consists of adding a method that copies the current Point
     * to a new Point manually (this is a shallow copy)
     *
     * Just create a new instance of Point and
     * populate its fields with the fields of the current Point.
     *
     * The returned Point is a shallow copy
     * (since Point doesn't depend on other objects, a deep copy will
     * be exactly the same) of the current Point:
     * This is shown in the following code:
     * @return CloningObjects
     * */
    public CloningObjects clonePoint() {
        CloningObjects point = new CloningObjects();
        point.setX(this.x);
        point.setY(this.y);
        return point;
    }

    /**
     * 2. The second solution use clone() method
     * The Object class contains a method named clone().
     * This method is useful for creating shallow copies
     * (it can be used for deep copies as well).
     *
     * In order to use it, a class should follow the given steps:
     * a. Implement the Cloneable interface (if this interface is not
     * implemented, then CloneNotSupportedException will be thrown).
     *
     * b. Override the clone() method (Object.clone() is protected).
     *
     * c. Call super.clone().
     *
     * Note that: The Cloneable interface doesn't contain any methods.
     * It is just a signal for JVM that this object can be cloned.
     * Once this interface is implemented,
     * the code needs to override the Object.clone() method.
     *
     * The reason why we have to override the Object.clone() method
     * because Object.clone() is protected, and in order to call it via super,
     * the code needs to override this method.
     * This can be a serious drawback
     * if clone() is added to a child class
     * since all superclasses should define a clone() method
     * in order to avoid the failure of the super.clone() chain invocation.
     *
     * This is shown in the following code:
     * @return CloningObjects
     * */
    @Override
    public CloningObjects clone() throws CloneNotSupportedException {
        return (CloningObjects) super.clone();//Shallow Copy
    }

//    @Override
//    public CloningObjects clone() throws CloneNotSupportedException {
//        CloningObjects cloneDeepCopy = (CloningObjects) super.clone();
//        cloneDeepCopy.radius = (Radius) radius.clone();
//        return cloneDeepCopy;//Deep Copy
//    }

    /**
     * 3. The third solution use Copy constructor
     * This cloning technique requires you to enrich the class with a constructor
     * that takes a single argument representing an instance of the class that will be
     * used to create the clone.
     * */
    // Copy constructor
    public CloningObjects(CloningObjects anotherCloningObjects) {
        this.x = anotherCloningObjects.x;
        this.y = anotherCloningObjects.y;
    }

    /**
     * 4. The fourth solution to clone object via the Cloning library using Deep Copy
     * A deep copy is needed when an object depends on another object.
     * Performing a deep copy means copying the object, including its chain of
     * dependencies.
     * For example, let's assume that Point has a field of the Radius type:
     *
     * Performing a shallow copy of Point will create a copy of x and y,
     * but will not create a copy of the radius object.
     *
     * This means that modifications that affect the radius object
     * will be reflected in the clone as well.
     * It's time for a deep copy.
     *
     * A cumbersome solution will involve adapting the shallow copy techniques
     * previously presented to support a deep copy.
     *
     * Fortunately, there are a few solutions that can be applied out of the box,
     * and one of them is the Cloning library
     * */
    public CloningObjects(double x1, double y1, Radius radius) {
        this.x = x1;
        this.y = y1;
        this.radius = radius;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("ORIGINAL OBJECT IN MANUAL CLONING");
        CloningObjects point = new CloningObjects(20.0, 50.0);
        System.out.println(point.getX());
        System.out.println(point.getY());

        // C1 Creating a clone object using Manual cloning
        System.out.println("CLONE OBJECT IN MANUAL CLONING");
        CloningObjects clonePoint = point.clonePoint();
        System.out.println(clonePoint.getX());
        System.out.println(clonePoint.getY());
        System.out.println("================================");

        try {
            /**
             * Any objects or local variables are created in try block
             * CANNOT be used outside try-catch block
             * */
            // C2A Creating a clone object using clone() method Shallow Copy
            // C2B Creating a clone object using clone() method Deep Copy: Open the clone() method for Deep Copy
            System.out.println("ORIGINAL OBJECT USING CLONE METHOD SHALLOW COPY");
            Radius radius = new Radius(50, 100);
            CloningObjects originalObj = new CloningObjects(20.0, 50.0, radius);
            System.out.println(originalObj.getX());
            System.out.println(originalObj.getY());
            System.out.println(originalObj.radius.getStart());
            System.out.println(originalObj.radius.getEnd());

            System.out.println("CLONE OBJECT USING CLONE METHOD SHALLOW COPY");
            CloningObjects clonePointUsingCloneMethod = originalObj.clone();
            System.out.println(clonePointUsingCloneMethod.getX());
            System.out.println(clonePointUsingCloneMethod.getY());
            System.out.println(clonePointUsingCloneMethod.radius.getStart());
            System.out.println(clonePointUsingCloneMethod.radius.getEnd());

            System.out.println("MODIFY RADIUS OBJECT INSIDE CLONE OBJECT");
            clonePointUsingCloneMethod.radius.setStart(999);

            System.out.println("ORIGINAL OBJECT AFTER MODIFY RADIUS OBJECT INSIDE CLONE OBJECT");
            clonePointUsingCloneMethod.radius.setStart(999);
            System.out.println(originalObj.radius.getStart());

            System.out.println("CLONE OBJECT AFTER MODIFY RADIUS OBJECT INSIDE CLONE OBJECT");
            System.out.println(clonePointUsingCloneMethod.radius.getStart());
            System.out.println("================================");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        // C3 Creating a clone object using Copy constructor
        System.out.println("ORIGINAL OBJECT USING COPY CONSTRUCTOR");
        CloningObjects originalObject = new CloningObjects(20.0, 50.0);
        System.out.println(point.getX());
        System.out.println(point.getY());

        System.out.println("CLONE OBJECT USING COPY CONSTRUCTOR");
        CloningObjects cloneObjectUsingCopyConstructor = new CloningObjects(originalObject);
        System.out.println(cloneObjectUsingCopyConstructor.getX());
        System.out.println(cloneObjectUsingCopyConstructor.getY());

        // C4 Creating a clone object using Cloning Library
        System.out.println("ORIGINAL OBJECT USING CLONING LIBRARY");
        CloningObjects original = new CloningObjects(20.0, 50.0);
        System.out.println(point.getX());
        System.out.println(point.getY());

        System.out.println("CLONE OBJECT USING CLONING LIBRARY");
        Cloner cloner = new Cloner();//Init Cloner in Cloning Library
        CloningObjects cloneDeepCopy = cloner.deepClone(original);
        System.out.println(cloneDeepCopy.getX());
        System.out.println(cloneDeepCopy.getY());

        // C5 Creating a clone object using Serialization
    }
}
