import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.List;

public class CalculatorLayout {

    private ButtonCreator buttonCreator = new ButtonCreator();
    private TextField textField = buttonCreator.getTextField();

    private Button options[] = new Button[]{
            new Button("1"),
            new Button("2"),
            new Button("3"),
            new Button("="),
            new Button("4"),
            new Button("5"),
            new Button("6"),
            new Button("C"),
            new Button("7"),
            new Button("8"),
            new Button("9"),
            new Button("0"),
            new Button("+"),
            new Button("-"),
            new Button("*"),
            new Button("/"),
    };

    private Button one = options[0];
    private Button two = options[1];
    private Button three = options[2];
    private Button four = options[4];
    private Button five = options[5];
    private Button six = options[6];
    private Button seven = options[8];
    private Button eight = options[9];
    private Button nine = options[10];
    private Button zero = options[11];
    private Button add = options[12];
    private Button substract = options[13];
    private Button multiply = options[14];
    private Button divide = options[15];
    private Button result = options[3];
    private Button delete = options[7];

    public void setButtons() {
        one.setOnAction(e -> {
            buttonCreator.getTextField().appendText(one.getText());
        });
        two.setOnAction(e -> {
            textField.appendText(two.getText());
        });
        three.setOnAction(e -> {
            textField.appendText(three.getText());
        });
        four.setOnAction(e -> {
            textField.appendText(four.getText());
        });
        five.setOnAction(e -> {
            buttonCreator.getTextField().appendText(five.getText());
        });
        six.setOnAction(e -> {
            textField.appendText(six.getText());
        });
        seven.setOnAction(e -> {
            textField.appendText(seven.getText());
        });
        eight.setOnAction(e -> {
            textField.appendText(eight.getText());
        });
        nine.setOnAction(e -> {
            textField.appendText(nine.getText());
        });
        zero.setOnAction(e -> {
            textField.appendText(zero.getText());
        });
        add.setOnAction(e -> {
            textField.appendText(add.getText());
        });
        substract.setOnAction(e -> {
            textField.appendText(substract.getText());
        });
        multiply.setOnAction(e -> {
            textField.appendText(multiply.getText());
        });
        divide.setOnAction(e -> {
            textField.appendText(divide.getText());
        });
        delete.setOnAction(e -> {
            textField.clear();
        });
        result.setOnAction(e -> {
            try {
                ArrayCreator arrayCreator = new ArrayCreator();
                List<String> list = arrayCreator.createArray(buttonCreator.getTextField().getText());
                Calculation calculation = new Calculation();
                double result = calculation.calculateResult(list);
                buttonCreator.getTextField().clear();
                buttonCreator.getTextField().setText(String.valueOf(result));
            } catch (ArithmeticException o) {
                System.out.println("Some values try to be divide by '0'");
                textField.clear();
                textField.setText(" error ");
            } catch (IllegalStateException o) {
                System.out.println("Wrong equation pattern.Try new equation");
                textField.clear();
                textField.setText(" error ");
            }
        });
    }

    public Button[] getOptions() {
        return options;
    }
}
