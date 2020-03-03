import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private CalculatorLayout calculatorLayout = new CalculatorLayout();
    private GridPane gridPane = calculatorLayout.createCalculatorDisplay();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(gridPane, 550, 500);
        primaryStage.setMaxHeight(550);
        primaryStage.setMaxWidth(420);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        /**
         * Equation does not include brackets
         * Equation does not accept decimal and negative values
         */
        Application.launch(args);


//        Scanner scanner = new Scanner(System.in);
//        String equation="";
//        do {
//            try {
//                System.out.println("Type equation and press ENTER for result");
//                equation = scanner.next();
//                ArrayCreator arrayCreator = new ArrayCreator();
//                List<String> list = arrayCreator.createArray(equation);
//                Calculation calculation = new Calculation();
//                calculation.calculateResult(list);
//            } catch (ArithmeticException o) {
//                System.out.println("Some values try to be divide by '0'");
//            } catch (IllegalStateException o) {
//                System.out.println("Wrong equation pattern.Try new equation");
//            }
//        }
//        while (!equation.equals("exit"));
    }
}
