package ObjectsImmutabilitySwitchExpressions;

public class StringConstantPoolOrCachedPool {
    /**
     * Objects Immutability Switch Expressions
     * Another knowledge: String constant pool or cached pool
     *
     * One of the reasons in favor of string immutability
     * is represented by the string constant pool (SCP) or cached pool.
     * In order to understand this statement,
     * let's dive a little into how the String class works internally.
     *
     * The SCP is a special area in memory (not the normal heap memory) used for
     * the storage of string literals. Let's assume the following three String
     * variables:
     *
     * String x = "book";
     * String y = "book";
     * String z = "book";
     *
     * How many String objects have been created?
     *
     * It is tempting to say 3, but actually
     * Java creates only one String object with the "book" value.
     *
     * The idea is that everything between quotes is considered as a string literal,
     * and Java stores string literals in this special area of memory called the SCP,
     * by following an algorithm like this
     * (this algorithm is known as String Interning)
     *
     * a. When a string literal is created (for example, String x = "book"),
     * Java inspects the SCP to see whether this string literal exists.
     *
     * b. If the string literal is not found in the SCP, then a new string
     * object for the string literal is created in the SCP and the
     * corresponding variable, x, will point to it.
     *
     * c. If the string literal is found in the SCP (for example, String y =
     * "book", String z = "book"), then the new variable will point to
     * the String object (basically, all variables that have the same value
     * will point to the same String object):
     *
     * But x should be "cook" and not "book", so let's replace "b" with "c"—x =
     * x.replace("b", "c");.
     * While x should be "cook", y and z should remain unchanged. This behavior is
     * provided by immutability. Java will create a new object and will perform the
     * change on it as follows:
     *
     * So, string immutability permits the caching of string literals,
     * which allows applications to use a large number of
     * string literals with a minimum impact
     * on the heap memory and garbage collector.
     *
     * In a mutable context, a modification of a string literal
     * may lead to corrupted variables.
     * Do not create a string as String x = new String("book").
     * This is not a string literal;
     *
     * This is a String instance (built via a constructor)
     * that will go in the normal memory heap instead of the SCP.
     * A string created in the normal heap memory can point to the SCP
     * by explicitly calling the String.intern() method as x.intern().
     * */

    /**
     * Advantages String Immutability:
     * 1. Security aspect
     * Commonly, a lot of sensitive information
     * (usernames, passwords, URLs, ports, databases,
     * socket connections, parameters, properties, and so on)
     * are represented and passed around as strings.
     *
     * 2. Thread safety
     * By having this information immutable, the code
     * becomes secure to a wide range of security threats
     * (for example, modifying the references accidentally or deliberately).
     *
     * Imagine an application using thousands of mutable String objects and
     * dealing with thread-safety code. Fortunately, in this case, our imagined
     * scenario will not become a reality, thanks to immutability. Any immutable
     * object is thread-safe by its nature. This means that strings can be shared and
     * manipulated by multiple threads, with no risk of corruption and
     * inconsistency
     *
     * 3. Hash code caching
     * The equals() and hashCode() section discussed equals() and hashCode().
     * Hash codes should be calculated every time they are involved in hashing
     * specific activities (for example, searching an element in a collection). Since
     * String is immutable, every string has an immutable hash code that can be
     * cached and reused as it cannot be changed after string creation. This means
     * that hash codes of strings can be used from the cache instead of recalculating
     * them at each usage. For example, HashMap hashes its keys for different
     * operations (for example, put(), get()), and if these keys are of
     * the String type, then hash codes will be reused from the cache instead of
     * recalculating them.
     *
     * 4. Class Loading
     * A typical approach for loading a class in memory relies on calling
     * the Class.forName(String className) method. Notice the String argument
     * representing the class name. Thanks to string immutability, the class name
     * cannot be changed during the loading process.
     *
     * However, if String is mutable, then imagine loading class A
     * (for example, Class.forName("A")),
     * and, during the loading process, its name will get changed to BadA.
     * Now, the BadA objects can do bad things!
     * */

    /**
     * Disadvantages of String Immutability:
     * 1. String cannot be extended
     * An immutable class should be declared final to avoid extensibility.
     * However, developers need to extend the String class
     * in order to add more features,
     * and this limitation can be considered a drawback of immutability.
     * Nevertheless, developers can write utility classes
     * (for example, Apache Commons Lang, StringUtils, Spring Framework, StringUtils, Guava, and
     * strings)
     * to provide extra features and simply pass strings
     * as arguments to the methods of these classes
     *
     * 2. Sensitive data in memory for a long time
     * Sensitive data in strings (for example, passwords) may reside in memory
     * (in SCP) for a long time.
     * Being a cache, the SCP takes advantage of special
     * treatment from the garbage collector.
     * More precisely, the SCP is not visited by the garbage collector
     * with the same frequency (cycles) as other memory zones.
     *
     * As a consequence of this special treatment, sensitive data is kept in
     * the SCP for a long time, and can be prone to unwanted usages.
     * In order to avoid this potential drawback, it is advisable to store sensitive
     * data (for example, passwords) in char[] instead of String.
     *
     * 3. OutOfMemoryError
     * The SCP is a small memory zone in comparison with others
     * and can be filled pretty quickly.
     * Storing too many string literals in the SCP will lead to
     * OutOfMemoryError.
     * */

    public static void main(String[] args) {
        StringConstantPoolOrCachedPool solution = new StringConstantPoolOrCachedPool();
    }
}
