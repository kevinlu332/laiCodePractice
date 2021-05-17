public class maxSquare {

    int maximalSquare(char[][] matrix) {
        if (matrix.length ==0 ) return 0;
        //down[i][j] represents: length of longest continuous 1's at column j from row 0 to row i (from up to down)
        //right[i][j] represents: length of longest continuous 1's at row i from col 0 to col j (from left to right);
        //combine[i][j]: for each cell, get min value
        //int maxEdgeLength = 0;
        //for(each row)
        //for each col
        //record combine[i][j] as combMin:
        //for( k at range: from 1 to combMin)
        // check()://square could appear as [i][j] as its lower right corner
        //j-k>=0 && down[i][j-k]>=combMin;
        //i-k>=0 && right[i-k][j]>=combMin;
        //if check() is no, break;
        //if check() is yes, update maxEdgeLength
        //return square(maxEdgeLength)
        int m =matrix.length;
        int n = matrix[0].length;
        int[][] intMatrix = new int[m][n];
        fillIntMatrix(intMatrix, matrix);
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        fillDownMatrix(down, intMatrix);
        fillRightMatrix(right, intMatrix);
        int[][] combine = new int[m][n];
        fillCombineMatrix(combine, down, right);
        int maxEdgeLength = 0;
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                int combMin = combine[i][j];//length of certain square
                for(int k = 0; k<combMin; k++){ //extra length beyond length 1 of this square
                    if(!check( down ,right, i, j, k)){
                        break;
                    }else{
                        maxEdgeLength = Math.max(k+1, maxEdgeLength);
                    }
                }
            }
        }
        return maxEdgeLength*maxEdgeLength;
    }
    void fillIntMatrix(int[][] intMatrix, char[][] matrix){
        for(int i = 0; i<intMatrix.length; i++){
            for(int j = 0; j<intMatrix[0].length ; j++){
                if(matrix[i][j]=='1') intMatrix[i][j]=1;
            }
        }
    }
    void fillDownMatrix(int[][] down, int[][] intMatrix){
        for(int i =0; i<down[0].length; i++){
            down[0][i] = intMatrix[0][i]==1? 1: 0;
        }
        for(int i = 0; i<intMatrix[0].length; i++){//col
            for(int j = 1; j<intMatrix.length; j++){//row
                if(intMatrix[j][i]==1) down[j][i] = down[j-1][i]+1;
                else down[j][i] = 0;
            }
        }
    }
    void fillRightMatrix(int[][] right, int[][] intMatrix){
        for(int i = 0; i<intMatrix.length; i++){
            right[i][0] = intMatrix[i][0] == 1 ? 1:0;
        }
        for(int i = 0; i<intMatrix.length; i++){//row
            for(int j = 1; j<intMatrix[0].length; j++){//col
                if(intMatrix[i][j]==1) right[i][j] = right[i][j-1]+1;
                else right[i][j] = 0;
            }
        }
    }
    void fillCombineMatrix(int[][] combine, int[][] down, int[][] right){
        for(int i = 0; i<combine.length; i++){
            for(int j = 0; j<combine[0].length; j++){
                combine[i][j] = Math.min(down[i][j], right[i][j]);
            }
        }
    }
    boolean check( int[][] down , int[][] right, int i, int j, int k){
        for(int col = j-k; col<=j; col++){
            if(col<0 || down[i][col]<k+1) return false;
        }
        for(int row = i-k; row<=i; row++){
            if(row<0 || right[row][j]<k+1) return false;
        }

        return true;
    }
//    public static void main(String[] args){
//        char[][] input = new char[][]{{'0','1','1','0','1'},
//                {'1','1','0','1','0'},
//        {'0','1','1','1','0'},
//    {'1','1','1','1','0'},
//        {'1','1','1','1','1'},
//        {'0','0','0','0','0'}};
//        char[][] input2 = new char[][]{ {'0','1','1','0','1'},
//                                        {'1','1','0','1','0'},
//                                        {'0','1','1','1','0'},
//                                        {'0','1','0','1','0'},
//                                        {'1','1','1','1','1'}};
//        maxSquare s = new maxSquare();
//        int res = s.maximalSquare(input2);
//        System.out.println(res);
//    }
}
