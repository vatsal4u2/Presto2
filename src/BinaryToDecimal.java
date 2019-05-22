public class BinaryToDecimal {

    public void binaryToDecimal(int binary) {
        int deci = 0;
        int power = 0;
        while (true){
            if(binary == 0){
                break;
            }else{
               int temp = binary % 10;
                deci += temp  * Math.pow(2,power);
               binary =  binary/10;
                power++;
            }
        }

        System.out.println(binary + " To decimal " + deci);
    }
}
