package ObjectsImmutabilitySwitchExpressions;

public class StringConstantPoolOrCachedPool {
    /**
     * 1.49 String constant pool or cached pool
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
     * */
}
