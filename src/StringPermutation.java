import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static List<String> permutedString(String input){

        List<String> strList = new ArrayList<String>();
       permutations("", input, strList);
        return strList;
    }

    private static void permutations(String consChars, String input, List<String> opContainer) {

        if(input.isEmpty()) {
            opContainer.add(consChars+input);
            return;
        }

        for(int i=0; i<input.length(); i++) {
            permutations(consChars+input.charAt(i),
                    input.substring(0, i)+input.substring(i+1),
                    opContainer);
        }
    }
}
