class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int a = 0;
        int tmp = x;
        while(tmp>0){
            a+=tmp%10;
            tmp/=10;
        }
        if(x%a!=0) answer = false;
        return answer;
    }
}