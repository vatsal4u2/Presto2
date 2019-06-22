import java.util.List;

public class FindDuplicateNumber {

    public int duplicateNumber(List<Integer> numbers){
       int highestNumber = numbers.size() - 1;
       int total =sum(numbers);
        return total - (highestNumber*(highestNumber+1)/2);
   }

    private int sum(List<Integer> array){
        int sum = 0;
        for(int val : array){
            sum = sum + val;
        }
        return sum;
    }
}

