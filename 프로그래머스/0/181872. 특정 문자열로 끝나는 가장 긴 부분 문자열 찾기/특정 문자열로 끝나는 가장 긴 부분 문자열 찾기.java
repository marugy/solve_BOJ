class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i=myString.length()-pat.length(); i>=0; i--){
            if(pat.equals(myString.substring(i,i+pat.length()))){
                return myString.substring(0,i+pat.length());
            }
        }
        return answer;
    }
}