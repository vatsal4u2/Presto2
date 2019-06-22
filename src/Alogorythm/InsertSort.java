package Alogorythm;

public class InsertSort {

    public static void main(String[] arg){
       int[] array = {10,5,3,7,15,20};
       InsertSort obj =  new InsertSort();
       int[] resultArray = obj.sortArray(array);
       for(int i = 0; i < resultArray.length; i++){
           System.out.println(resultArray[i]);
       }
    }

    private int[] sortArray(int[] sortArray){
            int n = sortArray.length;
            for (int i=1; i<n; ++i)
            {
                int value = sortArray[i];
                int j = i-1;  // index pointer

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j>=0 && sortArray[j] > value)
                {
                    sortArray[j+1] = sortArray[j];
                    j = j-1;
                }
                sortArray[j+1] = value;
        }

       return sortArray;
    }
}
