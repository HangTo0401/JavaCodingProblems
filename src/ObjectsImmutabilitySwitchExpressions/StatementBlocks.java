package ObjectsImmutabilitySwitchExpressions;

public class StatementBlocks {
    /**
     * Objects Immutability Switch Expressions
     * 57. Statement blocks
     *
     * A label's arrow can point to a single statement (as in the examples from the
     * previous two problems) or to a curly-braced block.
     * This is pretty similar to the lambda blocks.
     * Check out the following solution:
     *
     * Notice that we exit from a curly-braced block via break, not return.
     * In other words, while we can return from inside a switch statement,
     * we can't return from within an expression.
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */
    private static Player createPlayer(String playerType) {
        return switch (playerType) {
            case "TENNIS" -> {
                System.out.println("Creating a TennisPlayer ...");
                break new TennisPlayer();
            }
            case "FOOTBALL" -> {
                System.out.println("Creating a FootballPlayer ...");
                break new FootballPlayer();
            }
            case "SNOOKER" -> {
                System.out.println("Creating a SnookerPlayer ...");
                break new SnookerPlayer();
            }
            default ->
                    throw new IllegalArgumentException(
                            "Invalid player type: " + playerType);
        };
    }

    public static void main(String[] args) {
        StatementBlocks statementBlocks = new StatementBlocks();
        statementBlocks.createPlayer("TENNIS");
    }
}
