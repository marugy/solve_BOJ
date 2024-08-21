import java.util.*;
class Solution {
    public int solution(int[] date1, int[] date2) {
        Date one = new Date(date1[0],date1[1],date1[2]);
        Date two = new Date(date2[0],date2[1],date2[2]);
        if(one.compareTo(two)>=0) return 0;
        return 1;
    }
}