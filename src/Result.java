import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Cell{
    int id;
    int count;
    Cell(int id, int count){
        this.id = id;
        this.count = count;
    }
}
class Result {

    /*
     * Complete the 'deleteProducts' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ids
     *  2. INTEGER m
     */

    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        if(m>=ids.size())return 0;
        Map<Integer, Integer> map = new HashMap<>();// id, count;
        for(int id: ids){
            map.put(id, map.getOrDefault(id, 0)+1);
        }
        Cell[] arr = new Cell[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Cell cc = new Cell(5,3);
            arr[i++] = cc;
        }
        Arrays.sort(arr, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                return Integer.compare(c1.count, c2.count);
            }
        });
        int remain = arr.length;
        i = 0;
        while(m>0){
            int count = arr[i].count;
            if(count<=m){
                i++;
                m-=count;
                remain--;
            }else break;
        }
        return remain;
    }

}
