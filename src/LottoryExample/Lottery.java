package LottoryExample;
import java.util.*;


class Lottery{

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Integer> randomNumbers = new ArrayList<>();

    void buyTickets(){

        customers.add(new Customer("Vatsal",3,5,7,9,10,11,13));
        customers.add(new Customer("Varun",2,4,6,8,10,12,14));
        customers.add(new Customer("Krunal",1,5,3,2,20,18,17));
        customers.add(new Customer("Tirth",1,2,3,5,6,7,8));
        customers.add(new Customer("Sujal",9,10,11,12,13,14,15));
        customers.add(new Customer("Satyam",21,23,24,7,6,5,4));
    }

    void generateRandomNumber(){
        Random random = new Random();
        for(int i = 1;i<= 7; i++){
            randomNumbers.add(random.nextInt(50)+1);
        }

        System.out.println(randomNumbers);
    }

    void result(){

        for(Customer customer :customers){
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayList<Integer> tempNumber = new ArrayList<>();
            tempNumber.addAll(randomNumbers);
            System.out.println("TempNumber" + tempNumber);
            temp.add(customer.num1);
            temp.add(customer.num2);
            temp.add(customer.num3);
            temp.add(customer.num4);
            temp.add(customer.num5);
            temp.add(customer.num6);
            temp.add(customer.num7);
            System.out.println(temp);

            tempNumber.retainAll(temp);
            System.out.println(tempNumber);

        }
    }

}
