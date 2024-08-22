import java.util.*;

class Solution {
    public String solution(String my_string) {
        String str = my_string.toLowerCase();
        String[] arr = str.split("");
        Arrays.sort(arr);
        return String.join("",arr);
    }
}