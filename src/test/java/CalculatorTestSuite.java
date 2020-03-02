import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTestSuite {

    @Test
    public void testAddittion() {
        //given
        Calculation calculation = new Calculation();
        List<String> equation = new ArrayList<>();
        String[] array = {"12","+","2"};
        equation.addAll(Arrays.asList(array));
        //when
        double result = calculation.calculateResult(equation);
        //then
        Assert.assertEquals(14.00, result, 0.00);
    }
    @Test
    public void testSubstraction() {
        //given
        Calculation calculation = new Calculation();
        List<String> equation = new ArrayList<>();
        String[] array = {"12","-","2"};
        equation.addAll(Arrays.asList(array));
        //when
        double result = calculation.calculateResult(equation);
        //then
        Assert.assertEquals(10.00, result, 2);
    }
    @Test
    public void testDivision() {
        //given
        Calculation calculation = new Calculation();
        List<String> equation = new ArrayList<>();
        String[] array = {"12","/","2"};
        equation.addAll(Arrays.asList(array));
        //when
        double result = calculation.calculateResult(equation);
        //then
        Assert.assertEquals(6.00, result, 2);
    }
    @Test
    public void testMultiplying() {
        //given
        Calculation calculation = new Calculation();
        List<String> equation = new ArrayList<>();
        String[] array = {"12","*","2"};
        equation.addAll(Arrays.asList(array));
        //when
        double result = calculation.calculateResult(equation);
        //then
        Assert.assertEquals(24.00, result, 2);
    }

    @Test
    public void testComplexEquation() {
        //given
        Calculation calculation = new Calculation();
        List<String> equation = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        String[] array = {"3","-","12","*","2","/","6"};
        equation.addAll(Arrays.asList(array));
        String[] array2 = {"3","/","12","*","2","/","6"};
        equation2.addAll(Arrays.asList(array2));
        //when
        double result = calculation.calculateResult(equation);
        double result2 = Math.round(calculation.calculateResult(equation2));
        //then
        Assert.assertEquals(-1.00, result, 2);
        Assert.assertEquals(-0.02, result2, 2);
    }
    @Test
    public void testShouldCreateListFromStringEquation() {
        //given
        ArrayCreator arrayCreator = new ArrayCreator();
        String equation = "2+2*3/2";
        //when
        List<String> result = arrayCreator.createArray(equation);
        //then
        Assert.assertEquals(7, result.size());
    }
    @Test
    public void testShouldRecogniseFunction() {
        //given
        FunctionChecker functionChecker = new FunctionChecker();
        List<String> equation = new ArrayList<>();
        String[] array = {"3","-","12","*","2","/","6"};
        equation.addAll(Arrays.asList(array));
        List<String> equation2 = new ArrayList<>();
        String[] array2 = {"3","-","12","+","2","/","6"};
        equation2.addAll(Arrays.asList(array2));
        //when
        boolean result = functionChecker.adding(equation);
        boolean result2 = functionChecker.adding(equation2);
        //then
        Assert.assertEquals(false, result);
        Assert.assertEquals(true, result2);
    }
}
