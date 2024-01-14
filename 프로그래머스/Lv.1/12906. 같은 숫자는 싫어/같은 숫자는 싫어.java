import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        int[] temp = new int[arr.length];
        temp[0]=arr[0];
        int count =1;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]){
                temp[count++]=arr[i];
            }
        }
        int[]answer = new int[count];
        for(int i=0;i<count;i++)
            answer[i] = temp[i];
        
        return answer;
    }
}