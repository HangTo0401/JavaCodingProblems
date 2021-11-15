package ObjectsImmutabilitySwitchExpressions;

import java.lang.reflect.Field;

public class IsStringCompletelyImmutable {
    /**
     * Is String completely immutable?
     * String uses private final char[] to store each
     * character of the string.
     *
     * By using the Java Reflection API, in JDK 8,
     * the following code will modify this char[]
     * (the same code in JDK 11 will throw java.lang.ClassCastException):
     * */

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        String user = "guest";
        System.out.println("User is of type: " + user);

        Class<String> type = String.class;
        Field field = type.getDeclaredField("value");
        field.setAccessible(true);// Illegal reflective access warning

        char[] chars = (char[]) field.get(user);
        chars[0] = 'a';
        chars[1] = 'd';
        chars[2] = 'm';
        chars[3] = 'i';
        chars[4] = 'n';

        System.out.println("User is of type: " + user);
    }
}
