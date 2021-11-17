package ObjectsImmutabilitySwitchExpressions;

import java.util.Date;

public class AvoidingBadDataInImmutableObjects {
    /**
     * Objects Immutability Switch Expressions
     * 52. Avoiding bad data in immutable objects
     *
     * Bad data is any data that has a negative impact on the immutable object
     * (for example, corrupted data).
     *
     * Most probably, this data comes from user inputs or
     * from external data sources that are not under our direct control.
     * In such cases, bad data can hit the immutable object,
     * and the worst part is that there is no fix for it.
     * An immutable object cannot be changed after creation;
     * therefore, bad data will live happily as long as the object lives.
     * */

    /**
     * The solution to this problem is to validate all data
     * that enters an immutable object against a comprehensive set of constraints.
     *
     * There are different ways of performing validation,
     * from custom validation to built-in solutions.
     *
     * Validation can be performed outside or inside the immutable object class,
     * depending on the application design.
     *
     * For example, if the immutable object is built via the Builder pattern,
     * then the validation can be performed in the builder class.
     *
     * JSR 380 is a specification of the Java API for bean validation (Java SE/EE)
     * that can be used for validation via annotations.
     *
     * Hibernate Validator is the reference implementation of the validation API,
     * and it can be easily provided as a Maven dependency in the pom.xml file
     * (check the source code bundled to this book).
     *
     * Furthermore, we rely on dedicated annotations to provide the needed
     * constraints (for example, @NotNull, @Min, @Max, @Size, and @Email).
     * In the following example, the constraints are added to the builder class as follows:
     * */
    private final String nickname;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date created;

    public AvoidingBadDataInImmutableObjects(UserBuilder userBuilder) {
        this.nickname = userBuilder.nickname;
        this.password = userBuilder.password;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.created = userBuilder.created;
    }
    public static UserBuilder getBuilder(String nickname, String password) {
        return new AvoidingBadDataInImmutableObjects.UserBuilder(nickname, password);
    }

    // ConcreteBuilder
    public static final class UserBuilder {
        @NotNull(message = "cannot be null")
        @Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
        private final String nickname;

        @NotNull(message = "cannot be null")
        @Size(min = 6, max = 50, message = "must be between 6 and 50 characters")
        private final String password;

        @Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
        private String firstName;

        @Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
        private String lastName;

        @Email(message = "must be valid")
        private String email;

        private final Date created;

        public UserBuilder(String nickname, String password) {
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        // Setter methods
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        // Generate the immutable object which is UserBuilder
        public AvoidingBadDataInImmutableObjects build() {
            return new AvoidingBadDataInImmutableObjects(this);
        }

        public String getNickname() {
            return nickname;
        }
        public String getPassword() {
            return password;
        }

        public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public String getEmail() {
            return email;
        }
        public Date getCreated() {
            return new Date(created.getTime());
        }
    }
}
