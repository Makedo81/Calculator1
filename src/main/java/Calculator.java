import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws IllegalStateException {

        /**
         * Equation does not include brackets
         * Equation does not accept decimal and negative values
         */
        Scanner scanner = new Scanner(System.in);
        String equation="";
        do {
            try {
                System.out.println("Type equation and press ENTER for result");
                equation = scanner.next();
                ArrayCreator arrayCreator = new ArrayCreator();
                List<String> list = arrayCreator.createArray(equation);
                Calculation calculation = new Calculation();
                calculation.calculateResult(list);
            } catch (ArithmeticException o) {
                System.out.println("Some values try to be divide by '0'");
            } catch (IllegalStateException o) {
                System.out.println("Wrong equation pattern.Try new equation");
            }
        }
        while (!equation.equals("exit"));
    }
}
