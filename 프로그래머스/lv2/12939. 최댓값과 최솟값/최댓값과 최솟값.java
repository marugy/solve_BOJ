import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        String[] arr = s.split(" ");
        Integer[] tmp = new Integer[arr.length];
        
        for(int i = 0 ; i<arr.length; i++){
            tmp[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(tmp);

        sb.append(tmp[0]).append(" ").append(tmp[tmp.length-1]);
        
        return sb.toString();
    }
}