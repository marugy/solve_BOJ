class Solution {
    public int solution(int n) {
        int answer = 0;
        int start=1,end=1, sum = 1;
        while(start <= n && end <= n){
            if(sum < n){
                sum += ++end;
            }else if(sum == n){
                answer++;
                sum += ++end;
                sum -= start++;
            }else{
                sum-=start++;
            }
        }
        return answer;
    }
}