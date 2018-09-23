import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    private static final String socksString = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left,7/green/left,8/red/left,9/blue/left";
    private static HashMap<String, String> map;
    static int[] array = {1,2,3,4,5,6,7};
    static int byNumber = 3;
    public static void main(String[] args) {
        map = new HashMap<>();
        String[] commaSeparated = socksString.split(",");
        for (String aCommaSeparated : commaSeparated) {
            String[] tem = aCommaSeparated.split("/");
            map.put(tem[0], tem[1] + "-" + tem[2]);
        }
        final ArrayList<Integer> positionFound = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int pos;
            int matchPos;
            for (int i = 0; i < commaSeparated.length; i++) {
                String[] temArray = commaSeparated[i].split("/");
                String[] localArray = entry.getValue().split("-");
                if (temArray[1].equals(localArray[0]) && !temArray[2].equals(localArray[1])) {
                    if (!positionFound.contains(Integer.parseInt(entry.getKey())) && !positionFound.contains(Integer.parseInt(temArray[0]))) {
                        pos = Integer.parseInt(entry.getKey());
                        positionFound.add(pos);
                        matchPos = Integer.parseInt(temArray[0]);
                        System.out.println(pos + " " + matchPos);
                        positionFound.add(matchPos);
                    }
                }
            }
        }

       Main m = new Main();
       int[] rotatedArray = m.RotateArrayByNumber(array,byNumber);
       System.out.println(Arrays.toString(rotatedArray));

       String[] tokens = new String[] { "2", "1", "+", "3", "*" };
       int answer = m.evaluateRPN(tokens);
       System.out.println(answer);
    }


    /**
     * These method is used to rotate the array by given number. These method is called bubble rotate method
     * @param array
     * @param byNumber
     * @return
     */

    private int[] RotateArrayByNumber(int[] array, int byNumber){
        if(array == null || byNumber < 0){
            throw new IllegalArgumentException("Illegal argument..!");
        }
        for(int i = 0; i < byNumber; i++){
            for(int j = array.length -1; j > 0; j--){
                int tem = array[j];
                array[j] = array[j-1];
                array[j-1] = tem;
            }
        }
        return array;
    }

    /**
     *Evaluate reverse polish notation.
     * @param token
     * @return
     */

    private int evaluateRPN(String[] token){
        int returnValue = 0;
        String operator = "+-*/";

        Stack<String> stack = new Stack<>();

        for (String t:token){
            if(!operator.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operator.indexOf(t);
                switch(index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }
}
