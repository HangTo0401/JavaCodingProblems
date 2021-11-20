package StringNumbersMath;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatting {
    /**
     * Math Manipulation
     * 39. Compact Number Formatting
     *
     * SOLUTIONS: There is 1 solution to this problem
     * */

    /**
     * 1. The first solution use
     * Starting with JDK 12, a new class for compact number formatting was added.
     * This class is named java.text.CompactNumberFormat.
     *
     * The main goal of this class is to extend the existing J
     * ava number formatting API with support for locale and compaction
     *
     * A number can be formatted into a short style
     * (for example, 1000 becomes 1K) or into a long style
     * (for example, 1000 becomes 1 thousand)
     *
     * These two styles were grouped in the Style enum as SHORT and LONG.
     * Besides, the CompactNumberFormat constructor, CompactNumberFormat can be
     * created via two static methods that are added to the NumberFormat class:
     * The first is a compact number format for the default locale with
     * NumberFormat.Style.SHORT
     * */
    public static String forLocale(Locale locale, double number) {
        return format(locale, Style.SHORT, null, number);
    }



    public static String forLocaleStyle(
            Locale locale, Style style, double number) {
        return format(locale, style, null, number);
    }

    public static String forLocaleStyleRound(
            Locale locale, Style style, RoundingMode mode, double number) {
        return format(locale, style, mode, number);
    }

    private static String format(
            Locale locale, Style style, RoundingMode mode, double number) {
        if (locale == null || style == null) {
            return String.valueOf(number); // or use a default format
        }
        NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, style);
        if (mode != null) {
            nf.setRoundingMode(mode);
        }
        return nf.format(number);
    }


    public static void main(String[] args) {
        CompactNumberFormatting NumberFormatters = new CompactNumberFormatting();

        // 2000 (2 thousand)
        NumberFormatters.forLocaleStyleRound(Locale.US, Style.LONG, RoundingMode.UP, 1_200);

        // 1000 (1 thousand)
        NumberFormatters.forLocaleStyleRound(Locale.US, Style.LONG, RoundingMode.DOWN, 1_600);
    }
}
