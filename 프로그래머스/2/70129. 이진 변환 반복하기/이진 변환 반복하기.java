class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length()>1){
            int origin = s.length();
            s = s.replace("0","");
            answer[0]++;
            answer[1]+=origin-s.length();
            s = Integer.toBinaryString(s.length());
        }
        return answer;
    }
}