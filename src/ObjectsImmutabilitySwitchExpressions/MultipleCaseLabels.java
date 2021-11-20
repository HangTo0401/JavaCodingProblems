package ObjectsImmutabilitySwitchExpressions;


class SportType {

}

class Individual extends SportType {

}

class Team extends SportType {

}

public class MultipleCaseLabels {
    /**
     * Objects Immutability Switch Expressions
     * 56. Multiple Case Labels
     *
     * Before JDK 12, a switch statement allowed a single label per case. Starting
     * with the switch expressions, a case can have multiple labels separated by a
     * comma. Check out the following method that exemplifies multiple case
     * labels:
     *
     * So, if we pass to this method TENNIS, GOLF, or SNOOKER, it will return an
     * instance of the Individual class.
     * If we pass FOOTBALL or VOLLEY, it will return an instance of the Team class
     * */
    private static SportType fetchSportTypeByPlayerType(String playerType) {
        return switch (playerType) {
            case "TENNIS", "GOLF", "SNOOKER" -> new Individual();
            case "FOOTBALL", "VOLLEY" -> new Team();
        };
    }
}
