import java.util.ArrayList;
import java.util.List;

public class KeyPad {
    public static void main(String[] args) {
        List<String> s =letterCombinations("23");
        System.out.println(s);
    }    

    // public static List<String> helper(String p , String unp){
    //             if(unp.isEmpty()){
    //                 List<String> list = new ArrayList<>();
    //                 list.add(p);
    //                 return list;
    //             }
                
    //             int digit = unp.charAt(0) - '0';//this will conver '2' int 2
                
    //             List<String> list = new ArrayList<>();
                
    //             for(int i=(digit-1)*3; i < digit*3; i++){
    //                 char ch = (char)('a' + i);
    //                 list.addAll(helper(p +ch, unp.substring(1)));
    //             }
    //             return list;
    //         }
    static List<String> ans = new ArrayList();
    static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        
        combination("", digits);
        
        return ans;
    }
    public static void combination(String process, String unprocess){
        if(unprocess.length() == 0){   // one combination is done
            ans.add(process);
            return;
        }
        
        
        int ch = unprocess.charAt(0) - '0';//1st char of digit
        
        String str = mapping[ch]; // string of 1st num/char in digit
        
        for(int i=0;i<str.length();i++){
            
            process += str.charAt(i);
            
            combination(process,unprocess.substring(1));// backTrack for combination of each letter in another digit string
            
            process = process.substring(0,process.length() - 1); // last added char is removed from string
        }
    }
}
