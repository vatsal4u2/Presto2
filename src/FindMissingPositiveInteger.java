import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingPositiveInteger {
    int[] array = {3,4,-1,1};
    Set<Integer> set = new HashSet<>();


    public int findMissingInt(){
        for (int a: array) {
            set.add(a);
        }
        int i = 1;
        while (set.contains(i)){
            i += 1;
        }
        return i;
    }

}
