package Alogorythm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetExample {
    public static void main(String[] arg){
        List<Integer> quantities = new ArrayList<>();

        quantities.add(20);
        quantities.add(19);

        List<Integer> cost = new ArrayList<>();

        cost.add(24);
        cost.add(20);

        int n = 50;
        int out = BudgetExample.budgetShopping(n,quantities,cost,new HashMap<>());
        System.out.println(out);


    }

    public static int budgetShopping(int n, List<Integer> quantities,List<Integer> cost, Map<Integer,Integer> map){

        while (n < 0){
            return 0;
        }

        if(!map.containsKey(n)){
            int max = 0;
            for(int i = 0; i < quantities.size();i++){
                if(n > cost.get(i)){
                    max = Math.max(max,quantities.get(i) + budgetShopping(n - cost.get(i),quantities,cost,map));
                }
            }
            map.put(n,max);

        }
        return map.get(n);
    }
}
