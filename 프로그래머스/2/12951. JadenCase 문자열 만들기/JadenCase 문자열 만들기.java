class Solution {
    public String solution(String s) {
        String[] sArr = s.toLowerCase().split("");
        String answer = "";
        for(int i=0; i<sArr.length; i++){
            if(i==0 || sArr[i-1].equals(" ")){
                answer+= sArr[i].toUpperCase();
            }else{
                answer+= sArr[i];
            }
        }
        return answer;
    }
}