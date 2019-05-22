public class FindDistanceInArray {
    public static void main(String[] arg){

        FindDistanceInArray obj =  new FindDistanceInArray();

        int[] temp = {8,-6,16,-8,6,-2,9,13,15,9,10};
        int position = obj.solution(temp);
        System.out.println(position);
    }

    int solution(int[] A) {

        int leftMax = A[0];     //  Max temperature during winter
        int maximum = A[0];     //  Max temperature during the year
        int position = 1;       //  Possible solution

        int n = A.length;

        for(int i = 1; i < n; i++) {
            if (A[i] < leftMax) {
                position = i+1;      // got a new lower value
                leftMax = maximum;
            } else if (A[i] > maximum) {
                maximum = A[i];
            }
        }
        return position;
    }
}

