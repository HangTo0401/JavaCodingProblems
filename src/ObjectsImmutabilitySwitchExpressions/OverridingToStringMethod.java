package ObjectsImmutabilitySwitchExpressions;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class OverridingToStringMethod {
    /**
     * Objects Immutability Switch Expressions
     * 54 Overriding toString() method
     *
     * The toString() method is defined in java.lang.Object, and the JDK comes
     * with a default implementation of it.
     *
     * This default implementation is automatically
     * used for all objects that are the subject of print(), println(),
     * printf(), debugging during development, logging, informative messages in
     * exceptions, and so on.
     *
     * Unfortunately, the string representation of an object returned by the default
     * implementation is not very informative.
     *
     * SOLUTIONS: There is 1 solution to this problem
     * Note that: SHOULD NOT INCLUDE PASSWORD, ACCOUNT OR SECRET IP ADDRESS in toString() method
     * */

    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date created;

    public OverridingToStringMethod(String nickname, String password, String firstname, String lastname, String email, Date created) {
        this.nickname = nickname;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.created = created;
    }

    /**
     * 1. The first solution is to override toString() method
     * The solution for avoiding outputs as in the preceding screenshot consists of
     * overriding the toString() method
     * This time, println() will reveal the output based on toString() method
     * This is much more informative than the previous output.
     * But, remember that toString() is automatically called for different purposes.
     *
     * For example, logging can be as follows:
     * logger.log(Level.INFO, "This user rocks: {0}", user);
     *
     * Here, the user password will hit the log, and this may represent a problem.
     * Exposing log-sensitive data, such as passwords, accounts, and secret IPs, in
     * an application is definitely a bad practice.
     *
     * Therefore, pay extra attention to carefully selecting the information that goes
     * in toString(), since this information may end up in places where it can be
     * maliciously exploited. In our case, the password should not be part of
     * toString():
     * */
    @Override
    public String toString() {
        return "User{" + "nickname=" + nickname + ", password=" +
                password
                + ", firstname=" + firstname + ", lastname=" + lastname
                + ", email=" + email + ", created=" + created + '}';
    }

    public static void main(String[] args) {
        OverridingToStringMethod user = new OverridingToStringMethod("sparg21",
                                                                     "kkd454ffc",
                                                                     "Leopold",
                                                                     "Mark",
                                                                       "markl@yahoo.com",
                                                                     new Date());

        /*
        * The output of this println() method will be something like OverridingToStringMethod.PNG picture
        * Commonly, toString() is a method generated via an IDE.
        * So, pay attention to which fields you select
        * before the IDE generates the code for you
        * */
        System.out.println(user);
    }
}
