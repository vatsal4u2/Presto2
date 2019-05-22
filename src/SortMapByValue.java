import java.util.*;

public class SortMapByValue {

    public void sortMapByValue(){
        Map<String,Integer> map = new HashMap<>();
        map.put("Java",10);
        map.put("C#",38);
        map.put("C",45);
        map.put("C++",83);
        map.put("Swift",100);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String,Integer> entry: list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    }
}
