public class LongestWordInString {

    public static void main(String[] arg){
        LongestWordInString ob = new LongestWordInString();
        System.out.println( ob.longWord("Vatsal Patel"));
    }

    private String longWord(String inputString){
        String[] words =inputString.toLowerCase().split("[^A-Za-z0-9]");
        int maxIndex = 0;
        for(int i = 0; i<words.length;i++){
            if(words[i].length() > words[maxIndex].length()){
                maxIndex = i;
            }
        }
        return words[maxIndex];
    }
}
