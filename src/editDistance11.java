public class editDistance11 {

    public static int editDistance(String one, String two) {
        // Write your solution here
        //2D-Dp: base case: M[0][0]=0;
        //rule: M[i][i] represents the min operations needed
        //M[i][i] = M[i-1][i]
        int[][] M  = new int[one.length()+1][two.length()+1];
        for (int i = 0; i<=one.length(); i++){
            for (int j = 0; j<=two.length(); j++){
                if(i == 0)M[i][j] = j;
                else if(j == 0) M[i][j] = i;
                else if (one.charAt(i-1) == two.charAt(j-1)){
                    M[i][j] = M[i-1][j-1];
                }else{
                    M[i][j] = Math.min(Math.min(M[i-1][j], M[i][j-1]), M[i-1][j-1])+1;
                }

            }
        }
        return M[one.length()][two.length()];
    }

//    public static void main(String[] args){
//        int ans = editDistance("satisfactory", "satisfying");
//        System.out.println(ans);
//    }
}
