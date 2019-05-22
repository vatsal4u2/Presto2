public class NumberFormatter {

    public static void main(String[] arg){

        String number = "13-5   3455 545 453 444";
        String hello = number.replaceAll("[^0-9]", "");
        System.out.println(hello);
        hello = hello.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        System.out.println(hello.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3"));


    }
}
