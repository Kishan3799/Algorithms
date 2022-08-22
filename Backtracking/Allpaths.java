import java.util.Arrays;

public class Allpaths {
    public static void main(String[] args) {
        boolean[][] board= {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };

        // allPaths("", board, 0, 0);

        int [][] path = new int[board.length][board[0].length];
        allPathsPrints("", board, 0, 0, path, 1);
    }

    static void allPaths(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }


        if(!maze[r][c]){
            return;
        }

        // i am considering this block in path
        maze[r][c] = false;
        if(r < maze.length-1){
            allPaths(p + "D",maze, r+1, c);
        }
        if(c < maze[0].length-1){
            allPaths(p + "R",maze, r, c+1);
        }
        if(r>0){
            allPaths(p + "U", maze, r-1, c);
        }
        if(c>0){
            allPaths(p + "L", maze, r, c-1);
        }

        // this line is where the function will be over
        // so before the functions gets removed,also removed the changes that where made by the functions
        maze[r][c] = true;
    }


    static void allPathsPrints(String p, boolean[][] maze, int r, int c, int[][] path, int steps){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=steps;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));;
            }
            System.out.println(p);
            System.out.println();
            return;
        }


        if(!maze[r][c]){
            return;
        }

        // i am considering this block in path
        maze[r][c] = false;
        path[r][c] = steps;
        if(r < maze.length-1){
            allPathsPrints(p + 'D',maze, r+1, c,path, steps +1);
        }
        if(c < maze[0].length-1){
            allPathsPrints(p + 'R',maze, r, c+1,path, steps +1);
        }
        if(r > 0){
            allPathsPrints(p + 'U', maze, r-1, c,path, steps +1);
        }
        if(c > 0){
            allPathsPrints(p + 'L', maze, r, c-1,path, steps +1);
        }

        // this line is where the function will be over
        // so before the functions gets removed,also removed the changes that where made by the functions
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
