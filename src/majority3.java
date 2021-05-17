import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class majority3 {
    static class eleCount{
        Integer e;
        int count;
        public eleCount(Integer e, int count){
            this.e = e; this.count = count;
        }
    }
    public static List<Integer> majority(int[] array, int k) {
        // Write your solution here
        eleCount[] temp = new eleCount[k-1];
        for(int i = 0; i<temp.length; i++){
            temp[i]=new eleCount(null, 0);
        }
        //loop array to get every elem of array
        //loop temp: if(equal to elem) its count++;
        //if got to the end of temp
        //loop temp again to find eleCount.count==0
        //if found, that eleCount's e and count got replaced
        //if got to the end of temp: it means we found a aggragation
        //then, we loop the temp and everyone got count--;
        //loop temp:
        //int ac, loop array to calculate ac,
        //after loop, check ac>array.length/k
        for(int i = 0; i<array.length; i++){
            int curr = array[i];
            int j;
            for(j= 0; j<temp.length; j++){
                if(temp[j].e!=null && curr==temp[j].e) {
                    temp[j].count++;
                    break;
                }
            }
            if(j==temp.length){
                int l;
                for(l = 0; l<temp.length; l++){
                    if(temp[l].count==0){
                        temp[l].e = curr;
                        temp[l].count = 1;
                        break;
                    }
                }
                if(l == temp.length){
                    for(int m = 0; m<temp.length; m++){
                        temp[m].count--;
                    }
                }
            }
        }

        List<Integer> ansList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(eleCount ec: temp){
            int ac = 0;
            for(int x: array){if(ec.e!=null && x==ec.e)ac++;}
            if(ac> array.length / k){
                if(!set.contains(ec.e)){
                    ansList.add(ec.e);
                    set.add(ec.e);
                }

            }
        }
        return ansList;
    }

//    public static void main(String[] args){
//        int[] arr = new int[]{1,2,2};
//        List<Integer> ans;
//        //ans=  Solution.majority(arr, 3);
//        //for(int x: ans) System.out.print(x + " ");
//        System.out.println();
//        ans=  majority3.majority(arr, 4);
//        for(int x: ans) System.out.print(x + " ");
//        System.out.println();
//        System.out.println("ans: 1,2");
//    }
}
