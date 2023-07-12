import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
    int []answer = {0,0};

        int start = 0;
        int end = 0;
        int cnt = 0; //현재 담은 원소 수
        int minCnt = Integer.MAX_VALUE;
        int sum = 0; // 현재 담은 수열의 합
        int minStart = 0;
        int minEnd = 0;

        while(true){
            if(end==sequence.length && sum<k) break;
            
            if(sum<k){
                sum += sequence[end++];
                cnt++;
            }else if(sum>k){
                sum-=sequence[start++];
                cnt--;
            }
            else if(sum==k){
                if(cnt < minCnt){
                    minCnt = cnt;
                    minStart = start;
                    minEnd = end-1;
                }
                sum-=sequence[start++];
                cnt--;
            }
        }
        
        answer[0] = minStart;
        answer[1] = minEnd;
        return answer;
    }

}