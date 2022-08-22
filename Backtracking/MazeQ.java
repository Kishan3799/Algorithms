import java.util.ArrayList;
public class MazeQ {
    public static void main(String[] args) {
        // System.out.println(countWays(3, 3));
        // System.out.println(pathWaysRet("",3, 3));
        pathWaysDiagnal("", 3, 3);
    }

    public static int countWays(int r, int c){
        if(r==1 && c==1){
            return 1;
        }

        int left = countWays(r-1, c);
        int right = countWays(r, c-1);

        return left+right;

    }

    public static void pathWays(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            pathWays(p + "D", r-1, c);
        }
        if(c > 1){
            pathWays(p + "R", r, c-1);
        }
    }


    public static ArrayList<String> pathWaysRet(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list; 
        }
        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(pathWaysRet(p+"D" , r-1, c));
        }
        if(c > 1){
            list.addAll(pathWaysRet(p + "R", r, c-1));
        }

        return list;
    }

    public static void pathWaysDiagnal(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        
        if(r > 1){
            pathWaysDiagnal(p + "D", r-1, c);
        }

        if(r>1 && c>1){
            pathWaysDiagnal(p, r-1, c-1);
        }
        if(c > 1){
            pathWaysDiagnal(p + "R", r, c-1);
        }
    }

    
}