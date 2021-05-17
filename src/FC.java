public class FC {
    boolean[][][] financialCrisis(boolean[][] roadRegister) {
        int m = roadRegister.length;
        boolean[][][] ans = new boolean[m][m - 1][m - 1];
        for (int i = 0; i < ans.length; i++) {
            int toRemove = 0;
            for (int j = 0; j < ans[0].length; j++) {
                int row = j < toRemove ? j : j + 1;
                for (int k = 0; k < ans[0][0].length; k++) {
                    int col = k < toRemove ? k : k + 1;
                    ans[i][j][k] = roadRegister[row][col];
                }
            }
            toRemove++;
        }
        return ans;
    }

//    public static void main(String[] args) {
//        boolean[][] input = new boolean[][]{{false, true, true, false},
//                {true, false, true, false},
//                {true, true, false, true},
//                {false, false, true, false}
//        };
//        FC sol = new FC();
//        sol.financialCrisis(input);
//
//
//    }
}
