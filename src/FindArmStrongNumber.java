public class FindArmStrongNumber {

    public void checkArmStrongNumber(int number){

        int tmp = number;
        int noOfDigits = String.valueOf(number).length();
        int sum = 0;
        int div = 0;
        while(tmp > 0)
        {
            div = tmp % 10;
            int temp = 1;
            for(int i=0;i<noOfDigits;i++){
                temp *= div;
            }
            sum += temp;
            tmp = tmp/10;
        }

        if(sum == number){
            System.out.println("\n");
            System.out.println(number + " Is a ArmStrong number");
        }else{
            System.out.println("\n");
            System.out.println(number + " Is not ArmStrong number");
        }
    }
}
