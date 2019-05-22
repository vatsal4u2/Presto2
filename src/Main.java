import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static final String socksString = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left,7/green/left,8/red/left,9/blue/left";
    private static HashMap<String, String> map;
    static int[] array = {1,2,3,4,5,6,7};
    static int byNumber = 3;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       /* map = new HashMap<>();
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
        }*/

       Main m = new Main();
       int[] rotatedArray = m.RotateArrayByNumber(array,byNumber);
       System.out.println(Arrays.toString(rotatedArray));

       /*String[] tokens = new String[] { "2", "1", "+", "3", "*" };
       int answer = m.evaluateRPN(tokens);
       System.out.println(answer);

       m.problemTwo();*/

       /*Node node = new Node("root",new Node("left",new Node("left.left",null,null),null),new Node("right",null,null));

        // serialize the object
       String serializedNode = toString(node);
       System.out.println(serializedNode);
       Node node1 = (Node) fromString(serializedNode);
       String output = node1.mLeft.mLeft.mValue;
       System.out.println(output);
*/
        int[] arr = {3,4,2,1,8};
        int size = arr.length;
       int res =  m.duplicates(arr);
        System.out.println("The repeating elements are : " + res);
        int index = m.findIndexOfElement(arr,8);
        System.out.println("The index of value " + index);


        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=1;i<30;i++){
            numbers.add(i);
        }
        //add duplicate number into the list
        numbers.add(10);
        FindDuplicateNumber dn = new FindDuplicateNumber();
        System.out.println("Duplicate Number: "+dn.duplicateNumber(numbers));

        // String reverse using recursive method
        StringRecursiveReverse sr = new StringRecursiveReverse();
        String reverse = sr.reverseString("Vatsal");
        System.out.println(reverse);

        // Reverse integer number
        NumberReverse nr = new NumberReverse();
        System.out.println("Result: "+nr.reverseNumber(17868));

        // Decimal to Binary conversion
        DecimalToBinary dtob = new DecimalToBinary();
        dtob.convertDesiToBin(25);

        // find duplicate character from string
        DuplicateCharacterInString dins = new DuplicateCharacterInString();
        dins.findDuplicateCharacter("Vatsal");

        // Sort map by value
        SortMapByValue sbv = new SortMapByValue();
        sbv.sortMapByValue();

        //Sort array
        Arrays.sort(arr);
        for(int n :arr){
            System.out.println("Sorted arry : "+ n);
        }

        //Fibonacci series
        FibonacciSeries fb = new FibonacciSeries();
        fb.printFibonacci();

        // check prime number
        PrimeNumber pm = new PrimeNumber();
        //pm.checkIfPrime(7);
        pm.findPrimeNumberInHundred();

        //Check armstrong number
        FindArmStrongNumber arm = new FindArmStrongNumber();
        arm.checkArmStrongNumber(153);

        //Binaray to Decimal
        BinaryToDecimal btod = new BinaryToDecimal();
        btod.binaryToDecimal(11);

        // Find permuted String
        List<String> permutedStringList = StringPermutation.permutedString("xyz");
        permutedStringList.stream().forEach(System.out::println);

        // find missing positive integer
        FindMissingPositiveInteger findMissingPositiveInteger = new FindMissingPositiveInteger();
        int result = findMissingPositiveInteger.findMissingInt();
        System.out.println("Missing positive integer :--> "+result);
    }



    private int findIndexOfElement(int[] array, int value){

        if(array == null)
            return -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }


    int duplicates(final int[] array)
    {
        Set<Integer> lump = new HashSet<Integer>();
        for (int i : array)
        {
            if (lump.contains(i)) return i;
            lump.add(i);
        }
        return 0;
    }

    /** Read the object from Base64 string. */
    private static Object fromString( String s ) throws IOException ,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    /**
     * These method is used to rotate the array by given number. These method is called bubble rotate method
     * @param array
     * @param byNumber
     * @return array
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

    private void problemTwo(){
        int[] inputArray = {3,2,1};
        int[] outputArray = new int[inputArray.length];
        int index;
        int multiplication = 1;

        for(int i = 0 ; i < inputArray.length; i++){
            index = i;
            for(int j = 0; j < inputArray.length; j++){
                if(index != j){
                    multiplication = multiplication * inputArray[j];
                }
            }
            outputArray[i] = multiplication;
            multiplication = 1;
        }
        System.out.println(Arrays.toString(outputArray));
    }
}
