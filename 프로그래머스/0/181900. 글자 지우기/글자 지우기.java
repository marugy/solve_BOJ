import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] arr = my_string.split("");
        for(int i=0;i<indices.length; i++){
            arr[indices[i]] = "";
        }
        answer = String.join("", arr);
        return answer;
    }
}