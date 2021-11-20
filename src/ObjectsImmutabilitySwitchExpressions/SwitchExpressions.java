package ObjectsImmutabilitySwitchExpressions;

class Player {
    String name;
    int position;
}

class PlayerTypes extends Player {
}

class TennisPlayer extends Player {
}

class FootballPlayer extends Player {
}

class SnookerPlayer extends Player {
}

class UnknownPlayerException extends Exception {
    public UnknownPlayerException(String errorMessage) {
        super(errorMessage);
    }
}

public class SwitchExpressions {
    private static PlayerTypes TENNIS;
    private static PlayerTypes FOOTBALL;
    private static PlayerTypes SNOOKER;
    private static PlayerTypes UNKNOWN;

    /**
     * Objects Immutability Switch Expressions
     * 55. Switch Expressions
     *
     * Before we have a brief overview of the switch expressions introduced in JDK
     * 12, let's see a typical old-school example wrapped in a method
     *
     * If we forget about default, then the code will not compile.
     * Obviously, the preceding example is acceptable. In the worst-case scenario,
     * we can add a spurious variable (for example, player),
     * some cluttering break statements, and get no complaints if default is missing.
     * So, the following code is an old-school, extremely ugly switch:
     *
     * If we forget about default, then there will be no complaints from the
     * compiler side.
     * In this case, a missing default case may result in a null player.
     *
     * However, since JDK 12, we have been able to rely on the switch expressions.
     * Before JDK 12, switch was a statement, a construct meant to control the flow
     * (for example, as an if statement) without representing the result.
     * On the other hand, an expression is evaluated to a result.
     * Therefore, a switch expression can have a result.
     * The preceding switch expression can be written in the style of JDK 12 as follows:
     * */
    private static Player createPlayer(String playerType) throws UnknownPlayerException {
        Player player = null;

        switch (playerType) {
            case "TENNIS":
                player = new TennisPlayer();
                break;
            case "FOOTBALL":
                player = new FootballPlayer();
                break;
            case "SNOOKER":
                player = new SnookerPlayer();
                break;
            case "UNKNOWN":
                throw new UnknownPlayerException("Player type is unknown");
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        }

        return player;
    }

    /**
     * Notice that between the label and execution, we've replaced the colon with
     * an arrow (the lambda-style syntax).
     * The main role of this arrow is to prevent fall-through,
     * which means that only the block of code from its right will be executed.
     * There is no need to use break.
     * Do not conclude that the arrow turns the switch statement into a switch
     * expression.
     * A switch expression can be used with a colon and break as well, as follows:
     *
     * Our example posts switch over enum,
     * but the JDK 12 switch can also be used over int, Integer, short,
     * Short, byte, Byte, char, Character, and String.
     *
     * Notice that JDK 12 brings the switch expressions as a preview feature.
     * This means that it is prone to changes in the next few releases,
     * and it needs to be unlocked via the --enable-preview command-line
     * option at compiling and runtime
     * */
    private static Player createAnotherPlayer(PlayerTypes playerType) throws UnknownPlayerException {
        return switch (playerType) {
            case TENNIS:
                new TennisPlayer();
            case FOOTBALL:
                new FootballPlayer();
            case SNOOKER:
                new SnookerPlayer();
            case UNKNOWN:
                throw new UnknownPlayerException("Player type is unknown");
            // default is not mandatory
            default:
                throw new IllegalArgumentException("Invalid player type: " + playerType);
        };
    }


    public static void main(String[] args) throws UnknownPlayerException {
        SwitchExpressions switchExpressions = new SwitchExpressions();

        // C1
        switchExpressions.createPlayer("TENNIS");

        // C2
        switchExpressions.createAnotherPlayer("TENNIS");
    }
}
