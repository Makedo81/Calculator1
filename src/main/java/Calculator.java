import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IllegalStateException{

        /**
         * Equation does not include brackets
         * Equation does not accept double and negative values
         */
        Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Type equation and press ENTER for result");
                String equation = scanner.next();
                ArrayCreator arrayCreator = new ArrayCreator();
                List<String> list = arrayCreator.createArray(equation);
                Calculation calculation = new Calculation();
                calculation.calculateResult(list);
            } catch (ArithmeticException o) {
                System.out.println("Some values try to be divide by '0'");
            } catch (IllegalStateException o) {
                System.out.println("Wrong equation pattern");
                System.out.println("Try new equation");
            }
    }
}
