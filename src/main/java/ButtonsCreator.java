import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.List;

public class ButtonsCreator {

    private CalculatorLayout calculatorLayout = new CalculatorLayout();
    private TextField textField = calculatorLayout.getTextField();
    private boolean resultCompleted;
    private ArrayCreator arrayCreator = new ArrayCreator();

    private Button[] options = new Button[]{
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

    public void setButtonsAction() {
        for (int i = 0; i <=15; i++) {
            Button button = options[i];
            if (i == 7) {
                button.setOnAction(e -> {
                    textField.clear();
                });
            } else if (i == 3) {
                button.setOnAction(e -> {
                    try {
                        ArrayCreator arrayCreator = new ArrayCreator();
                        List<String> list = arrayCreator.createArray(calculatorLayout.getTextField().getText());
                        Calculation calculation = new Calculation();
                        double result = calculation.calculateResult(list);
                        calculatorLayout.getTextField().clear();
                        calculatorLayout.getTextField().setText(String.valueOf(result));
                    } catch (ArithmeticException o) {
                        System.out.println("Some values try to be divide by '0'");
                        textField.clear();
                        textField.setText(" error ");
                    } catch (IllegalStateException o) {
                        System.out.println("Wrong equation pattern.Try new equation");
                        textField.clear();
                        textField.setText(" error ");
                    }
                    resultCompleted = true;
                });
                
            } else if (i == 12 || i == 13 || i == 14 || i == 15) {
                options[i].setOnAction(e -> {
                    if (!resultCompleted) {
                        addFunctionSign(button, textField.getText());
                    } else {
                        resultCompleted = false;
                        textField.clear();
                        addNumber(button);
                    }
                });
                
            } else {
                    options[i].setOnAction(e -> {
                        if (!resultCompleted) {
                            addNumber(button);
                        } else {
                            resultCompleted = false;
                            textField.clear();
                            addNumber(button);
                        }
                    });
            }
        }
    }

    public Button[] getOptions() {
        return options;
    }

    private void addNumber(Button button){
        textField.appendText(button.getText());
    }

    private boolean checkPattern(String pattern){
        List<String> list = arrayCreator.createList(pattern);
        if(list.get(list.size()-1).matches("[-+*/]")){
            return true;
        }else return false;
    }

    private void addFunctionSign(Button button, String pattern){
        if(!checkPattern(pattern)) {
            textField.appendText(button.getText());
        }
    }
}
