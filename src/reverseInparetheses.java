public class reverseInparetheses {
    static String reverseInParentheses(String inputString) {
        if(inputString.length()==0)return inputString;
        char[] arr = inputString.toCharArray();
        int[] start_idx = new int[]{0};
        ///////////////////////////////
        reverse(arr, start_idx);

        return removeParentheses(arr);
    }
    static void reverse(char[] arr, int[] start_idx){
        while(start_idx[0]<arr.length){
            if(arr[start_idx[0]]=='('){
                int left =  start_idx[0]; // (
                start_idx[0]++;
                reverse(arr, start_idx);

                int right=  start_idx[0]-1; // )
                swap(arr, left, right);
            }else if(Character.isLetter(arr[start_idx[0]])){
                start_idx[0]++;
//                    while(start_idx[0]<arr.length && arr[start_idx[0]]!=')'){ /////////////////////
//                        while(start_idx[0]<arr.length && Character.isLetter(arr[start_idx[0]])){
//                            start_idx[0]++;
//                        }
//                        if(start_idx[0]<arr.length && arr[start_idx[0]]=='(' ) reverse(arr, start_idx);///////////////////////////////
//                    }
//                    start_idx[0]++;
            }else if(arr[start_idx[0]]==')'){
                start_idx[0]++;
                return;
            }

        }

    }
    static String removeParentheses(char[] arr){
        int left = 0;
        int right=  0;
        while(right<arr.length){
            if(Character.isLetter(arr[right])){
                arr[left++] = arr[right++];
            }else right++;
        }
        return new String(arr, 0, left);
    }
    static void swap(char[] arr, int i, int j ){
        while(i<j){ /////////////////////////
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
//    public static void main(String[] args){
//        //String ans = reverseInParentheses("(ab(cd))");
//        //System.out.println(ans);
//        String ans2 = reverseInParentheses("(ab(c(efg)d))");
//        System.out.println("my ans: (ab(c(efg)d)) -> "+ ans2);
//        System.out.println("(ab(c(efg)d))->(ab(cgfed))->(abdefgc)->cgfedba");
//        String ans3 = reverseInParentheses("(ab)c");
//        System.out.println("my ans: (ab)c -> "+ ans3);
//        System.out.println("should be: bac");
//        String ans4 = reverseInParentheses("(ab(c(efg)d)hi)");
//        System.out.println("my ans: (ab(c(efg)d)hi) -> "+ ans4);
//        System.out.println("(ab(c(efg)d)hi)->(ab(cgfed)hi)->(abdefgchi)->ihcgfedba");
//        String ans5 = reverseInParentheses("ab(c(efg)d)hi");
//        System.out.println("my ans: ab(c(efg)d)hi -> "+ ans5);
//        System.out.println("ab(c(efg)d)hi->ab(cgfed)hi->abdefgchi");
//    }




}
