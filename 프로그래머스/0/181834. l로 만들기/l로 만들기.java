class Solution {
    public String solution(String myString) {
        char[] arr = myString.toCharArray();
        String answer = "";
        for(int i=0;i<arr.length;i++){
            if(arr[i]<='l') answer+="l";
            else answer+=""+arr[i];
        }
        return answer;
    }
}