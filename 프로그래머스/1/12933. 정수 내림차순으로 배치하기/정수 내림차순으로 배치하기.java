import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = (""+n).split("");
        Arrays.sort(arr, (a,b) -> {return Integer.parseInt(b)-Integer.parseInt(a);});
        String num = String.join("",arr);
        return Long.parseLong(num);
    }
}