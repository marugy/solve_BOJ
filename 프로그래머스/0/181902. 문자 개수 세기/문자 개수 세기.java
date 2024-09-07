class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] arr = my_string.toCharArray();
        for(char ch:arr){
            if('a'<=ch && ch<='z'){
                answer[26+ch-'a']++;                
            }else{
                answer[ch-'A']++;
            }

        }
        return answer;
    }
}