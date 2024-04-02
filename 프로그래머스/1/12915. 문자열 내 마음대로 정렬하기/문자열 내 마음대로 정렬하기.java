import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b)->{
            if(a.toCharArray()[n] == b.toCharArray()[n]){
                return a.compareTo(b);
            }
            return a.toCharArray()[n] - b.toCharArray()[n];
        });
        return strings;
    }
}