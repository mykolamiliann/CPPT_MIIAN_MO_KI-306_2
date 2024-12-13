package KI.Milian.Lab5;

/**
 * Class <code>Functions</code> implements method for 7x / tg(2x - 4) expression
 * calculation
 * @version 1.0
 */

public class Function {
    /**
    * Method calculates the 7x / tg(2x - 4) expression*
    * @param x Angle in degrees
    * @throw CalcException
    * @return result
    */
    public static double calculate(double x) throws CalcException {
        double y;
        double rad = x * Math.PI / 180.0;

        try {
            y = 7 * rad / Math.tan(2*rad - 4);

            // Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY)
                throw new ArithmeticException();
        }
        // виникнення помилки
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            throw new CalcException();
        }

        return y;
    }
}
