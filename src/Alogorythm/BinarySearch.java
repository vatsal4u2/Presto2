package Alogorythm;

public class BinarySearch {

    public static void main(String[] arg){

        BinarySearch  obj = new BinarySearch();
        int[] array = {2,3,5,10,49,50,76};
        int right =  array.length - 1;
        int element = 49;
        int elementPosition = obj.binarySearch(array,0,right,element);
        System.out.println("element present at = " + elementPosition);
    }

    public int binarySearch(int[] ary, int left, int right, int element){
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // If the element is present at the
            // middle itself
            if (ary[mid] == element)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (ary[mid] > element)
                return binarySearch(ary, left, mid - 1, element);

            // Else the element can only be present
            // in right subarray
            return binarySearch(ary, mid + 1, right, element);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }

    // Binary search with Sorted and rotated array.

    private int search(int[] array, int left, int right, int element){

        if(left > right){
            return -1;
        }
        int mid =  left + (right - left)/2;

        if(array[mid] == element){
            return element;
        }

        if(left < array[mid]){
            // left sub array is sorted array because mid element is higher then left low point
            if(element >= array[left] && element <= array[mid]){
                return search(array,left,mid-1,element);
            }
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(array,left,mid+1,element);
        }
        if (element >= array[mid] && element <= array[right])
            return search(array, mid+1, right, element);

        return search(array, left, mid-1, element);
    }
}
