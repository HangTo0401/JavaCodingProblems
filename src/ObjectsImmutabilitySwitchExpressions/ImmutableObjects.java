package ObjectsImmutabilitySwitchExpressions;

public class ImmutableObjects {
    /**
     * Objects Immutability Switch Expressions
     * 47. Immutable objects in a nutshell
     *
     * An immutable object is an object that
     * cannot be changed (its state is fixed) once it is created.
     *
     * In Java, the following applies:
     * Primitive types are immutable.
     *
     * The famous Java String class is immutable (other classes are
     * immutable as well, for example, Pattern, and LocalDate)
     * Arrays are not immutable.
     *
     * Collections can be mutable, unmodifiable, or immutable.
     *
     * An unmodifiable collection is not automatically immutable. It depends on
     * which objects are stored in the collection.
     * If the stored objects are mutable,
     * then the collection is mutable and unmodifiable.
     *
     * But if the stored objects are immutable,
     * then the collection is effectively immutable.
     *
     * Immutable objects are useful in concurrent (multithreading) applications and
     * streams.
     *
     * Since immutable objects cannot be changed, they are impassible to
     * concurrency issues, and they don't risk being corrupted or inconsistent.
     *
     * One of the main concerns of using immutable objects is related to the
     * penalties of creating new objects, instead of managing the state of a mutable
     * object.
     *
     * But keep in mind that immutable objects take advantage of special
     * treatment during garbage collection.
     *
     * Moreover, they are not prone to concurrency issues
     * and eliminate the code needed for managing the state of the mutable objects
     *
     * The code necessary to manage the state of mutable objects
     * is prone to be slower than the creation of new objects.
     * Looking at the following problems will allow us to dive deeper into object
     * immutability in Java
     * */
}
