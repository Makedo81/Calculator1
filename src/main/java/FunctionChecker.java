import java.util.List;

public class FunctionChecker {

    public boolean adding(List<String> equation ) {
        boolean hasAddFunction = false;
        for (String s : equation) {
            if (s.equals("+")) {
                hasAddFunction = true;
            }
        }
        return hasAddFunction;
    }

    public boolean substracting(List<String> equation ) {
        boolean hasSubstractFunction = false;
        for (String s : equation) {
            if (s.equals("-")) {
                hasSubstractFunction = true;
            }
        }
        return hasSubstractFunction;
    }

    public boolean multiply(List<String> equation ) {
        boolean hasMultiplyFunction = false;
        for (String s : equation) {
            if (s.equals("*")) {
                hasMultiplyFunction = true;
            }
        }
        return hasMultiplyFunction;
    }

    public boolean division(List<String> equation) {
        boolean hasDivideFunction = false;
        for (String s : equation) {
            if (s.equals("/")) {
                hasDivideFunction = true;
            }
        }
        return hasDivideFunction;
    }
}
