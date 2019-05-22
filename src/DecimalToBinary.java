public class DecimalToBinary {

    public void convertDesiToBin(int number){
        int bin[] = new int[25];
        int index = 0;
        while (number > 0){
            bin[index++] = number%2;
            number = number/2;
        }

        for (int i = index -1; i >= 0; i--){
            System.out.print(bin[i]);
        }
    }
}

