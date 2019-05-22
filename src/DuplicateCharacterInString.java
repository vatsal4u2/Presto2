import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class DuplicateCharacterInString {

    void findDuplicateCharacter(String str){
        Map<Character,Integer> dup = new HashMap<>();
        char[] characters = str.toCharArray();
        for(Character ch : characters){
            if(dup.containsKey(ch)){
                dup.put(ch,dup.get(ch)+1);
            }else{
                dup.put(ch,1);
            }
        }

        Set<Character> set = dup.keySet();
        for (Character ch : set){
            if(dup.get(ch) > 1){
                System.out.println("\n");
                System.out.println(ch+"--->"+dup.get(ch));
            }
        }
    }
}
