package DynamicProgramming;

import java.util.ArrayList;

public class MaxStockProfit {

    public static void main(String[] arg){

        int price[] = {1,2,3,4};


        MaxStockProfit obj =  new MaxStockProfit();
        // fucntion call
       long profit =  obj.maximize(price);

        System.out.println("Final profit "+ profit);
    }

     private int stockMax(int[] prices){

        if(prices.length == 1){
            return 0;
        }

        ArrayList<Interval> sol = new ArrayList<>();
        int count = 0;
        int i = 0;
        int n = prices.length;

        while (i < n - 1){
            // find minimum

            while ((i < n-1) && (prices[i+1] <= prices[i])){
                i++;
            }

            if(i == n-1){
                break;
            }
            Interval e = new Interval();
            e.buy = i++;

            System.out.println("min index - " + e.buy);

            while ((i < n) && (prices[i] >= prices[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            System.out.println("max index - " + e.sell);
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }


        int profit = 0;
         if (count == 0) {
             System.out.println("There is no day when buying the stock "
                     + "will make profit");
         }
         else
             for (int j = 0; j < count; j++){
                 profit = profit + prices[sol.get(j).sell] - prices[sol.get(j).buy];
                 System.out.println("Profit per transaction :" + profit);


             }


         return profit;
    }


    private long maximize(int[] priceList) {

        int maxSeenPrice = Integer.MIN_VALUE;
        long totalProfit = 0;
        for (int i = priceList.length - 1; i >= 0; i--) {
            if (priceList[i] < maxSeenPrice) {
                totalProfit += maxSeenPrice - priceList[i];
            } else {
                maxSeenPrice = priceList[i];
            }
        }
        return totalProfit;
    }


    private class Interval{
        int buy;
        int sell;
    }
}
