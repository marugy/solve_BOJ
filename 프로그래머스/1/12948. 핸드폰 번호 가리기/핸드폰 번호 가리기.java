class Solution {
    public String solution(String phone_number) {
        int leng = phone_number.length();
        String answer = "";
        for(int i=0; i<leng-4; i++) answer+="*";
        answer += phone_number.substring(leng-4, leng);
        return answer;
    }
}