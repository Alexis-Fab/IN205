package ensta;
import ensta.Color;

public class ColorUtil {

    /* ***
     * Constructeur de la classe ColorUtil, utilisable uniquement par la classe elle-même
     */
    private ColorUtil() {};

    /* ***
     * Méthodes de la classe ColorUtil
     */
    public static String colorize(String text, Color color) {
        return String.format("%s%s%s", color.value, text, Color.RESET.value);
    }

    public static String colorize(Character text, Color color) {
        return colorize("" + text, color);
    }
}
