public class SearchinShiftedSortedArrayI {
    public static int search(int[] array, int target) {
        // Write your solution here
        //find mid; if(mid number < last number)search left side
        //else search right side
        //if target<last elem: search from minElem to last number
        //else search from start elem to minElem -1
        if(array==null || array.length==0)return -1;
        int left = 0, right = array.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(array[mid]<array[array.length-1])right = mid;
            else left = mid+1;
        }
        int minElemIndex =left;
        if(target<array[array.length-1])right = array.length-1;
        else if(target>array[array.length-1]) {
            left = 0;
            right = minElemIndex-1;
        }else return array.length-1;
        ////////
        while(left<right){
            int mid = left+(right-left)/2;
            if(array[mid]<target)left = mid+1;
            else if(array[mid]==target) return mid;
            else right = mid-1;
        }
        return -1;
    }

//    public static void main(String[] args){
//        int[] arr = new int[]{1,2};
//        int target = 2;
//        int ans = search(arr, target);
//        System.out.println(ans);
//    }
}
