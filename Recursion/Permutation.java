import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        // permutation("", "abc");
        System.out.println(permutationList("", "abcd"));
    }

    //Permutation and combination
    public static void permutation(String p, String unp){
        if(unp.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = unp.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s , unp.substring(1));
        }
    } 

    //Retruning a List
    public static ArrayList<String> permutationList(String p, String unp){
        if(unp.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        char ch = unp.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationList(f + ch + s , unp.substring(1)));
        }

        return ans;
    } 


}
