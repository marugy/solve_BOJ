class Solution {
    public int solution(String num_str) {
        String[] arr = num_str.split("");
        int answer = 0;
        for(String val : arr){
            answer+=Integer.parseInt(val);
        }
        return answer;
    }
}