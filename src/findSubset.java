public class findSubset {

    public void findsubset(String str, int index, StringBuilder sb){
        if(index==str.length()) {
            System.out.println(sb.toString());
            return;
        }

        sb.append(str.charAt(index));
        findsubset(str, index+1, sb);
        //sb.deleteCharAt(sb.length()-1);
        findsubset(str, index+1, sb);
    }
//    public static void main(String[] args){
//        findSubset find = new findSubset();
//        StringBuilder sb = new StringBuilder();
//        find.findsubset("abc", 0, sb);
//    }
}
