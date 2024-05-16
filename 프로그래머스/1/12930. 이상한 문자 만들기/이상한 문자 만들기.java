class Solution {
    public String solution(String s) {
        String[] answer = s.split("");
        int idx = 0;
        for(int i=0; i<answer.length; i++){
            if(answer[i].equals(" ")){
                idx=0;
                continue;
            }
            if(idx%2==0) answer[i]=answer[i].toUpperCase();
            else answer[i]=answer[i].toLowerCase();
            idx++;
        }
        return String.join("",answer);
    }
}