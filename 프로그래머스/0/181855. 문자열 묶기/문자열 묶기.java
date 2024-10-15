class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[]count = new int[31];
        for(String str:strArr){
            int idx = str.length();
            count[idx]++;
            if(count[idx]>answer)answer=count[idx];
        }
        return answer;
    }
}