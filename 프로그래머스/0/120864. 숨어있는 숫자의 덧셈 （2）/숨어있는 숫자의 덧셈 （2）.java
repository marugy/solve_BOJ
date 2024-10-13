class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[]arr = my_string.toCharArray();
        int tmp = 0;
        for(char ch : arr){
            if('0'<=ch && ch<='9'){
                tmp*=10;
                tmp+=ch-'0';
            }else{
                answer+=tmp;
                tmp=0;
            }
        }
        answer+=tmp;
        return answer;
    }
}