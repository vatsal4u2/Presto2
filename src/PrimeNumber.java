import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

class PrimeNumber {

    int checkIfPrime(int number){

        for(int i = 2; i < number/2 ; i++){
            if(number % i == 0){
                //System.out.println(number + "Given number is not prime number");
                return 0;
            }else{
               // System.out.println(number + "Given number is prime number");
                return number;
            }
        }
        return 0;
    }

    public void findPrimeNumberInHundred(){
        ArrayList<Integer> primeNumber = new ArrayList<>();
        for(int i = 2; i <= 100 ; i++){
            int prime = checkIfPrime(i);
            if(prime > 0){
                primeNumber.add(prime);
            }
        }
        System.out.println("\n");
        System.out.println(Arrays.toString(primeNumber.toArray()));
    }
}
