import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String[] str1 = before.split("");
        String[] str2 = after.split("");
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i=0;i<str1.length;i++){
            if(!str1[i].equals(str2[i])){
                return 0;
            }
        }
        return 1;
    }
}