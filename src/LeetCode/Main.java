package LeetCode;
import javax.swing.plaf.IconUIResource;
import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<String> set = new HashSet<>();
        int n=s.length();

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    if(s.charAt(i)==s.charAt(k)){
                        StringBuilder str = new StringBuilder("");
                        str.append(s.charAt(i)).append(s.charAt(j)).append(s.charAt(k));
                        set.add(str.toString());
                    }
                }
            }
        }

        HashSet<String> set1 = new HashSet<>();
        for(int i=0;i<n-2;i++){
            HashSet<String> tset = new HashSet<>();
            tset.add(""+s.charAt(i)+s.charAt(i+1));
            for(int j=i+2;j<n;j++){
                if(s.charAt(i)!=s.charAt(j)){
                    tset.add(""+s.charAt(i)+s.charAt(j));
                }
                else{
                    set1.addAll(tset);
                    break;
                }
            }
        }

        for(String st:set1){
            if(!set.contains(st)) System.out.println(st);
        }

        return set1.size();
    }
    public int result(String s){
        int n=s.length();
        boolean[] set1 = new boolean[26];
        int count=0;
        for(int i=0;i<n-2;i++){
            char ch1 = s.charAt(i);
            int indI = ch1 - 'a';
            if(!set1[indI]){
                set1[indI] = true;
                boolean[] set2 = new boolean[26];
                int tCount = 0;
                for(int j=i+1;j<n;j++){
                    char ch2 = s.charAt(j);
                    int indJ = (int)(ch2-'a');

                    if(ch1==ch2){
                        count += tCount;
                        tCount = 0;
                    }

                    if(!set2[indJ]){
                        set2[indJ] = true;
                        tCount++;
                    }
                }
            }
        }
        return count;

    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String string = "tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp";
        System.out.println(s.result(string));
    }

}
