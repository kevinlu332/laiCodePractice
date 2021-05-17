import java.util.*;

public class decompression {

    public static String decompression(String input) {
        // sanity check
        char[] chs = input.toCharArray();
        int[] index = new int[]{0};
        return dfs(chs, index);
    }

    private static String dfs(char[] chs, int[] indexRef) {
        StringBuilder result = new StringBuilder();
        StringBuilder curLevelStr = new StringBuilder();
        String subLevelStr = new String();
        StringBuilder curLevelStr2 = new StringBuilder();
        int number = 0;

        while (indexRef[0] < chs.length) {
            char cur = chs[indexRef[0]];
            // case1: characters
            if (Character.isLetter(cur)) {
                result.append(cur);
                indexRef[0]++;
                while(indexRef[0] < chs.length && Character.isLetter(chs[indexRef[0]])) {
                    result.append(chs[indexRef[0]]);
                    indexRef[0]++;
                }
            }
            // case2: [
            else if (cur == '[') {
                indexRef[0]++;
                subLevelStr = dfs(chs, indexRef);
                result.append(subLevelStr);

            } else if (Character.isDigit(chs[indexRef[0]])) {
                // get number
                number = 0;
                while (indexRef[0] < chs.length && Character.isDigit(chs[indexRef[0]])) {
                    number = number * 10 + (chs[indexRef[0]] - '0');
                    indexRef[0]++;
                }
                // cur character is |
                indexRef[0]++;
                // characters
                while (indexRef[0] < chs.length && Character.isLetter(chs[indexRef[0]])) {
                    curLevelStr2.append(chs[indexRef[0]]);
                    indexRef[0]++;
                }
            } else {

                // char ]
                // calculate
                result = curLevelStr2.append(subLevelStr.toString());
                String tmp = result.toString(); // BCACA
                // multiply it by times
                while (number > 1) {
                    result.append(tmp);
                    number--;
                }
                indexRef[0]++;
                return result.toString();

            }
        }
        if (result.length() == 0) {
            return subLevelStr;
        }
        return result.toString();
    }






//    public static void main(String[] args) {
//        String input = "a[3|A]";
//        String input2 = "HG[3|B[2|CA]]F";
//        String input3 = "H[2|[2|[2|[2|[2|A]]]]]F";
//        System.out.println(decompression(input2));
//        System.out.println(decompression(input3));
//    }
}
