class Solution {
    public String solution(String my_string, int m, int c) {
        
        String answer = "";
        String[]arr = my_string.split("");
        
        for(int i=0; i*m+c-1<arr.length; i++){
            answer+=arr[i*m+c-1];    
        }
        return answer;
    }
}