import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            if(arr[s]!=2)s++;
            if(arr[e]!=2)e--;
            if(arr[s]==2 && arr[e]==2)break;
        }
        if(arr[s]!=2) {
            int[] answer = {-1};
            return answer;
        }
        return Arrays.copyOfRange(arr, s, e+1);
    }
}