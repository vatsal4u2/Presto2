public class FibonacciSeries {

    public void printFibonacci(){
        int count = 15;
        int[] fibonacci = new int[count];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i = 2; i < count; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        for (int i = 0 ;i< count;i++){
            System.out.print(fibonacci[i] + " ");
        }
    }
}
