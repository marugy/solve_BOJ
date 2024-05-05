class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(int val : numbers){
            if(answer>n) return answer;
            answer+=val;
        }
        return answer;
    }
}