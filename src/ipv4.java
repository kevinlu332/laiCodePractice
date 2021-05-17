public class ipv4 {

    static boolean isIPv4Address(String inputString) {
        char[] arr = inputString.toCharArray();
        int slow = 0;
        int fast = 0;
        int  doccount =0;
        while(fast<arr.length){
            int num = 0;
            if(arr[fast]=='.' || Character.isLetter(arr[fast]))return  false;
            while(fast<arr.length && arr[fast]!='.'){
                if( Character.isLetter(arr[fast]))return  false;
                num=num*10+Character.getNumericValue(arr[fast]);
                if(num==0 ){
                    if(fast+1!=arr.length ){
                        if(arr[fast+1]!='.')return false;
                    }
                }
                fast++;
            }
            if(fast!=arr.length) doccount++;
            if(num>255 )return false;
            fast++;
            slow = fast;
        }
        if(doccount!=3)return false;
        return true;
    }

//    public static void main(String[] args){
//        isIPv4Address("0.254.255.0");
//    }

}
