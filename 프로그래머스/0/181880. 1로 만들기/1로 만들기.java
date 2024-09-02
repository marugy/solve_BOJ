class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int val:num_list){
            int cnt = 0;
            while(val>1){
                if(val%2==0) val/=2;
                else val = (val-1)/2;
                cnt++;
            }
            answer+=cnt;
        }
        return answer;
    }
}