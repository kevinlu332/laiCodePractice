public class simplifyPath {

    static String simplifyPath1(String path) {
        //
        //if(..) i+3
        //else if ., i+2
        //else if /: if(i < && i+1 == /) i++;
        //else arr[slow] = arr[i];
        char[] arr = path.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast<arr.length){
            if(arr[fast]=='.'){
                if(fast+1<arr.length && arr[fast+1]=='.') {
                    fast+=3; slow-=2;
                    if(slow<1) slow = 1;
                }
                else if(fast+1<arr.length &&arr[fast+1]!='.') fast+=2;

            }
            else if(arr[fast]=='/'){
                arr[slow++] = arr[fast++];
                while(fast<arr.length && arr[fast]=='/') fast++;

            }else arr[slow++] = arr[fast++];
        }
        return new String(arr, 0, slow);
    }

//    public static void main(String[] args){
//        String str1 = "/home/a/./x/../b//c/";
//        String ans = simplifyPath1(str1);
//        System.out.println(ans);
//    }
}
