import java.util.List;

public class FindDuplicateNumber {

    public int duplicateNumber(List<Integer> numbers){
       int highestNumber = numbers.size() - 1;
       int total =sum(numbers);
       int duplicate = total - (highestNumber*(highestNumber+1)/2);
       return duplicate;
   }

    private int sum(List<Integer> array){
        int sum = 0;
        for(int val : array){
            sum = sum + val;
        }
        return sum;
    }
}

