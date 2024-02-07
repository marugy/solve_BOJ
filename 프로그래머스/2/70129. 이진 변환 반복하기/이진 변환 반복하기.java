class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(s.length()>1){
            int origin = s.length();
            s = s.replace("0","");
            int change = origin-s.length();
            answer[0]++;
            answer[1]+=change;
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}