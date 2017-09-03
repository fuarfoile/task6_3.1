import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Converter {
    private static Logger logger = LogManager.getLogger(Converter.class);

    public static String decToBin(int number) {
        logger.info("decToBin, input number = " + number);

        if (number < 0) {
            logger.error("decToBin, input number can't be less zen zero");
            return "";
        }

        StringBuilder result = new StringBuilder();
        while(number > 1) {
            result.insert(0, number % 2);
            number >>= 1;
        }
        result.insert(0, number);

        return result.toString();
    }

    public static String decToOct(int number) {
        logger.info("decToOct, input number = " + number);

        if (number < 0) {
            logger.error("decToOct, input number can't be less zen zero");
            return "";
        }

        String result = "";
        while(number > 7) {
            result = number % 8 + result;
            number >>= 3;
        }

        return number + result;
    }

    public static String decToHex(int number) {
        logger.info("decToHex, input number = " + number);

        if (number < 0) {
            logger.error("decToHex, input number can't be less zen zero");
            return "";
        }

        String result = "";
        while (number > 15) {

            if (number % 16 > 9) {
                result = (char) (number % 16 + 'a' - 10) + result;
            }
            else {
                result = number % 16 + result;
            }

            number >>= 4;
        }

        if (number % 16 > 9) {
            result = (char) (number % 16 + 'a' - 10) + result;
        }
        else {
            result = number % 16 + result;
        }

        return result;
    }
}
