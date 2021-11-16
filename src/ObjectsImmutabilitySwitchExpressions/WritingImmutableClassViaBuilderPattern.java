package ObjectsImmutabilitySwitchExpressions;

import java.util.Date;

public class WritingImmutableClassViaBuilderPattern {
    /**
     * Objects Immutability Switch Expressions
     * 51. Writing Immutable Class Via Builder Pattern
     * When a class (immutable or mutable) has too many fields,
     * it requires a constructor with many arguments.
     *
     * When some of those fields are required and others are optional,
     * this class will need several constructors to cover all
     * the possible combinations.
     *
     * This becomes cumbersome for the developer and for the user of the class.
     * This is where the Builder pattern comes to the rescue.
     *
     * According to the Gang of Four (GoF)—the Builder pattern separates the
     * construction of a complex object from its representation so that the same
     * construction process can create different representations.
     * The Builder pattern can be implemented as a separate class or as an inner
     * static class.
     *
     * The builder design pattern provides a way for you to build complex immutable objects.
     * The process is:
     * The client  calls a constructor (or static factory) with all the required parameters and gets a builder object.
     * The client calls setter like methods to set each optional parameter of interest.
     * Finally, the client calls the build method to generate the object which is immutable.
     *
     * Let's focus on the second case. The User class has three required
     * fields (nickname, password, and created) and three optional fields (email,
     * firstname, and lastname).
     * */

    /**
     * 1. The first solution to create an Immutable User class using the Builder pattern
     * */

    // WritingImmutableClassViaBuilderPattern is Immutable class
    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date created;

    private WritingImmutableClassViaBuilderPattern(UserBuilder builder) {
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.created = builder.created;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }

    public static UserBuilder getBuilder(
            String nickname, String password) {
        return new WritingImmutableClassViaBuilderPattern.UserBuilder(nickname, password);
    }

    // ConcreteBuilder
    public static final class UserBuilder {
        private final String nickname;
        private final String password;
        private final Date created;
        private String email;
        private String firstname;
        private String lastname;

        public UserBuilder(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }
        public UserBuilder firstName(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public UserBuilder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public WritingImmutableClassViaBuilderPattern build() {
            return new WritingImmutableClassViaBuilderPattern(this);
        }
    }

    public String getNickname() {
        return nickname;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public Date getCreated() {
        return new Date(created.getTime());
    }

    // Director
    public static void main(String[] args) {
        // user with nickname, password and email
        WritingImmutableClassViaBuilderPattern user1 = getBuilder("marin21", "hjju9887h").build();
        System.out.println(user1.getNickname());

        // user with nickname, password, email, firstname and lastname
        WritingImmutableClassViaBuilderPattern user2 = getBuilder("ionk", "44fef22")
                .email("ion@gmail.com")
                .build();
        System.out.println(user2.getNickname());

        WritingImmutableClassViaBuilderPattern user3 = getBuilder("monika", "klooi0988")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Ghuenter")
                .build();
        System.out.println(user3.getNickname());
    }
}
