public class FindMaxNumberFromArray {

    public void findMaxTwoNumber(int[] array){
        int maxOne = 0;
        int maxtwo = 0;
        for(int n : array){
            if(maxOne < n){
                maxtwo = maxOne;
                maxOne = n;
            }else if(maxtwo < n){
                maxtwo = n;
            }
        }
    }

}



