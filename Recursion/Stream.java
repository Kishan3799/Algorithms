import java.util.ArrayList;

public class Stream {
    public static void main(String[] args) {
    //    System.out.println( skipString(st));
    // subSeq(" ", st);
    // System.out.println(subSeqSet(" ", "abc"));

    // char ch = 'A';
    // System.out.println(ch + 0);

    String s = "abc";
    String t = "ahbgdc";
    System.out.println( isSubSequence(s,t) );
    }

    //Skip the character by recursion
    public static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        
        if(ch == 'a'){
            skip(p, up.substring(1));
        }
        else {
            skip(p + ch, up.substring(1));
        }
    }


    public static String skipRet(String up){
        if(up.isEmpty()){
            return " ";
        }

        char ch = up.charAt(0);
        
        if(ch == 'a'){
            return skipRet(up.substring(1));
        }
        else {
            return ch + skipRet( up.substring(1));
        }
    }


    public static String skipString(String up){
        if(up.isEmpty()){
            return " ";
        }
        
        if(up.startsWith("apple")){
            return skipString(up.substring(5));
        }
        else {
            return up.charAt(0) + skipString( up.substring(1));
        }
    }

    //SubSet of string
    public static void subSeq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSeq(p, up.substring(1));
        subSeq(p+ch, up.substring(1));
    }

    public static ArrayList<String> subSeqSet(String p,String up){
        if(up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list; 
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subSeqSet(p + ch, up.substring(1));
        ArrayList<String> right = subSeqSet(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    public static boolean isSubSequence(String s, String t) {
        if(s.length() == 0) return true;
        int j=0;
        for(int i=0; i<t.length() && j<s.length(); i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
        }
        return j==s.length();
    }
    


}