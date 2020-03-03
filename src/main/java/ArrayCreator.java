import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCreator {

    public List<String> createArray(String equation) throws IllegalStateException {
        List<String> list;
        String[] array = equation.split("((?<=\\d)(?=\\D)|(?<=\\D)(?=\\d))");
        if(array[0].matches("[-+*/()]")|| array[array.length-1].matches("[-+*/()]")){
            throw new IllegalStateException();
        }
        list = new ArrayList<>(Arrays.asList(array));
        for (String element:list) {
            if(!equation.equals("exit"))
                System.out.println(element);
        }
        return list;
    }
}
