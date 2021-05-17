import java.util.HashSet;
import java.util.Set;

public class suduku {

    boolean sudoku2(String[][] grid) {
        for(int i = 0; i<grid.length; i++){
            Set<String> set = new HashSet<>();
            for(int j = 0; j<grid[0].length; j++){
                if (set.contains(grid[i][j])) return  false;
                else if(grid[i][j]!=".") set.add(grid[i][j]);
            }
        }
        for(int i = 0; i<grid[0].length; i++){
            Set<String> set = new HashSet<>();
            for(int j = 0; j<grid.length; j++){
                if (set.contains(grid[j][i])) return  false;
                else if(grid[j][i]!=".") set.add(grid[j][i]);
            }
        }
        for(int i = 0; i<grid.length; i+=3){

            for(int j = 0; j<grid[0].length; j+=3){
                boolean flag = handleSquare(i,j, grid);
                if(!flag)return false;
            }
        }
        return true;
    }
    boolean handleSquare(int i , int j , String[][] grid){
        Set<String> set = new HashSet<>();
        for(int row = i; row<i+3; row++){
            for(int col = j; col<j+3; col++){
                if (set.contains(grid[row][col])) return  false;
                else if(grid[row][col]!=".") set.add(grid[row][col]);
            }
        }
        return true;
    }





//    public static void main(String[] args){
//        String[][] grid = new String[][]{
//                {".",".",".","1","4",".",".","2","."},
//                {".",".","6",".",".",".",".",".","."},
//                {".",".",".",".",".",".",".",".","."},
//                {".",".","1",".",".",".",".",".","."},
//                {".","6","7",".",".",".",".",".","9"},
//                {".",".",".",".",".",".","8","1","."},
//                {".","3",".",".",".",".",".",".","6"},
//                {".",".",".",".",".","7",".",".","."},
//                {".",".",".","5",".",".",".","7","."}};
//        suduku s = new suduku();
//        boolean a = s.sudoku2(grid);
//        System.out.println(a);
    //}
}
