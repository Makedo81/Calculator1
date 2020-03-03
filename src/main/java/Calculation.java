import java.util.List;

public class Calculation {

    private FunctionChecker functionChecker = new FunctionChecker();

    public double calculateResult(List<String> equation)  {
        double result = 0;
        double a;
        double b;

        if (functionChecker.multiply(equation)) {
            System.out.println("Multiply");
            do {
                for (int i = 0; i < equation.size(); i++) {
                    if (equation.get(i).equals("*")) {
                        a = Double.valueOf(equation.get(i - 1));
                        b = Double.valueOf(equation.get(i + 1));
                        System.out.println("a " + a + "  b " + b);
                        result = a * b;
                        updateList(equation, i, result);
                    }
                }
            } while (equation.contains("*"));
        }

        if (functionChecker.division(equation)) {
            System.out.println("Division");
            do {
                for (int i = 0; i < equation.size(); i++) {
                    if (equation.get(i).equals("/")) {
                        a = Double.valueOf(equation.get(i - 1));
                        b = Double.valueOf(equation.get(i + 1));
                        if (b == 0) {
                            throw new ArithmeticException();
                        }
                        System.out.println("a " + a + "  b " + b);
                        result = a / b;
                        updateList(equation, i, result);
                    }
                }
            } while (equation.contains("/"));
        }

        if (functionChecker.adding(equation)) {
            System.out.println("Addittion");
            do {
                for (int i = 0; i < equation.size(); i++) {
                    if (equation.get(i).equals("+")) {
                        a = Double.valueOf(equation.get(i - 1));
                        b = Double.valueOf(equation.get(i + 1));
                        System.out.println("a " + a + "  b " + b);
                        result = a + b;
                        updateList(equation, i, result);
                    }
                }
            } while (equation.contains("+"));
        }

        if (functionChecker.substracting(equation)) {
            System.out.println("Substraction");
            do {
                for (int i = 0; i < equation.size(); i++) {
                    if (equation.get(i).equals("-")) {
                        a = Double.valueOf(equation.get(i - 1));
                        b = Double.valueOf(equation.get(i + 1));
                        System.out.println("a " + a + "  b " + b);
                        result = a - b;
                        updateList(equation, i, result);
                    }
                }
            } while (equation.contains("-"));
        }
        System.out.println("Result " + Math.round(result*100.0)/100.0);
        return result;
    }

    private void updateList(List<String> list, int index, double result){
        list.remove(index - 1);
        list.add(index - 1, String.valueOf(result));
        list.remove((index + 1));
        list.remove(index);
    }
}
