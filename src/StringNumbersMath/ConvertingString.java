package StringNumbersMath;

public class ConvertingString {
    /**
     * 1.7  Converting a string into an int, long, float, double
     *
     * SOLUTIONS: There are 2 solutions to this problem
     */

    /**
     * When a String cannot be converted successfully,
     * Java throws a NumberFormatException exception
     * The following code speaks for itself:
     */
    public void convertStringToObject(String TO_INT, String TO_LONG, String TO_FLOAT, String TO_DOUBLE, String WRONG_NUMBER) {

        try {
            /**
             * Converting String into an Integer, Long, Float, or Double object can be
             * accomplished via the following Java methods—Integer.valueOf(),
             * Long.valueOf(), Float.valueOf(), and Double.valueOf():
             */
            Integer intVariable = Integer.valueOf(TO_INT);
            Long longVariable = Long.valueOf(TO_LONG);
            Float floatVariable = Float.valueOf(TO_FLOAT);
            Double doubleVariable = Double.valueOf(TO_DOUBLE);

            System.out.println("Integer: " + intVariable);
            System.out.println("Long: " + longVariable);
            System.out.println("Float: " + floatVariable);
            System.out.println("Double: " + doubleVariable);

            Integer toIntWrong1 = Integer.valueOf(WRONG_NUMBER);
            System.out.println("Wrong type: " + toIntWrong1);
        } catch (NumberFormatException e) {
            System.out.println("Exception:\n");
            System.err.println(e);
            // handle exception
            e.printStackTrace();
        }
    }

    public void convertStringToPrimitive(String TO_INT, String TO_LONG, String TO_FLOAT, String TO_DOUBLE, String WRONG_NUMBER) {

        try {
            int toInt = Integer.parseInt(TO_INT);
            long toLong = Long.parseLong(TO_LONG);
            float toFloat = Float.parseFloat(TO_FLOAT);
            double toDouble = Double.parseDouble(TO_DOUBLE);

            System.out.println("int: " + toInt);
            System.out.println("long: " + toLong);
            System.out.println("float: " + toFloat);
            System.out.println("double: " + toDouble);

            int toIntWrong2 = Integer.parseInt(WRONG_NUMBER);
            System.out.println("Wrong type: " + toIntWrong2);
        } catch (NumberFormatException e) {
            System.out.println("Exception:\n");
            System.err.println(e);
            // handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConvertingString solution = new ConvertingString();
        solution.convertStringToObject("453", "45234223233", "45.823F", "13.83423D", "452w");
        solution.convertStringToPrimitive("453", "45234223233", "45.823F", "13.83423D", "452w");
    }
}
