class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        for(int i=1;i<=count;i++){
            answer-=i*price;
        }
        if(answer>=0) return 0;
        else return -1*answer;
    }
}