import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer>list = new ArrayList<>();
        for(String str: intStrs){
            int sub = Integer.parseInt(str.substring(s, s+l));
            if(sub>k) list.add(sub);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}