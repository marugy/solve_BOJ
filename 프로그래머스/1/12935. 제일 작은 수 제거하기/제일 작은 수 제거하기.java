import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        int[] answer;
        if(arr.length==1){
            answer = new int[1];
            answer[0]=-1;
            return answer;
        }
        answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(min > arr[i])min = arr[i];
        }
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(min!=arr[i]) answer[idx++]=arr[i];
        }
        return answer;
    }
}